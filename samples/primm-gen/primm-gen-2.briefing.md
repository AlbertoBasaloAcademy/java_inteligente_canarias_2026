# Briefing: PRIMM-Gen — Fase 2 (simplificada)

## Objetivo
Llamar al modelo vía Spring AI y usar el primer ejemplo que genere como salida final.

## Entradas
- `meta.json` (id,titulo,tema,nivel)
- `code.java` (plantilla base)
- `guide.txt` (guía base)
- Opciones de generación (variedad/dificultad) — opcional

## Flujo simple
1) Construir prompt breve con `meta.json` + `code.java` + `guide.txt`.
2) Llamar al modelo via Spring AI.
3) Tomar el primer ejemplo devuelto (code + preguntas/retos) y usarlo.
4) Validación mínima: asegurar bloques de código cerrados.
5) Ensamblar Markdown PRIMM y guardar en `/output` o devolver .

## Notas importantes
- Plantillas locales siguen como fallback.
- Registrar prompt, modelo y timestamp en metadatos para trazabilidad.
- Mantener el adaptador de Spring AI para que el núcleo no dependa del proveedor.

````
Servicios (Spring AI) → Motor de composición → Markdown
````

