-- Tablas base
CREATE TABLE IF NOT EXISTS empleados (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  puesto VARCHAR(50) NOT NULL,
  telefono VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS turnos (
  id SERIAL PRIMARY KEY,
  fecha VARCHAR(10) NOT NULL,
  hora_inicio VARCHAR(5) NOT NULL,
  hora_fin VARCHAR(5) NOT NULL,
  empleado_id INT REFERENCES empleados(id) ON DELETE SET NULL
);

-- Datos demo
INSERT INTO empleados (nombre, apellido, puesto, telefono) VALUES
  ('María', 'González', 'Barista', '555-0101'),
  ('Carlos', 'Rodríguez', 'Encargado', '555-0102'),
  ('Ana', 'Martínez', 'Barista', '555-0103'),
  ('Luis', 'López', 'Cajero', '555-0104')
ON CONFLICT DO NOTHING;

INSERT INTO turnos (fecha, hora_inicio, hora_fin, empleado_id) VALUES
  ('2025-01-15', '08:00', '14:00', 1),
  ('2025-01-15', '14:00', '20:00', 2),
  ('2025-01-16', '08:00', '14:00', 3),
  ('2025-01-16', '14:00', '20:00', 4)
ON CONFLICT DO NOTHING;
