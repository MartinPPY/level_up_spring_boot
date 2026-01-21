INSERT INTO region (nombre) VALUES
( 'Región de Arica y Parinacota'),
( 'Región de Tarapacá'),
( 'Región de Antofagasta'),
( 'Región Metropolitana de Santiago'),
( 'Región de Valparaíso');

INSERT INTO comuna ( nombre, region_id) VALUES
-- Región de Arica y Parinacota
( 'Arica', 1),
( 'Camarones', 1),

-- Región de Tarapacá
( 'Iquique', 2),
( 'Alto Hospicio', 2),

-- Región de Antofagasta
( 'Antofagasta', 3),
( 'Calama', 3),

-- Región Metropolitana
( 'Santiago', 4),
( 'Providencia', 4),
( 'Las Condes', 4),
( 'Maipú', 4),

-- Región de Valparaíso
( 'Valparaíso', 5),
( 'Viña del Mar', 5),
( 'Quilpué', 5);



