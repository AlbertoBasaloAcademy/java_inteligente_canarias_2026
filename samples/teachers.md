# Enseñar programación en tiempos de IA

https://www.teachai.org/

## Introducción a mano

### Introducción a la programación a mano

- Escribir código a mano mejora la comprensión de sintaxis, estructuras de datos y algoritmos.
- Fomenta la memoria muscular y la capacidad de escribir código sin depender de autocompletado o sugerencias.
- Permite a los estudiantes internalizar patrones de diseño y estilos de codificación.

- [ ] Variables, constantes y tipos de datos
- [ ] Estructuras de control (if, loops)
- [ ] Funciones y procedimientos

### Introducción al diseño de software a mano

- Dibujar diagramas de flujo, mapas conceptuales o pseudocódigo ayuda a organizar el pensamiento antes de codificar.
- Fomenta la planificación y la arquitectura de software, habilidades críticas para proyectos complejos.
- Permite a los estudiantes visualizar la interacción entre componentes y la lógica del programa.

- [ ] Diagramas de flujo para algoritmos
- [ ] Mapas conceptuales para estructuras de datos
- [ ] Pseudocódigo para diseño de funciones y clases

### Introducción a la programación orientada a objetos a mano

- Escribir código orientado a objetos a mano ayuda a comprender conceptos como clases, objetos, herencia y polimorfismo.
- Fomenta la capacidad de diseñar sistemas modulares y reutilizables.
- Permite a los estudiantes internalizar patrones de diseño orientados a objetos y principios SOLID.

- [ ] Clases y objetos
- [ ] Herencia y polimorfismo
- [ ] Principios SOLID 

## Uso de la IA Generativa para Enseñar Programación

### Principios para formar programadores en tiempos de IA

1- Sé transparente y modela el uso responsable (muestra tus propios prompts en clase).  
2- Cambia las tareas hacia explicación, depuración y crítica del código generado por IA.  
3- Enfócate en el proceso de aprendizaje, no solo en el producto final.

### Introducción al uso de la IA Generativa para enseñar programación  

- La IA generativa es una herramienta poderosa pero no infalible. 
- Enseñar prompt engineering y context engineering es esencial.
- Fomentar la generación de pruebas y documentación como parte del proceso de desarrollo.

- [ ] Introducción a la IA generativa y su aplicación en programación
- [ ] Técnicas de prompt engineering para obtener resultados útiles
- [ ] Uso de la IA para generar pruebas unitarias y documentación de código 

### Estrategias de Diseño de Tareas para Mitigar el Uso Inadecuado de LLM en Programación

| Estrategia de Diseño                    | Implementación Práctica en Programación                                                                                         | Racionalidad Pedagógica                                                                                              |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| Instrucciones Altamente Específicas     | Incluir restricciones técnicas muy particulares o dependencias de bases de código locales no públicas.                          | Los LLM producen resultados generalistas y fallan ante restricciones locales complejas.                              |
| Tareas de Múltiples Capas (Scaffolding) | Dividir un proyecto en hitos donde cada etapa depende de decisiones de diseño únicas tomadas en la anterior.                    | Dificulta el prompteo directo de la solución final sin haber comprendido la arquitectura previa.                     |
| Diversificación de Medios               | Requerir la entrega de diagramas de flujo, mapas conceptuales hechos a mano o explicaciones en video del código.                | Fomenta la organización visual y la síntesis, habilidades que la IA no puede demostrar auténticamente por el alumno. |
| Incorporación de Experiencia Personal   | Pedir reflexiones sobre los errores cometidos durante el desarrollo o la justificación de una elección de diseño específica.    | La IA carece de memoria episódica sobre el proceso de aprendizaje del estudiante en el aula.                         |
| Evaluación Basada en Socratic Dialogue  | Utilizar la IA para generar preguntas que guíen al alumno hacia la solución, evaluando la calidad de las respuestas del alumno. | Cultiva el pensamiento crítico y la capacidad de razonamiento algorítmico interactivo.                               |

### Proyectos de fin de curso

| Fase del Proyecto con IA | Rol de la IA Generativa                                         | Rol del Estudiante (Supervisión)                                |
| ------------------------ | --------------------------------------------------------------- | --------------------------------------------------------------- |
| Días 1-2: Arquitectura   | Generación de especificaciones de API y modelos de datos.       | Validación de la coherencia arquitectónica y seguridad.         |
| Día 3: Implementación    | Generación de componentes de UI y lógica de backend repetitiva. | Revisión de código, integración de lógica de negocio crítica.   |
| Día 4: Feedback          | Iteración rápida basada en comentarios de usuarios o pruebas.   | Priorización de cambios y ajuste de prompts para refinamiento.  |
| Día 5: Despliegue        | Generación de archivos YAML para Kubernetes o scripts de CI/CD. | Verificación de configuraciones de infraestructura y seguridad. |

> En 2026 enseñamos a programar para que la persona sea capaz de dirigir, criticar y mejorar sistemas de IA que escriben código… no para que compita en velocidad de tipeo contra ellas.

