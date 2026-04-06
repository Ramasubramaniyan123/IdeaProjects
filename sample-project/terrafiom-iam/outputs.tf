output "iam_user" {
  value = aws_iam_user.admin_user.name
}

output "iam_group" {
  value = aws_iam_group.admin_group.name
}