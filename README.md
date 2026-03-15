# Hostel Recipe API – Curated & Moderated Backend

## Problem Statement
Hostel students need quick, simple recipes.
Open posting systems lead to spam and low-quality content.

## Solution
Users can submit recipes, but only admin-approved recipes are publicly visible.
All submissions go through a moderation workflow before being publicly accessible.

## Key Features
- Recipe submission with automatic `PENDING` status
- Admin approval/rejection workflow
- Public access to approved recipes only
- IP-based rate limiting on public endpoints
- Custom exception handling with proper HTTP status codes
- Basic Auth protected admin endpoints

## API Endpoints

### Public
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/recipes/submit` | Submit a new recipe |
| `GET` | `/recipes` | Get all approved recipes |

### Admin (requires Basic Auth)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/admin/recipes/pending` | Get all pending recipes |
| `PUT` | `/admin/recipes/review` | Approve or reject a recipe |

## Tech Stack
- Java 17
- Spring Boot
- Spring Security (Basic Auth)
- Spring Data JPA
- PostgreSQL
- Bucket4j (Rate Limiting)
- Maven

## Recipe Workflow
```
User submits recipe → status: PENDING
         ↓
Admin reviews via /admin/recipes/pending
         ↓
Admin approves or rejects via /admin/recipes/review
         ↓
Only APPROVED recipes visible on GET /recipes
```

## What This Project Demonstrates
- Moderation workflow with state management
- Role-based access control with Spring Security
- Custom exception handling with proper HTTP status codes (404, 400, 429)
- IP-based rate limiting using Bucket4j
- Real-world REST API design
