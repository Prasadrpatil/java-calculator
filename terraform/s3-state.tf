terraform {
   backend "s3" {
    bucket = "devsecops-poc-terrafrom-state"
    key    = "terraform/terraform.tfstate"
    region = "us-east-1"
  }
}
