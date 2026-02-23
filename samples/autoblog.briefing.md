# AutoBlog Briefing

Un **API backend** para la publicación gestionada de artículos de blog con moderación automatizada.

- Los artículos (`articles`) se redactan para un categoría específica (`category`), con etiquetas (`tags`) y una puntuación (`score`) de _seguridad de contenido_ mínima requerida para su publicación.
    
- Cada artículo tiene un límite de caracteres y etiquetas configurable para toda la plataforma.
    

- Cada articulo necesita un `slug` único generado a partir de la fecha y el título para su URL amigable.

- Ciclo de vida del estado del artículo: borrador (`draft`) → pendiente (`pending`) → publicado (`published`), o rechazado (`rejected`).
    
- Un autor se identifica por su dirección de correo electrónico (`email`) y tiene un nombre (`name`) y un alias (`alias`).
    
- Un autor puede enviar múltiples artículos para revisión, pero no puede exceder un límite de envíos diarios (`anti-spam`) configurado.
    
- Los artículos son analizados al enviarse para revisión, y la puntuación de seguridad/toxicidad se procesa a través de un **servicio de análisis externo (mock)**.
    

> [!WARNING] 
> AutoBlog es una plataforma de gestión de contenido ficticia. 
> El sistema está diseñado para fines de demostración y formación. 
> No apto para uso en producción; no se requiere seguridad ni base de datos real en la etapa inicial.

