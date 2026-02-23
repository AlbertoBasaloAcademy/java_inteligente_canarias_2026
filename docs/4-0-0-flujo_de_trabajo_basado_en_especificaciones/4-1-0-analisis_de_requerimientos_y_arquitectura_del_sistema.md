---
title: Análisis de requerimientos y arquitectura del sistema
description: La primera fase del workflow es entender el problema y diseñar la solución.
url: 4-1-0-analisis_de_requerimientos_y_arquitectura_del_sistema
footer: 4.1. Análisis de requerimientos y arquitectura del sistema. [AlbertoBasalo](https://albertobasalo.dev)@[AICode.Academy](https://aicode.academy) 
marp: true
theme: ab
---

[4. Flujo de trabajo basado en especificaciones](./4-0-0-flujo_de_trabajo_basado_en_especificaciones.md)  
# 4.1. Análisis de requerimientos y arquitectura del sistema

- La primera fase del workflow es entender el problema y diseñar la solución.

#### [Programación Inteligente](programacion_inteligente.md)  
> Por [Alberto Basalo](https://albertobasalo.dev)@[AICode.Academy](https://aicode.academy) 

---

## Conexión

- **¿Por dónde empezar cuando solo tienes una idea?**
  - Saltar directamente al código es tentador, pero peligroso.
- **¿Y si lo que tienes es un viejo proyecto en marcha?**
  - Mantener y modificar requiere entender su estructura y objetivos.

---

## Conceptos

- **Análisis de requerimientos** - > `PRD.md`:
  - Identificar y documentar las necesidades del sistema.
  - Definir funcionalidades y restricciones técnicas.
- **Arquitectura del sistema** -> `ADD.md` 
  - Diseñar la estructura y stack tecnológico del software.
  - Establecer patrones y principios arquitectónicos.
- **Reglas de agentes** -> `AGENTS.md`
  - Guiar en el proceso de desarrollo con agentes IA.
  - Asegurar que los agentes sigan la arquitectura definida.

---

## Concreción

- `1` **Analyst Agent**: `Generate PRD from idea or existing project`
```md
# Product Requirements Document.
## Vision and Scope
## Functional Requirements
## Technical Requirements
```

---

- `2` **Architect Agent**: `Generate ADD and AGENTS from PRD and current project`
```md
# Architecture Design Document.
## Stack and tooling
## Systems architecture
## Software architecture
```
```md
# Agents Rules Document.
## Tech stack
## Dev workflow
## Folder structure
## Environment
## Behaviors
```

---

## Conclusión

- El análisis y la arquitectura son la **base sólida** del desarrollo.
- Proporcionan el **contexto necesario** para que la IA genere código adecuado.
- Invertir tiempo aquí **ahorra tiempo** en fases posteriores.

#### [Programación Inteligente](programacion_inteligente.md).  
> _No es magia, es tecnología._  
> [**Alberto Basalo**](https://albertobasalo.dev)@[AICode.Academy](https://aicode.academy)
