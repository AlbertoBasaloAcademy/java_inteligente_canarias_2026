---
title: Rol Builder: bucles iterativos orientados a objetivos guiados por specs
description: Ejecución precisa y autónoma basada en especificaciones claras.
url: 6-2-0-rol_builder_bucles_iterativos_orientados_a_objetivos_guiados_por_specs
footer: 6.2. Builder: bucles iterativos guiados por specs. [AlbertoBasalo](https://albertobasalo.dev)@[AICode.Academy](https://aicode.academy) 
marp: true
theme: ab
---

[6. Calidad y evolución continua mediante roles con agentes](./6-0-0-calidad_y_evolucion_continua_mediante_roles_con_agentes.md)  
# 6.2. Rol Builder: bucles iterativos orientados a objetivos guiados por specs

- Ejecución precisa y autónoma basada en especificaciones claras.

#### [Programación Inteligente](programacion_inteligente.md)  
> Por [Alberto Basalo](https://albertobasalo.dev)@[AICode.Academy](https://aicode.academy) 

---

## Conexión

- **¿Confías en que la IA entienda tu "intención"?**
  - La ambigüedad es el enemigo. "Haz que funcione" no es una spec.
- **Iteración vs Adivinación**:
  - Un _Builder_ no adivina, ejecuta instrucciones precisas y verifica el resultado.

---

## Conceptos

- **Spec-Driven Development (SDD)**:
  - Escribir la especificación _antes_ que el código. 
  - La spec es el contrato que el agente debe cumplir.
- **Bucle de Ejecución**:
  - `Leer Spec` -> `Generar Plan` -> `Escribir Código` -> `Verificar (Test/Lint)`.
- **Drift (Desviación)**:
  - Detectar cuándo el código se aleja de la spec y corregirlo automáticamente.

---

## Concreción

- **Creando un Agente Builder**:
  - **Input**: Archivo de especificación (Markdown/Gherkin) y codebase actual.
  - **Instrucción**: "Implementa la funcionalidad descrita en `feature.spec.md` asegurando que pasen los tests definidos."
  - **Tooling**: Acceso a terminal para correr tests, linter y compilador.
  - **Output**: Código implementado y reporte de verificación.

---

## Conclusión

- El rol de Builder transforma el desarrollo en un proceso **industrial y predecible**.
- La calidad depende de la **calidad de la especificación**, no de la "creatividad" del modelo.
- Reduce la carga cognitiva del desarrollador en la implementación de detalles.

#### [Programación Inteligente](programacion_inteligente.md).  
> _No es magia, es tecnología._  
> [**Alberto Basalo**](https://albertobasalo.dev)@[AICode.Academy](https://aicode.academy)
