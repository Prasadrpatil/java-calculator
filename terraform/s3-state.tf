resource "aws_s3_bucket" "terraform_backend" {
  bucket = "devsecops-poc-terrafrom-state"
  acl    = "private"   
} 

terraform {
  backend "s3" {
    bucket = aws_s3_bucket.terraform_backend.id
    key    = "terraform/terraform.tfstate"
    region = "us-east-1"
  }
}