-- Create turnos table
CREATE TABLE IF NOT EXISTS turnos (
  id SERIAL PRIMARY KEY,
  fecha VARCHAR(10) NOT NULL,
  hora_inicio VARCHAR(5) NOT NULL,
  hora_fin VARCHAR(5) NOT NULL,
  empleado_id INTEGER
);

-- Insert demo data
INSERT INTO turnos (fecha, hora_inicio, hora_fin, empleado_id) VALUES
  ('2025-01-15', '08:00', '14:00', 1),
  ('2025-01-15', '14:00', '20:00', 2),
  ('2025-01-16', '08:00', '14:00', 3),
  ('2025-01-16', '14:00', '20:00', 4)
ON CONFLICT DO NOTHING;

