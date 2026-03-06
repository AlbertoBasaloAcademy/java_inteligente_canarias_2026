## Plan: Architect Orchestrator Agent

Create a new top-level Architect orchestrator agent that coordinates three internal worker agents: Analyst, Architect, and Product Owner. Keep the current repo convention in `.agents` because the workspace already enables that folder via `chat.agentFilesLocations`. Make the existing role agents internal-only by hiding them from the picker and blocking general subagent use, then explicitly allow only the new orchestrator to invoke them. Use the Product Owner worker multiple times in parallel for independent feature-spec generation.

**Steps**
1. Phase 1 — Finalize the target agent topology.
   Confirm the visible/public agent will be the new orchestrator, while the current role agents become internal workers. Avoid name collisions by giving the new public agent the display name `Architect` and renaming the current worker display names to something unambiguous such as `Analyst Worker`, `Architect Worker`, and `Product Owner Worker`.
2. Phase 2 — Add the orchestrator agent file.
   Create a new agent file under `c:\code\live\java_inteligente_canarias_2026\.agents\` for the public Architect orchestrator. Give it `tools` that include `agent`, `read`, `search`, `vscode/askQuestions`, and any minimal coordination tools it truly needs. Add an `agents` allowlist containing only the three internal worker names so it cannot call unrelated agents by mistake.
3. Phase 3 — Convert the current agents into internal workers. Depends on step 1.
   Update `c:\code\live\java_inteligente_canarias_2026\.agents\1-analyst.agent.md`, `c:\code\live\java_inteligente_canarias_2026\.agents\2-architect.agent.md`, and `c:\code\live\java_inteligente_canarias_2026\.agents\3-product-owner.agent.md` so they are not directly available outside the orchestrator. Use `user-invocable: false` and `disable-model-invocation: true` on each worker. Keep their specialized instructions and tools narrow to their role.
4. Phase 4 — Move workflow control into the orchestrator. Depends on steps 2-3.
   Remove or simplify handoffs from the three internal worker agents because sequential workflow should now be owned by the orchestrator, not by the workers themselves. In the new Architect body, define the sequence explicitly: run Analyst Worker to generate or refine the PRD, run Architect Worker to produce the ADD and agent rules, then fan out Product Owner Worker subagents in parallel for the selected set of features or backlog items.
5. Phase 5 — Define the Product Owner pool behavior. Depends on step 4.
   In the orchestrator instructions, specify how the Product Owner pool is formed: identify independent features from the PRD/backlog, launch one Product Owner Worker subagent per feature in parallel, require each worker to return a concise spec summary plus output file target, then synthesize the results into a prioritized specification package. Keep the worker reusable; do not create multiple Product Owner files unless a later need appears for different tool/model profiles.
6. Phase 6 — Preserve the downstream workflow boundary.
   Decide whether the public Architect orchestrator should keep a final handoff to the Engineer agent after architecture and specs are ready. The recommended approach is yes: the orchestrator remains the single visible upstream coordinator, then hands off once the spec package is complete.
7. Phase 7 — Validate the custom-agent behavior. Depends on steps 2-6.
   Verify that only the new public Architect appears in the agent picker, that the three workers are hidden, and that they cannot be invoked generically by other agents. Then verify the Architect orchestrator can still invoke those workers because its `agents` allowlist explicitly names them, which overrides `disable-model-invocation: true` for that coordinator only.

**Relevant files**
- `c:\code\live\java_inteligente_canarias_2026\.agents\1-analyst.agent.md` — convert current Analyst into an internal worker and trim handoffs.
- `c:\code\live\java_inteligente_canarias_2026\.agents\2-architect.agent.md` — convert current Architect into an internal architecture worker and trim handoffs.
- `c:\code\live\java_inteligente_canarias_2026\.agents\3-product-owner.agent.md` — convert current Product Owner into an internal spec-generation worker suitable for parallel reuse.
- `c:\code\live\java_inteligente_canarias_2026\.agents\` — add the new public Architect orchestrator agent file here, following the workspace’s registered agent location.
- `c:\code\live\java_inteligente_canarias_2026\.vscode\settings.json` — reuse current `.agents` registration; change only if discovery fails during validation.
- `c:\code\live\java_inteligente_canarias_2026\AGENTS.md` — reference only if a short note is needed to explain the new internal/public agent split.

**Verification**
1. Open Chat Customizations diagnostics and confirm the workspace loads the new orchestrator plus the three worker agents from `.agents` without frontmatter errors.
2. Confirm the agent picker shows only the new public Architect, not the three workers.
3. Run the public Architect on a sample request and confirm it invokes Analyst Worker and Architect Worker as subagents in sequence.
4. Run the public Architect on a backlog with multiple independent features and confirm it launches multiple Product Owner Worker subagents in parallel and synthesizes their results.
5. Confirm another agent without an explicit allowlist cannot invoke the hidden workers.
6. Confirm the final workflow still offers the expected next step, ideally a single handoff to Engineer after specs are prepared.

**Decisions**
- Use `.agents` rather than migrating to `.github/agents` because the workspace already configures `chat.agentFilesLocations` for `.agents`.
- Implement “not callable from outside” as: hidden from the picker and blocked from general subagent invocation, while still callable by the orchestrator through an explicit `agents` allowlist.
- Prefer one reusable Product Owner worker invoked multiple times in parallel over multiple nearly identical Product Owner agent files.
- Keep the orchestrator as the only public entry point for this analysis-to-spec workflow.

**Further Considerations**
1. Naming: `Architect` for the public orchestrator and `Architect Worker` for the current internal file is the clearest option because it avoids ambiguous subagent selection.
2. Handoffs: if worker handoffs create noise in subagent results, remove them entirely from internal workers rather than leaving legacy next-step buttons in place.
3. Scope: this plan intentionally does not redesign Engineer, Coder, Tester, or DevOps unless the orchestrator’s final handoff exposes a downstream naming or visibility conflict.
