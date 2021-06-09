terraform {
  required_version = "= v0.15.4"

  required_providers {
    local = {
          source  = "hashicorp/local"
          version = "= 2.1.0"
        }
  }
}

resource "local_file" "pkslow" {
    content     = "www.pkslow.com\nHello, pkslower!"
    filename = "${path.module}/pkslow.txt"
}