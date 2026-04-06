terraform {
  required_providers {
    github = {
      source  = "integrations/github"
      version = "~> 6.0"
    }
  }
}

# Configure the GitHub Provider
provider "github" {
  # token = var.token # or `GITHUB_TOKEN`
  owner = "XcelevatorRamasubramaniyan"
}

resource "github_repository" "sample-repo-terraform" {
  name        = "sample-repo-terraform"
  description = "This is just for terraform learning"
  visibility = "private"
}
