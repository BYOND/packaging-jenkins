import jenkins.model.Jenkins
import jenkins.install.InstallState

Jenkins.instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)
