create database hackaton;
use hackaton;

CREATE TABLE departamento (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

select * from estudiante;

CREATE TABLE provincia (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_departamento INT NOT NULL,
    FOREIGN KEY (id_departamento) REFERENCES departamento(id)
);

CREATE TABLE distrito (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_provincia INT NOT NULL,
    FOREIGN KEY (id_provincia) REFERENCES provincia(id)
);

CREATE TABLE programas_academico (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE estudiante (
    id INT IDENTITY(1,1) PRIMARY KEY,
    numero_documento INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    email NVARCHAR(255) NOT NULL,
    telefono INT NOT NULL,
    direccion NVARCHAR(300) NOT NULL,
    fecha_inscripcion DATETIME NOT NULL DEFAULT GETDATE(),
    estado CHAR(1) NOT NULL DEFAULT 'A',
    id_distrito INT NOT NULL,
    id_programa INT NOT NULL,

    CONSTRAINT UQ_estudiante_numero_documento UNIQUE (numero_documento),

    CONSTRAINT UQ_estudiante_email UNIQUE (email),

    CONSTRAINT CHK_Edad CHECK (
        DATEDIFF(YEAR, fecha_nacimiento, GETDATE()) BETWEEN 17 AND 60
    ),
    CONSTRAINT CHK_Nacimiento_Futura CHECK (
        fecha_nacimiento <= CAST(GETDATE() AS DATE)
    ),
    CONSTRAINT CHK_email_Format CHECK (
        email LIKE '%_@_%.__%'
    ),
    CONSTRAINT CHK_telefono_digitos CHECK (
        telefono NOT LIKE '%[^0-9]%'
    ),

    FOREIGN KEY (id_distrito) REFERENCES distrito(id),
    FOREIGN KEY (id_programa) REFERENCES programas_academico(id)
);

INSERT INTO departamento (nombre) VALUES
('Lima'),
('Cusco'),
('Arequipa');

INSERT INTO provincia (nombre, id_departamento) VALUES
('Lima', 1),
('Huarochirí', 1),
('Cusco', 2),
('Urubamba', 2),
('Arequipa', 3);

INSERT INTO distrito (nombre, id_provincia) VALUES
('Miraflores', 1),
('San Isidro', 1),
('Matucana', 2),
('Cusco', 3),
('Ollantaytambo', 4),
('Cayma', 5);

INSERT INTO programas_academico (nombre) VALUES
('Ingeniería de Sistemas'),
('Medicina'),
('Derecho'),
('Arquitectura');

INSERT INTO estudiante (numero_documento, nombre, apellido, fecha_nacimiento, email, telefono, direccion, id_distrito, id_programa) VALUES
(12345678, 'Juan', 'Perez', '1995-06-15', 'juan.perez@example.com', 987654321, 'Av. Siempre Viva 123', 1, 1),
(87654321, 'Maria', 'Lopez', '1998-11-22', 'maria.lopez@example.com', 912345678, 'Calle Falsa 456', 2, 2),
(11223344, 'Carlos', 'Gomez', '1990-02-05', 'carlos.gomez@example.com', 923456789, 'Jr. Los Pinos 789', 4, 3);

select * from estudiante;

update departamento
set nombre = 'pepe'
where id = 1;

DROP TABLE IF EXISTS estudiante;
DROP TABLE IF EXISTS distrito;
DROP TABLE IF EXISTS provincia;
DROP TABLE IF EXISTS programas_academico;
DROP TABLE IF EXISTS departamento;
