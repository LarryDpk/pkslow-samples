resource "kubernetes_deployment" "test" {
  metadata {
    name      = var.applicationName
    namespace = var.namespace
  }
  spec {
    replicas = var.replicas
    selector {
      match_labels = {
        app = var.applicationName
      }
    }
    template {
      metadata {
        labels = {
          app = var.applicationName
        }
      }
      spec {
        container {
          image = var.image
          name  = "nginx-container"
          port {
            container_port = 80
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "test" {
  metadata {
    name      = var.applicationName
    namespace = var.namespace
  }
  spec {
    selector = {
      app = var.applicationName
    }
    type = "NodePort"
    port {
      node_port   = var.nodePort
      port        = 80
      target_port = 80
    }
  }

  depends_on = [kubernetes_deployment.test]
}