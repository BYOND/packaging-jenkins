Packaging Jenkins Instance for byondlabs.io
===========================================
This repository contains the deployment files and documentation relating to the Jenkins instance we use to automate non-Windows packaging for [BYOND](https://www.byond.com/). The general concept here is to deploy Jenkins as a [kubernetes](https://kubernetes.io/) service that is able to package [BYOND](https://www.byond.com/) into distribution specific packages, verify them, and publish them.
