USE gestion_aeropuertos;

INSERT INTO vol (numero_vol, destination, compagnie, type_vol, places_disponibles, statut) VALUES
('AT202', 'Madrid', 'Royal Air Maroc', 'National', 0, FALSE),
('AT303', 'Casablanca', 'Air Arabia Maroc', 'National', 40, TRUE),
('AT505', 'Londres', 'Royal Air Maroc', 'International', 0, TRUE),
('AT606', 'Marrakech', 'Air Arabia Maroc', 'National', 80, TRUE),
('AT707', 'Istanbul', 'Turkish Airlines', 'International', 25, TRUE),
('AT808', 'Agadir', 'Royal Air Maroc', 'National', 50, TRUE),
('AT909', 'Barcelone', 'Vueling', 'International', 35, TRUE);
