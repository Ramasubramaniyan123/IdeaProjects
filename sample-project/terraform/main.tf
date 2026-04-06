terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.0"
    }
  }
}

provider "aws" {
  region = "ap-south-1"   # Mumbai region
}

resource "aws_instance" "practice-key" {
  ami           = var.ami_id
  instance_type = var.instance_type
  key_name      = "practice-key"

  tags = {
    Name = "Terraform-EC2-Demo"
  }
}
