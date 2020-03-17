import jenkins.model.Jenkins
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import jenkins.branch.OrganizationFolder
import org.jenkinsci.plugins.github_branch_source.*

def folder = Jenkins.instance.items.isEmpty() ? Jenkins.instance.createProject(OrganizationFolder, 'BYOND') : Jenkins.instance.items[0]
def navigator = new GitHubSCMNavigator('BYOND')
navigator.credentialsId = 'github-org'
folder.navigators.replace(navigator)
Jenkins.instance.save()
navigator.afterSave(folder)
