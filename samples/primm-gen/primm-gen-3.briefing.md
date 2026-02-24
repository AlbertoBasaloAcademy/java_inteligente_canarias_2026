# Briefing: PRIMM-Gen — Fase 3 (memoria simple)

## Objetivo
Agregar memoria semántica opcional que ayude a evitar repeticiones obvias cuando se
invoca al modelo (Fase 2). Mantenerlo simple: calcular embedding, buscar similaridad,
y decidir si pedir al modelo una variación o usar el primer ejemplo.

## Flujo simplificado
1) Calcular embedding de la petición (meta + breve resumen).
2) Buscar en el almacén vectorial (si existe) el ejercicio más similar.
3) Si la similaridad supera un umbral configurable → añadir instrucción al prompt:
   "genera una variación distinta"; en caso contrario → llamar al modelo normalmente.
4) Usar el primer ejemplo devuelto por el modelo (como en Fase 2).
5) Guardar embedding del ejercicio generado con metadatos (origen, timestamp).

## Reglas prácticas
- Memoria es opcional: el sistema debe funcionar sin ella (fallback a plantillas/LLM).
- Umbral de similaridad configurable (p.ej. 0.8), default conservador.
- Solo almacenar embeddings de salidas aceptadas (evitar basura).
- Registrar metadatos mínimos: prompt, modelo, timestamp, hash de salida.

## Integración
- Implementar un servicio pequeño «vector-store adapter» que exponga: 
  - `search(similarityThreshold)` 
  - `save(embedding, metadata)`
  - el resto de la aplicación solo usa esta interfaz.
- Mantener el adaptador separado del motor de composición y del adaptador Spring AI.

## Notas
- No automatizar decisiones complejas: 
  - si la generación se marca como "similar",
  - pedir al docente confirmación antes de publicar (opcional).
- Mantener plantillas locales y uso directo del modelo como fallback.


