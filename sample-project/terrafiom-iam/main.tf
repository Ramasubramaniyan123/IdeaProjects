provider "aws" {
  region = "ap-south-1"
}

resource "aws_iam_group" "admin_group" {
  name = var.group_name
}

resource "aws_iam_group_policy_attachment" "admin_policy" {
  group      = aws_iam_group.admin_group.name
  policy_arn = "arn:aws:iam::aws:policy/AdministratorAccess"
}

resource "aws_iam_user" "admin_user" {
  name = var.user_name
}

resource "aws_iam_user_group_membership" "user_group_attach" {
  user   = aws_iam_user.admin_user.name
  groups = [aws_iam_group.admin_group.name]
}