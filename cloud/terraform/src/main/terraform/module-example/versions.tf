terraform {
  required_version = "= v0.15.4"

  required_providers {
    kubernetes = {
          source  = "hashicorp/kubernetes"
          version = "= 2.2.0"
        }
    docker = {
          source = "kreuzwerker/docker"
          version = "= 2.12.2"
        }
  }
}