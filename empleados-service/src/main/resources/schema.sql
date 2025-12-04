-- Create empleados table
CREATE TABLE IF NOT EXISTS empleados (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  puesto VARCHAR(50) NOT NULL,
  telefono VARCHAR(20)
);

-- Insert demo data
INSERT INTO empleados (nombre, apellido, puesto, telefono) VALUES
  ('María', 'González', 'Barista', '555-0101'),
  ('Carlos', 'Rodríguez', 'Encargado', '555-0102'),
  ('Ana', 'Martínez', 'Barista', '555-0103'),
  ('Luis', 'López', 'Cajero', '555-0104')
ON CONFLICT DO NOTHING;

