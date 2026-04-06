variable "ami_id" {
  description = "AMI ID for EC2"
  type        = string
  default     = "ami-02b8269d5e85954ef"
}

variable "instance_type" {
  description = "EC2 instance type"
  type        = string
  default     = "t3.micro"
}

variable "key_name" {
  description = "EC2 Key Pair name"
  type        = string
  default = "practice-key"
}
