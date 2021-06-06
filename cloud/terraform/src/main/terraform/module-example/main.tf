provider "kubernetes" {
  config_path = "~/.kube/config"
}

module "pkslow-nginx" {
    source = "./nginx-kubernetes"
    namespace = "pkslow"
    applicationName = "pkslow-nginx"
    image = var.image
    replicas = var.replicas
    nodePort = var.nodePort
}

