INSERT INTO casa (nombre, fundador) VALUES
('Gryffindor', 'Godric Gryffindor'),
('Hufflepuff', 'Helga Hufflepuff'),
('Ravenclaw', 'Rowena Ravenclaw'),
('Slytherin', 'Salazar Slytherin')
ON CONFLICT (nombre) DO NOTHING;