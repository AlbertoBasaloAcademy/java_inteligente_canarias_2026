# Changelog

All notable changes to this project are documented in this file.

## [0.1.0] - 2026-03-04
### Added
- Added `LoggerUtil` utility for timestamped console logging with INFO/WARN/ERROR levels.
- Added startup and endpoint availability logs in `DemoApplication`.
- Added request/response and error logs in `HelloController` and `HealthController`.
- Added `HealthResponse` creation log for visibility on API response construction.

### Changed
- Updated project version to `0.1.0` in `pom.xml`.
- Updated health endpoint version field from `1.0.0` to `0.1.0`.
- Updated `AGENTS.md` technical stack and folder structure to reflect custom logger usage.
