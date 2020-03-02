Packaging Jenkins Instance for byondlabs.io
===========================================
This repository contains the deployment files and documentation relating to the Jenkins instance we use to automate non-Windows packaging for [BYOND](https://www.byond.com/). The general concept here is to deploy Jenkins as a [kubernetes](https://kubernetes.io/) service that is able to package [BYOND](https://www.byond.com/) into distribution specific packages, verify them, and publish them.

Deployment
----------
To deploy the service or update it, you need to have `kubectl` available configured for your cluster. The deployment assumes the following:
-   The cluster has a default [StorageClass](https://kubernetes.io/docs/concepts/storage/storage-classes/) available.
-   The cluster has an [IngressController](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/) that supports named virtual host routing.
-   The `jenkins.byondlabs.io` hostname routes to the the node(s) the IngressController is running on.
Assuming these prerequisites are met, then you can create/update the Jenkins instance by running `kubectl apply -f deploy-jenkins.yaml`.

Building Jenkins Customisations
-------------------------------
Customisations can be placed into the `docker` folder, which can be built with something like `docker build -t packaging-jenkins-config:latest docker/`.
