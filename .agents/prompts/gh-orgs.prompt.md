---
name: gh-orgs
description: This prompt is used to list all the organizations a GitHub user belongs to.
agent: agent
model: GPT-5.1
tools: [execute, read, search, web, 'github/*']
---
Dame la lista de equipos a los que pertenece el usuario de GitHub `AlbertoBasalo`

Para cada equipo, dame el nombre, la descripción y el enlace a la página del equipo en GitHub.

Usa la herramienta #tool:github/get_teams para obtener esta información. 