# Agents Instructions

## Product Overview
Astro Bookings is a fictional space travel booking system API. Built with Express and TypeScript, it offers backend endpoints for managing rocket launches with passenger bookings, pricing, and payment processing.

## Technical Implementation

### Tech Stack
- Language: **TypeScript 5.9**
- Framework: **Express 5.2**
- Database: **None (mock data only, demo stage)**
- Security: **Not implemented (training/demo only)**
- Testing: **Playwright 1.57**
- Logging: **Console (built-in)**

### Development workflow

```bash
# Set up the project
npm install
# Build the project
npm run build
# Run the project (dev with hot reload)
npm run dev
# Run the project (compiled)
npm run start
# Test the project
npm test
# Test with UI
npm run test:ui
# Type check
npm run typecheck
```

### Folder structure

```text
.                          # Project root
├── AGENTS.md              # This file with instructions
├── README.md              # Project overview and quick start
├── package.json           # Dependencies and scripts
├── tsconfig.json          # TypeScript config
├── playwright.config.ts   # Test framework config
├── src/                   # Source code  
│   └── index.ts           # Main Express server
├── tests/                 # Test files
└── dist/                  # Compiled output (generated)
```

## Environment
- Code and documentation in English.
- Sacrifice grammar for conciseness in responses.
- Windows environment using Git Bash.
- Default branch: `main`.
- Server port: `3000` (configurable via `PORT` env var).
- Base URL for tests: `http://localhost:3000`.

## Important Notes
- Demo/training project only.
- No database or authentication yet.
- Playwright runs smoke tests on dev server.
- TypeScript compilation targets modern Node.js (>=18.18).
