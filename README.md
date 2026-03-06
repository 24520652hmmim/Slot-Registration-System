# 🧩 Microservices Assignment Starter Template

This repository is a **starter template** for building a microservices-based system. Use it as a base for your group assignment.

---

## 📁 Folder Structure

```
microservices-assignment-starter/
├── README.md                       # This instruction file
├── .env.example                    # Example environment variables
├── docker-compose.yml              # Multi-container setup for all services
├── docs/                           # Documentation folder
│   ├── architecture.md             # Describe your system design here
│   ├── analysis-and-design.md      # Document system analysis and design details
│   ├── asset/                      # Store images, diagrams, or other visual assets for documentation
│   └── api-specs/                  # API specifications in OpenAPI (YAML)
│       ├── service-a.yaml
│       └── service-b.yaml
├── scripts/                        # Utility or deployment scripts
│   └── init.sh
├── services/                       # Application microservices
│   ├── service-a/
│   │   ├── Dockerfile
│   │   └── src/
│   │   └── readme.md               # Service A instructions and description
│   └── service-b/
│       ├── Dockerfile
│       └── src/
│   │   └── readme.md               # Service B instructions and description
└── gateway/                        # API Gateway / reverse proxy
    ├── Dockerfile
    └── src/


```

---

## 🚀 Getting Started

1. **Clone this repository**

   ```bash
   git clone https://github.com/hungdn1701/microservices-assignment-starter.git
   cd microservices-assignment-starter
   ```

2. **Copy environment file**

   ```bash
   cp .env.example .env
   ```

3. **Run with Docker Compose**

   ```bash
   docker-compose up --build
   ```
---

## 🧪 Development Notes

- Use `docs/api-specs/*.yaml` to document REST APIs using OpenAPI format (Swagger).

---

## 📚 Recommended Tasks
- [ ] Document system analysis and design in `analysis-and-design.md` as the first step
- [ ] Update `architecture.md` to describe your system components.
- [ ] Define all APIs using OpenAPI YAML in `docs/api-specs/`.
- [ ] Implement business logic in `service-a` and `service-b`.
- [ ] Configure API Gateway
- [ ] Ensure services can communicate internally using service names (Docker Compose handles networking).

---

## 📌 Notes

- Use Git branches for team collaboration.
- Commit early, commit often!

---

## 👩‍🏫 Assignment Submission

Please make sure:
- `README.md` is updated with service descriptions and API usage, following standard README conventions (e.g., clear structure, usage instructions, and contribution guidelines).
- Include a list of team members and their contributions in the `README.md`.
- All your code should be **runnable with one command**: `docker-compose up`.



## Author

This template was created by Huy Minh.
- Email: 24520652@gm.uit.edu.vn
- GitHub: hmmim


Good luck! 💪🚀

