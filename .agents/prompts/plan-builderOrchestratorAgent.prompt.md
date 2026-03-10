## Plan: Builder Orchestrator Agent

Create a new public `Builder` orchestrator that coordinates the implementation pipeline sequentially through the existing Engineer, Coder, Tester, Cleaner, and DevOps agents. Mirror the orchestration style already used by the Architect orchestrator: keep one public entry point, convert the current implementation agents into internal workers, and let `Builder` own the workflow from specification to release. Preserve the current linear delivery model instead of introducing parallel execution, because these five stages have hard artifact dependencies and `DevOps` is the terminal boundary.

**Steps**
1. Phase 1 — Define the Builder topology.
   Make `Builder` the only public agent for implementation-to-release work. Treat the current `Engineer`, `Coder`, `Tester`, `Cleaner`, and `DevOps` agents as internal workers. Keep the existing sequential order because each stage depends on the previous one: plan, code, verify, clean, release.
2. Phase 2 — Add the public Builder orchestrator agent.
   Create a new agent file under `c:\code\live\java_inteligente_canarias_2026\.agents\` with display name `Builder`. Give it only the coordination tools it needs, such as `agent`, `read`, `search`, `todo`, and optionally `vscode/askQuestions` if ambiguity handling should stay in the coordinator. Add an explicit `agents` allowlist using the registered worker identifiers: `4-engineer`, `5-coder`, `6-tester`, `7-cleaner`, and `8-dev-ops`.
3. Phase 3 — Convert the current implementation agents into internal workers. Depends on step 1.
   Update `c:\code\live\java_inteligente_canarias_2026\.agents\4-engineer.agent.md`, `c:\code\live\java_inteligente_canarias_2026\.agents\5-coder.agent.md`, `c:\code\live\java_inteligente_canarias_2026\.agents\6-tester.agent.md`, `c:\code\live\java_inteligente_canarias_2026\.agents\7-cleaner.agent.md`, and `c:\code\live\java_inteligente_canarias_2026\.agents\8-dev-ops.agent.md` so they are hidden from the picker and blocked from general subagent invocation. Use `user-invocable: false` and `disable-model-invocation: true` on each one, while keeping their role-specific tools and instructions narrow.
4. Phase 4 — Move workflow ownership into Builder. Depends on steps 2-3.
   Remove or simplify the existing handoffs across the five workers so the sequential implementation flow is controlled by `Builder`, not by the workers themselves. In the `Builder` body, define the exact sequence: run `4-engineer` to prepare the environment and plan, then `5-coder` to implement, then `6-tester` to verify, then `7-cleaner` to refine, and finally `8-dev-ops` to document, version, commit, and integrate.
5. Phase 5 — Preserve worker-specific behavior inside the new orchestration. Depends on step 4.
   Keep `Cleaner` free to call the built-in `Plan` subagent internally for its cleanup planning, because that is already an established pattern and does not conflict with `Builder`. Keep `DevOps` as the terminal worker with no onward handoff, so `Builder` remains the last public coordination point but `DevOps` remains the release boundary.
6. Phase 6 — Define Builder’s output contract.
   Require `Builder` to return a concise end-to-end summary that includes the plan file used or created, the branch and implementation status, verification results, cleanup decisions, release/documentation changes, and any blockers that stopped the pipeline before `DevOps`.
7. Phase 7 — Validate the custom-agent behavior. Depends on steps 2-6.
   Verify that only `Builder` appears as the public entry for this implementation pipeline, that the five workers are hidden, and that other agents cannot invoke them unless they explicitly allow those worker IDs. Then verify `Builder` can still invoke the workers because its explicit `agents` allowlist overrides the workers’ `disable-model-invocation: true` setting.

**Relevant files**
- `c:\code\live\java_inteligente_canarias_2026\.agents\4-engineer.agent.md` — convert current Engineer into an internal planning worker and trim handoffs.
- `c:\code\live\java_inteligente_canarias_2026\.agents\5-coder.agent.md` — convert current Coder into an internal implementation worker and trim handoffs.
- `c:\code\live\java_inteligente_canarias_2026\.agents\6-tester.agent.md` — convert current Tester into an internal verification worker and trim handoffs.
- `c:\code\live\java_inteligente_canarias_2026\.agents\7-cleaner.agent.md` — convert current Cleaner into an internal cleanup worker while preserving its internal use of `Plan`.
- `c:\code\live\java_inteligente_canarias_2026\.agents\8-dev-ops.agent.md` — convert current DevOps into an internal release worker and keep it as the terminal stage.
- `c:\code\live\java_inteligente_canarias_2026\.agents\0-architect-orchestrator.agent.md` — reuse as the reference pattern for coordinator structure, worker allowlist usage, and orchestration instructions.
- `c:\code\live\java_inteligente_canarias_2026\.agents\` — add the new public `Builder` orchestrator agent file here.
- `c:\code\live\java_inteligente_canarias_2026\.vscode\settings.json` — reuse current `.agents` registration; change only if agent discovery fails during validation.

**Verification**
1. Open Chat Customizations diagnostics and confirm the workspace loads the new `Builder` orchestrator plus the five worker agents from `.agents` without frontmatter errors.
2. Confirm the agent picker shows `Builder` and does not show the internal `Engineer`, `Coder`, `Tester`, `Cleaner`, or `DevOps` workers.
3. Run `Builder` with a specification and confirm it invokes `4-engineer`, `5-coder`, `6-tester`, `7-cleaner`, and `8-dev-ops` in order.
4. Confirm `Cleaner` can still invoke `Plan` internally without breaking the `Builder` orchestration.
5. Confirm another agent without an explicit allowlist cannot invoke the hidden implementation workers.
6. Confirm `Builder` reports a coherent end-to-end summary even when the pipeline stops early because a worker surfaces a blocker.

**Decisions**
- Use `.agents` rather than migrating to `.github/agents` because the workspace already configures `chat.agentFilesLocations` for `.agents`.
- Implement the five implementation agents as internal workers: hidden from the picker and blocked from general subagent invocation, while still callable by `Builder` through an explicit `agents` allowlist.
- Keep the implementation pipeline sequential, not parallel, because the stages depend on upstream artifacts and current responsibilities are already strictly ordered.
- Preserve `Cleaner` using `Plan` as an internal helper and preserve `DevOps` as the terminal release boundary.
- Make `Builder` the only public entry point for spec-to-release execution.

**Further Considerations**
1. Naming: keep the worker files where they are and expose only the new public display name `Builder`; if needed, rename worker display names to `Engineer Worker`, `Coder Worker`, `Tester Worker`, `Cleaner Worker`, and `DevOps Worker` to reduce ambiguity in orchestrator instructions.
2. Handoffs: if worker handoffs remain visible or noisy in subagent output, remove them entirely from the five workers rather than leaving legacy stage-to-stage buttons in place.
3. Scope: this plan intentionally mirrors the current linear implementation pipeline and does not redesign branching strategy, rollback flow, or conditional retries between workers.