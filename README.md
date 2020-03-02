Packaging Jenkins Instance for byondlabs.io
===========================================
This repository contains the deployment files and documentation relating to the Jenkins instance we use to automate non-Windows packaging for [BYOND](https://www.byond.com/). The general concept here is to deploy Jenkins as a [kubernetes](https://kubernetes.io/) service that is able to package [BYOND](https://www.byond.com/) into distribution specific packages, verify them, and publish them.

Deployment
----------
To deploy the service or update it, you need to have `kubectl` available configured for your cluster, with a new enough version to support [kustomize](https://github.com/kubernetes-sigs/kustomize). The deployment assumes the following:
-   The cluster has a default [StorageClass](https://kubernetes.io/docs/concepts/storage/storage-classes/) available.
-   The cluster has an [IngressController](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/).
-   The hostname routes to the the node(s) the IngressController is running on.

Assuming these prerequisites are met, then you can create/update the Jenkins instance by running `kubectl apply -k .` from the `jenkins.byondlabs.io` folder, or your kustomized overlay folder. For this overlay, it assumes the following:
-   The cluster has [cert-manager](https://github.com/jetstack/cert-manager) with configuration for `letsencrypt-prod`.
-   The hostname `jenkins.byondlabs.io` routes to the the node(s) the IngressController is running on.
-   A secret `jenkins-admin-account` has been created in the `jenkins` namespace, containing the key-value pair `password=somePass` to set the admin password.

Building Jenkins Customisations
-------------------------------
Customisations can be placed into the `docker` folder, which can be built with something like `docker build -t packaging-jenkins-config:latest docker/`.
