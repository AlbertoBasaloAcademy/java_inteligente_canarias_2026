# Briefing: PRIMM-Gen

## Descripción General

PRIMM-Gen es una herramienta desarrollada en Java con un framework web, diseñada para docentes de programación. 
Su objetivo es automatizar la creación de materiales de aprendizaje siguiendo la metodología **PRIMM** (Predict, Run, Investigate, Modify, Make).

---

## 1. Descripción del Proyecto

El sistema funciona como un motor de composición que recupera fragmentos de código y guías pedagógicas desde un repositorio local de plantillas para generar un único recurso educativo listo para su distribución en formato Markdown.

---

## 2. Estructura del Repositorio de Plantillas

La carpeta `/templates` es la fuente de verdad del catálogo. Su estructura debe respetarse estrictamente para que el sistema pueda descubrirla automáticamente:
````
/templates
  /{Tema}
    /{Nivel}
      meta.json      ← metadatos del ejercicio
      code.java      ← código fuente del ejercicio
      guide.txt      ← preguntas y retos PRIMM
````

**Ejemplo:**
````
/templates/Bucles/Basico/meta.json
/templates/Bucles/Basico/code.java
/templates/Bucles/Basico/guide.txt
````

**Temas disponibles:** `Variables`, `Funciones`, `Condicionales`, `Bucles`, `EstructurasDeDatos`  
**Niveles disponibles:** `Basico`, `Medio`, `Avanzado`


## Funcionalidades clave:
- Listar catálogo
- Generar ejercicio (lee meta+code+guide → Markdown PRIMM)
- Guardar en `/output` sin sobreescribir (añadir sufijo si existe)

Entrada: CLI o REST; la lógica de negocio no depende de la interfaz.

### Ejemplo de uso
**CLI:**
````bash
primm-gen --tema Bucles --nivel Basico
primm-gen --list
````
**REST:**
````http
POST /ejercicios/generar?tema=Bucles&nivel=Basico
GET  /ejercicios
````

Flujo básico:
1) recibir tema+nivel
2) validar existencia
3) leer archivos
4) ensamblar plantilla PRIMM
5) escribir archivo en `/output`

## Formato de salida (esquema)
````markdown
# Título
Tema | Nivel | Docente | Fecha
---
```java
// code.java
```
## Predict
> Antes de ejecutar el código, responde: ¿qué crees que hace este programa?
## Run
> Ejecuta el código. ¿Confirma tus predicciones? ¿Qué resultados obtienes?
## Investigate
[Preguntas de guide.txt — sección Investigate]
## Modify
[Retos de guide.txt — sección Modify]
## Make
[Reto de guide.txt — sección Make]
````

### Modelo de dominio (esquema):
- Ejercicio { id,titulo,tema,nivel,rutaCodigo,rutaGuia }
- ConfigDocente { nombre, fecha }

### Reglas y validaciones:
- Si tema/nivel no existe → mensaje con opciones
- Si falta code.java o guide.txt → error claro con ruta
- Evitar sobrescritura (sufijo timestamp)
- Asegurar bloques de código bien cerrados

### Notas rápidas:
- Fase inicial: solo ficheros locales, sin BD ni auth
- Mantener dominio desacoplado de transporte
- Usar mínimas dependencias para facilitar mantenimiento

