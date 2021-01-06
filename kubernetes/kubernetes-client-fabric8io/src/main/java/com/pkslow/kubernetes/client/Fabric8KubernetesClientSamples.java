package com.pkslow.kubernetes.client;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;


public class Fabric8KubernetesClientSamples {
    public static void main(String[] args) {
//        KubernetesClient client = getDefaultKubernetesClient();
        KubernetesClient client = getCustomKubernetesClient();

        watchPodEvents(client);

        create(client);

        view(client);

        edit(client);

        viewPod(client);

        delete(client);

        viewPod(client);

        loadYaml(client);

    }

    private static void loadYaml(KubernetesClient client) {
        Deployment deployment = client.apps().deployments()
                .load(Fabric8KubernetesClientSamples.class.getResourceAsStream("/deployment.yaml"))
                .get();
        client.apps().deployments().inNamespace("pkslow")
                .createOrReplace(deployment);
    }

    private static void watchPodEvents(KubernetesClient client) {
        client.pods().inAnyNamespace().watch(new Watcher<Pod>() {
            @Override
            public void eventReceived(Action action, Pod pod) {
                System.out.println("event " + action.name() + " " + pod.toString());
            }

            @Override
            public void onClose(WatcherException e) {
                System.out.println("Watcher close due to " + e);

            }
        });
    }

    private static void delete(KubernetesClient client) {
        client.pods().inNamespace("pkslow")
                .withName("nginx")
                .delete();
    }

    private static void edit(KubernetesClient client) {
        client.namespaces().withName("pkslow")
                .edit(n -> new NamespaceBuilder(n)
                .editMetadata()
                        .addToLabels("project", "pkslow")
                        .endMetadata()
                        .build()
                );

        client.pods().inNamespace("pkslow").withName("nginx")
                .edit(p -> new PodBuilder(p)
                    .editMetadata()
                        .addToLabels("app-version", "1.0.1")
                        .endMetadata()
                        .build()
                );
    }

    private static void view(KubernetesClient client) {
        NamespaceList namespaceList = client.namespaces().list();
        namespaceList.getItems()
                .forEach(namespace ->
                        System.out.println(namespace.getMetadata().getName() + ":" + namespace.getStatus().getPhase()));

        viewPod(client);
    }

    private static void viewPod(KubernetesClient client) {
        ListOptions options = new ListOptions();
        options.setLabelSelector("app=nginx");
        Pod nginx = client.pods().inNamespace("pkslow")
                .list(options)
                .getItems()
                .get(0);
        System.out.println(nginx);
    }

    private static void create(KubernetesClient client) {
        Namespace namespace = new NamespaceBuilder()
                .withNewMetadata()
                .withName("pkslow")
                .addToLabels("reason", "pkslow-sample")
                .endMetadata()
                .build();
        client.namespaces().createOrReplace(namespace);

        Pod pod = new PodBuilder()
                .withNewMetadata()
                .withName("nginx")
                .addToLabels("app", "nginx")
                .endMetadata()
                .withNewSpec()
                .addNewContainer()
                .withName("nginx")
                .withImage("nginx:1.19.5")
                .endContainer()
                .endSpec()
                .build();

        try {
            client.pods().inNamespace("pkslow").createOrReplace(pod);
        } catch (Exception e) {
            System.out.println("create pod failed");
        }
    }

    private static KubernetesClient getDefaultKubernetesClient() {
        //This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config`
        return new DefaultKubernetesClient();
    }

    private static KubernetesClient getCustomKubernetesClient() {
        Config config = new ConfigBuilder()
                .withMasterUrl("https://localhost:6443")
                .build();
        return new DefaultKubernetesClient(config);
    }
}
