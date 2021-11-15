provider "google" {
  project     = "pkslow"
}

resource "google_compute_instance" "test" {
  name         = "pkslow-test"
  machine_type = "e2-micro"
  zone         = "us-west1-a"

  tags = ["http-server", "https-server"]

  boot_disk {
    initialize_params {
      image = "projects/centos-cloud/global/images/centos-8-v20211105"
    }
  }


  network_interface {
    network = "default"

    access_config {
      // Ephemeral public IP
    }
  }

  metadata = {
    foo = "bar"
  }

  metadata_startup_script = "echo hi > /test.txt"

  service_account {
    # Google recommends custom service accounts that have cloud-platform scope and permissions granted via IAM Roles.
    email  = "admin-for-all@pkslow.iam.gserviceaccount.com"
    scopes = ["cloud-platform"]
  }
}