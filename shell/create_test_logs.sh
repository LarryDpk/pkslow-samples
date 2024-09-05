#!/bin/bash

# Configuration
LOG_DIR="/opt/larry/logs"
NUM_DAYS=15  # Number of days to create logs for (you can adjust this)

# Create log directory if it doesn't exist
mkdir -p "$LOG_DIR"

# Create subfolders for the past NUM_DAYS
for i in $(seq 0 $((NUM_DAYS - 1))); do
  folder_name=$(date -d "-$i day" "+%Y%m%d")
  folder_path="$LOG_DIR/$folder_name"

  # Create the folder
  mkdir -p "$folder_path"

  # Simulate a log file in the folder
  echo "Log data for $folder_name" > "$folder_path/log.txt"
done

echo "Test log folders created successfully in $LOG_DIR"
