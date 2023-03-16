#!/bin/bash 

BUCKET_NAME="devsecops-poc-terrafrom-state"
aws s3api create-bucket --bucket "$BUCKET_NAME"
