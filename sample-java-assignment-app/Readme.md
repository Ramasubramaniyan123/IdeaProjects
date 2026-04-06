# Assignment 01 – Java CI/CD with Testing, Docker, Kubernetes & Terraform

## 📌 Objective

This assignment is designed to give you hands-on experience with real-world DevOps workflows using a simple Java application.

You will practice:
- Unit Testing & Integration Testing
- Code Coverage with JaCoCo
- CI/CD using GitHub Actions (Trunk-Based Development)
- Docker (multi-stage builds)
- Kubernetes deployment
- Terraform-based infrastructure provisioning
- Secure handling of variables and secrets

This is a learning-focused assignment. You are not expected to write complex application logic. Focus on tools, pipelines, and workflows.

---

## 📁 Starter Project

You are provided with a starter boilerplate project containing:
- Basic Java source code
- Sample unit and integration test structure
- Incomplete CI pipeline
- No Docker, Kubernetes, or Terraform configuration

You must extend and complete the project as per the tasks below.

---

## 🧩 Assignment Tasks

### Task 1: Fix Project Dependencies
- Review the pom.xml file.
- Add required dependencies to compile the project.
- Ensure the project builds successfully using:
  mvn clean compile

Evidence:
- Screenshot or logs showing successful compilation.

---

### Task 2: Add Unit Tests
- Create unit tests for business logic.
- Follow Maven naming convention: *Test.java
- Unit tests must run using:
  mvn test

Evidence:
- Test execution logs.
- Screenshot showing unit tests passing.

---

### Task 3: Add Integration Tests
- Create integration tests to validate component interaction.
- Follow Maven Failsafe convention: *IT.java
- Integration tests must run using:
  mvn verify

Evidence:
- Logs showing integration tests executed during mvn verify.

---

### Task 4: Code Coverage with JaCoCo
- Integrate JaCoCo into the Maven build.
- Generate XML and HTML reports.
- Ensure coverage includes unit and integration tests.

Evidence:
- Screenshot of JaCoCo HTML report with coverage percentage.

---

### Task 5: GitHub Actions CI Pipeline
Create a CI pipeline using Trunk-Based Development.

Pipeline requirements:
- Trigger on pull requests and pushes to main branch.
- Stages:
    1. Build
    2. Unit Tests
    3. Integration Tests
    4. Code Coverage
    5. Package JAR

Artifacts:
- Publish JaCoCo HTML report.
- Publish final JAR to GitHub Package Registry.

Evidence:
- Successful pipeline run.
- Artifacts visible in GitHub Actions.

---

### Task 6: Variables & Secrets in CI
- Define two pipeline variables.
- Define two GitHub secrets.
- Pass them to the pipeline and print them (secrets must be masked).

Evidence:
- Pipeline logs showing variables.
- Secrets masked in logs.

---

### Task 7: Docker – Multi-Stage Build
- Create a multi-stage Dockerfile:
    - Stage 1: Build the Java application.
    - Stage 2: Run the application.
- Build Docker image locally.
- Run container with port mapping.
- Access application locally.

Evidence:
- Docker build logs.
- Screenshot or curl output accessing application.

---

### Task 8: Kubernetes Deployment (Local)
- Remove running Docker containers.
- Create Kubernetes manifests:
    - deployment.yml
    - service.yml
- Deploy to local Kubernetes cluster.
- Access application via service.

Evidence:
- kubectl get pods
- kubectl get svc
- Screenshot or curl output.

---

### Task 9: Terraform – Infrastructure Provisioning
- Create Terraform configuration to provision one free-tier EC2 instance.
- Use variables and outputs.
- Run terraform plan and terraform apply.

Evidence:
- terraform plan output.
- EC2 instance visible in AWS console.

---

### Task 10: Deployment to EC2 via CI/CD
- Extend GitHub Actions pipeline with deploy job.
- Copy final JAR to EC2 instance.
- Run application on EC2.
- Access application using EC2 public IP.

Evidence:
- Pipeline deployment logs.
- Screenshot accessing application via EC2 IP.

---

### Task 11: Infrastructure Cleanup
- Destroy all infrastructure using:
  terraform destroy
- Ensure no AWS resources are running.

Evidence:
- terraform destroy confirmation.

---

## 🧪 Evaluation Criteria

| Area | Weight |
|------|--------|
| Unit & Integration Tests | 20% |
| CI Pipeline & Artifacts | 25% |
| Docker & Kubernetes | 20% |
| Terraform & Cloud | 20% |
| Documentation & Evidence | 15% |

---

## ✅ Submission Guidelines
- GitHub repository link
- Pipeline screenshots
- Evidence screenshots/logs

---

## 🎓 Learning Outcome

By completing this assignment, you will gain confidence in:
- CI/CD pipelines
- Testing strategies
- Containerization
- Kubernetes deployments
- Infrastructure as Code
