INSERT INTO EMPRESA (ID_EMPRESA, NOMBRE, RUC, ESTADO, FECHA_CREACION) VALUES
(1, 'Supermecados del Perú', '12345678901', 'Activo', '2024-11-12 20:58:00'),
(2, 'Petro Perú', '98765432109', 'Activo', '2024-11-12 20:58:00');

INSERT INTO AREA (ID_AREA, ID_EMPRESA, NOMBRE, ESTADO, FECHA_CREACION) VALUES
(1, 1, 'Recursos Humanos', 'Activo', '2024-11-12 20:58:00'),
(2, 1, 'Finanzas', 'Activo', '2024-11-12 20:58:00'),
(3, 2, 'Marketing', 'Activo', '2024-11-12 20:58:00');

INSERT INTO NOMINA (ID_NOMINA, NOMBRE, ESTADO, FECHA_CREACION) VALUES
(1, 'Nomina A', 'Activo', '2024-11-12 20:58:00'),
(2, 'Nomina B', 'Activo', '2024-11-12 20:58:00');

INSERT INTO SEDE (ID_SEDE, NOMBRE, ESTADO, FECHA_CREACION) VALUES
(1, 'Sede Central', 'Activo', '2024-11-12 20:58:00'),
(2, 'Sede Regional', 'Activo', '2024-11-12 20:58:00');

INSERT INTO TRABAJADOR (ID_TRABAJADOR, CODIGO_INTERNO, NOMBRE, APELLIDO, NUMERO_DOCUMENTO, FECHA_NACIMIENTO, SEXO, ID_AREA, ID_NOMINA, ESTADO, FECHA_CREACION) VALUES
(1, 'T001', 'Juan', 'Perez', '12345678', '1990-01-01', 'M', 1, 1, 'Activo', '2024-11-12 20:58:00'),
(2, 'T002', 'Maria', 'Gomez', '87654321', '1985-05-15', 'F', 2, 2, 'Activo', '2024-11-12 20:58:00'),
(3, 'T003', 'Carlos', 'Lopez', '11223344', '1992-07-20', 'M', 3, 1, 'Activo', '2024-11-12 20:58:00');

INSERT INTO USUARIO (ID_USUARIO, NOMBRE, APELLIDO, NOMBRE_USUARIO, CONTRASENIA, ID_SEDE, ESTADO, FECHA_CREACION) VALUES
(1, 'Juan', 'Pérez', 'admin', '123456', 1, 'A', '2024-10-11 12:00:00'),
(2, 'María', 'Gómez', 'mgomez', 'securepass', 1, 'I', '2024-10-11 12:30:00'),
(3, 'Carlos', 'López', 'clopez', 'mypassword', 2, 'A', '2024-10-11 13:00:00');