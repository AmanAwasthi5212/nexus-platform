# NEXUS Development & Learning Rules

## 1. Learning First

NEXUS is not only a portfolio project.

It is a learning project designed to develop Senior Java Backend,
System Design, Cloud and DevOps skills.

The goal is to understand what we build, why we build it,
and how it works internally.

---

## 2. Explain What and Why

Before introducing an important component, explain:

- What are we creating?
- Why are we creating it?
- What problem does it solve?
- Why are we choosing this approach?
- What alternatives exist?
- What are the trade-offs?

---

## 3. Explain Files and Naming

Whenever a new file, folder, class, interface, package, configuration,
dependency, or resource is introduced, explain:

- Why it exists
- Why it is located there
- Why it is named that way
- What responsibility it has
- What interacts with it
- Why the naming convention is appropriate

---

## 4. Explain Important Code

Do not encourage blind copy/paste.

Important code should be explained from:

1. Syntax
2. Purpose
3. Runtime behavior
4. Design reasoning
5. Production considerations

The user should understand the code well enough to explain it
during a technical interview.

---

## 5. Basics to Advanced

Do not skip fundamentals merely because a technology is commonly used.

For every major technology, follow:

Basics
→ Core concepts
→ Practical implementation
→ Internal working
→ Design patterns
→ Trade-offs
→ Production concerns
→ Interview preparation

---

## 6. Technology Introduction

Before using a major technology, explain:

- What it is
- Why NEXUS needs it
- What problem it solves
- How it works at a high level
- Alternatives
- Why we selected it

Examples include:

- Java
- Spring Boot
- Maven
- PostgreSQL
- Kafka
- Redis
- Docker
- Kubernetes
- AWS
- Terraform
- CI/CD
- Observability

---

## 7. Production-Grade Thinking

NEXUS should be designed as a realistic production-style system.

Consider:

- Security
- Scalability
- Availability
- Reliability
- Maintainability
- Observability
- Performance
- Failure handling
- Testing
- Deployment
- Disaster recovery

---

## 8. Don't Add Technology Without Purpose

Do not add a technology merely to make the CV or README look impressive.

Every technology must solve a real problem.

We should be able to answer:

"Why is this technology being used here?"

If there is no good answer, we should not use it.

---

## 9. Git Discipline

Use meaningful commits.

Preferred commit categories include:

- feat
- fix
- refactor
- test
- docs
- chore
- build
- ci

Examples:

chore: configure repository standards

feat: create shipment service

test: add shipment creation tests

fix: handle duplicate shipment events

---

## 10. Branching

Avoid developing major features directly on main.

Use feature branches such as:

feature/shipment-service
feature/kafka-events
feature/oauth-security

Use fix branches for bugs:

fix/shipment-validation

Use refactor branches for structural improvements:

refactor/shipment-domain

---

## 11. Daily Git Workflow

At the beginning of a session:

git status
git pull

During development:

Implement
→ Test
→ Review
→ git status
→ git diff

At the end:

git add
→ git commit
→ git push

---

## 12. Day-by-Day Learning Notes

Every development day must have a note-friendly progress summary.

Each day should contain:

- Day number
- Date
- Objectives
- What was learned
- Concepts explained
- Files/folders created or changed
- Why they were created or changed
- Important commands
- Important technical concepts
- Architecture decisions
- Problems encountered
- Solutions
- Git changes
- Commit information
- Key takeaways
- What should now be understood
- Completion status
- Next day's plan

---

## 13. Maintain a Learning Journal

Project implementation and learning notes should be treated
as two related but distinct things.

Learning notes answer:

"What did I learn?"

Project notes answer:

"What did I build and why?"

Git notes answer:

"What changed and how was it committed?"

Architecture notes answer:

"Why did we make this technical decision?"

---

## 14. Interview Perspective

For important implementation and architectural decisions,
include potential Senior Java / System Design interview questions.

The user should be able to explain NEXUS independently.

---

## 15. User Must Understand the Project

The goal is not to create the largest possible repository.

The goal is to make the user capable of saying:

"I designed and built this system."

The user should understand the important implementation,
architecture, infrastructure, operational and design decisions.

---

## 16. Don't Over-Engineer Prematurely

Introduce technologies and infrastructure when there is
a real requirement for them.

Do not create unnecessary complexity simply because it
appears in the final architecture.

---

## 17. Progress Tracking

Track NEXUS progress by development day and major milestone.

Major milestones should include:

- Architecture
- Java/Spring foundation
- Database
- Security
- Microservices
- Kafka/Event-driven architecture
- Resilience
- Testing
- Docker
- Kubernetes
- CI/CD
- Observability
- AWS
- Terraform
- Performance
- GenAI
- CV/Interview preparation
