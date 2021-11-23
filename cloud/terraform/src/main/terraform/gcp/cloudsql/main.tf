provider "google" {
  project     = "pkslow"
}

resource "google_sql_database_instance" "instance" {
  name             = "pkslow-postgresql"
  region           = "us-west1"
  database_version = "POSTGRES_13"
  settings {
    tier = "db-f1-micro"

    ip_configuration {
          ipv4_enabled = "true"

          authorized_networks {
            value           = "0.0.0.0/0"
            name            = "allow-all"
            expiration_time = "2099-01-01T00:00:00.000Z"
          }

        }
  }

  deletion_protection  = "true"
}

resource "google_sql_database" "database" {
  name     = "billing"
  instance = google_sql_database_instance.instance.name
}

resource "google_sql_user" "users" {
  name     = "larry"
  instance = google_sql_database_instance.instance.name
  password = "larry.pass"
}