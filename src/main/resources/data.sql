INSERT INTO region (name) VALUES
( 'Región de Arica y Parinacota'),
( 'Región de Tarapacá'),
( 'Región de Antofagasta'),
( 'Región Metropolitana de Santiago'),
( 'Región de Valparaíso');

INSERT INTO comuna (name, region_id) VALUES
('Arica', (SELECT id FROM region WHERE name='Región de Arica y Parinacota')),
('Camarones', (SELECT id FROM region WHERE name='Región de Arica y Parinacota')),

('Iquique', (SELECT id FROM region WHERE name='Región de Tarapacá')),
('Alto Hospicio', (SELECT id FROM region WHERE name='Región de Tarapacá')),

('Antofagasta', (SELECT id FROM region WHERE name='Región de Antofagasta')),
('Calama', (SELECT id FROM region WHERE name='Región de Antofagasta')),

('Santiago', (SELECT id FROM region WHERE name='Región Metropolitana de Santiago')),
('Providencia', (SELECT id FROM region WHERE name='Región Metropolitana de Santiago')),
('Las Condes', (SELECT id FROM region WHERE name='Región Metropolitana de Santiago')),
('Maipú', (SELECT id FROM region WHERE name='Región Metropolitana de Santiago')),

('Valparaíso', (SELECT id FROM region WHERE name='Región de Valparaíso')),
('Viña del Mar', (SELECT id FROM region WHERE name='Región de Valparaíso')),
('Quilpué', (SELECT id FROM region WHERE name='Región de Valparaíso'));

INSERT INTO role(name)VALUES
('ROLE_USER'),
('ROLE_VENDEDOR'),
('ROLE_ADMIN');

INSERT INTO category (name) VALUES
('Juegos de Mesa'),
('Accesorios'),
('Consolas'),
('Computadores Gamers'),
('Sillas Gamers'),
('Mouse'),
('Mousepad'),
('Poleras Personalizadas');




