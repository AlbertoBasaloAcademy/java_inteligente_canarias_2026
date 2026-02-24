# Briefing: PRIMM-Gen

## Descripción General

PRIMM-Gen es una herramienta desarrollada en Java con un framework web, diseñada para docentes
de programación. Su objetivo es automatizar la creación de materiales de aprendizaje
siguiendo la metodología **PRIMM** (Predict, Run, Investigate, Modify, Make).

> **Decisión de arquitectura:** Se utiliza un framework web como base para facilitar la
> evolución futura hacia generación dinámica de contenido mediante servicios de modelos de
> lenguaje (LLM), donde la capa de plantillas locales podrá ser reemplazada o complementada
> por llamadas a dichos modelos y por la incorporación de búsquedas semánticas mediante una
> solución de almacenamiento vectorial.

---

## 1. Descripción del Proyecto

El sistema funciona como un motor de composición que recupera fragmentos de código y guías
pedagógicas desde un repositorio local de plantillas para generar un único recurso educativo
listo para su distribución en formato Markdown.

---

## 2. Estructura del Repositorio de Plantillas

La carpeta `/templates` es la fuente de verdad del catálogo. Su estructura debe respetarse
estrictamente para que el sistema pueda descubrirla automáticamente:
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

### Formato de `meta.json`
````json
{
  "id": "bucles-basico-01",
  "titulo": "Recorrido con for",
  "tema": "Bucles",
  "nivel": "Basico"
}
````

---

## 3. Funcionalidades Principales

- **Gestión de Catálogo:** El sistema descubre automáticamente los ejercicios disponibles
  recorriendo la estructura de carpetas de `/templates`.
- **Composición Dinámica:** Lee `code.java` y `guide.txt` y los fusiona aplicando una
  plantilla Markdown estructurada por fases PRIMM.
- **Exportación Consolidada:** Genera un único archivo `.md` en la carpeta `/output`,
  listo para visualizar en GitHub, VS Code o Notion.
- **Listado de Catálogo:** Comando `--list` (CLI) o endpoint `GET /ejercicios` (REST)
  que muestra los ejercicios disponibles sin generar ningún archivo.

---

## 4. Capa de Entrada: CLI o REST

> [!NOTE]
> **Decisión a tomar por el alumno.** El núcleo de la aplicación (dominio, servicios,
> lógica de composición) debe ser independiente de la capa de entrada. Esto permite
> implementar una u otra interfaz sin modificar la lógica de negocio.
````
[Dominio + Servicios]  ←  independiente de la capa de transporte
        ↑                               ↑
CLI (biblioteca CLI)                  REST (framework web)
````

|                       | CLI                            | REST                               |
| --------------------- | ------------------------------ | ---------------------------------- |
| **Interfaz**          | Argumentos por terminal        | Endpoints HTTP                     |
| **Uso típico**        | Herramienta local del profesor | Integración con otras apps o front |
| **Librería sugerida** | Biblioteca ligera para CLI     | Framework web (MVC)                |
| **Complejidad**       | Menor                          | Mayor                              |

Ambas opciones deben cubrir los mismos casos de uso: listar catálogo, generar ejercicio
y (en fases posteriores) consultar historial.

---

## 5. Flujo de Ejecución (Lifecycle)

1. **Entrada de usuario:** El profesor especifica tema y nivel (CLI: argumentos, REST: query params o body).
2. **Validación de disponibilidad:** El sistema verifica que la combinación existe en `/templates`.
3. **Extracción de contenido:** Se leen `meta.json`, `code.java` y `guide.txt`.
4. **Ensamble del documento:** Se aplica la plantilla Markdown con las secciones PRIMM.
5. **Persistencia:** El archivo se guarda en `/output` con nombre normalizado.

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

---

## 6. Estructura del Documento de Salida
````markdown
# [Título del Ejercicio]
**Tema:** Bucles | **Nivel:** Básico | **Docente:** [Nombre] | **Fecha:** [Fecha]

---

## Predict
> Antes de ejecutar el código, responde: ¿qué crees que hace este programa?
```java
// [contenido de code.java]
```

## Run
> Ejecuta el programa y compara el resultado con tu predicción.

## Investigate
[Preguntas de guide.txt — sección Investigate]

## Modify
[Retos de guide.txt — sección Modify]

## Make
[Reto de guide.txt — sección Make]

---
*Generado con PRIMM-Gen*
````

---

## 7. Modelo de Dominio
````java
// Representa un ejercicio del catálogo
Ejercicio {
  String id;
  String titulo;
  String tema;
  String nivel;
  Path rutaCodigo;    // → code.java
  Path rutaGuia;      // → guide.txt
}

// Parámetros del docente para personalizar el pie del documento
ConfigDocente {
  String nombreDocente;
  LocalDate fecha;
}
````

---

## 8. Reglas de Negocio y Validaciones

- **Tema o nivel inexistente:** Informar al usuario y mostrar las opciones disponibles.
  No lanzar excepción sin mensaje.
- **Evitar sobrescritura:** Si el archivo de salida ya existe, añadir sufijo timestamp
  (`_20250224_1032`) antes de guardar.
- **Integridad del Markdown:** Asegurar que todos los bloques de código están
  correctamente cerrados (` ``` `).
- **Archivos incompletos:** Si falta `code.java` o `guide.txt` en una carpeta de plantilla,
  notificar el error indicando qué archivo falta y en qué ruta.

---

## 9. Notas de Desarrollo

> [!WARNING]
> PRIMM-Gen es una herramienta interna para profesores. En esta fase inicial no requiere
> persistencia en base de datos ni sistema de autenticación. El foco está en la lógica
> de procesamiento de ficheros y el cumplimiento de las reglas de negocio.

> [!NOTE]
> Se recomienda usar una librería ligera para parsear los argumentos CLI. Mantener la
> lógica de negocio desacoplada de la capa de entrada facilitará futuras alternativas
> de distribución.
