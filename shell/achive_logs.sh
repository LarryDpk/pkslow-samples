#!/bin/bash

# Configuration
LOG_DIR="/opt/larry/logs"
ARCHIVE_DIR="/opt/larry/archive"
LOG_FILE="/opt/larry/logs_archive.log"
RETENTION_DAYS=10  # Default retention days
REMOVE_ONLY=false


# Function to log messages
log_message() {
  current_time=$(date "+%Y-%m-%d %H:%M:%S")
  echo "[$current_time] $1"
  echo "[$current_time] $1" >> "$LOG_FILE"
}

# Parse arguments
while [[ "$#" -gt 0 ]]; do
    case $1 in
        --remove) REMOVE_ONLY=true ;;
        --days) RETENTION_DAYS="$2"; shift ;;
        *) echo "Unknown parameter passed: $1"; exit 1 ;;
    esac
    shift
done

# Create archive directory if it doesn't exist
mkdir -p "$ARCHIVE_DIR"

# Get the current date and time for logging
current_time=$(date "+%Y-%m-%d %H:%M:%S")

# Write starting log
echo "[$current_time] Archiving process started. Retention days: $RETENTION_DAYS" >> "$LOG_FILE"

# Find subfolders older than RETENTION_DAYS
folders_to_process=$(find "$LOG_DIR" -mindepth 1 -maxdepth 1 -type d -printf "%P\n" | sort | head -n -"$RETENTION_DAYS")

for folder in $folders_to_process; do
  if [ "$REMOVE_ONLY" = true ]; then
    # Remove folder
    rm -rf "$LOG_DIR/$folder"
    current_time=$(date "+%Y-%m-%d %H:%M:%S")
    echo "[$current_time] Removed $folder." >> "$LOG_FILE"
  else
    # Archive folder
    tar -czf "$ARCHIVE_DIR/$folder.tar.gz" -C "$LOG_DIR" "$folder"

    # Check if the archive was successful
    if [ $? -eq 0 ]; then
      rm -rf "$LOG_DIR/$folder"
      current_time=$(date "+%Y-%m-%d %H:%M:%S")
      echo "[$current_time] Archived and removed $folder." >> "$LOG_FILE"
    else
      current_time=$(date "+%Y-%m-%d %H:%M:%S")
      echo "[$current_time] Failed to archive $folder." >> "$LOG_FILE"
    fi
  fi
done

# Write completion log
current_time=$(date "+%Y-%m-%d %H:%M:%S")
echo "[$current_time] Archiving process completed." >> "$LOG_FILE"
