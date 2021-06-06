-- @BLOCK
-- CREATE DATABASE scholar;
-- USE scholar;

CREATE TABLE IF NOT EXISTS estados(
    id_estado SERIAL PRIMARY KEY,
    estado VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS municipios(
    id_municipio SERIAL PRIMARY KEY,
    municipio VARCHAR(35) NOT NULL,
    id_estado INTEGER,
    FOREIGN KEY (id_estado) REFERENCES estados (id_estado) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS colonias(
    id_colonia SERIAL PRIMARY KEY,
    colonia VARCHAR(50) NOT NULL,
    codigo_postal CHAR(8),
    id_municipio INTEGER,
    FOREIGN KEY (id_municipio) REFERENCES municipios (id_municipio) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS residencias(
    id_residencia SERIAL PRIMARY KEY,
    domicilio VARCHAR(30),
    id_colonia INTEGER,
    id_municipio INTEGER,
    id_estado INTEGER,
    FOREIGN KEY (id_colonia) REFERENCES colonias (id_colonia) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_municipio) REFERENCES municipios (id_municipio) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_estado) REFERENCES estados (id_estado) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS alumnos (
    id_alumno UUID PRIMARY KEY NOT NULL,
    no_control CHAR(10) UNIQUE NOT NULL,
    correo CHAR(35) UNIQUE NOT NULL,
    contrasena VARCHAR(130) NOT NULL,
    curp CHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    fecha_nacimiento date,
    telefono CHAR(12),
    sexo CHAR(1),
    fotografia VARCHAR(200),
    id_residencia INTEGER,
    FOREIGN KEY (id_residencia) REFERENCES residencias(id_residencia) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS profesores(
    id_profesor SERIAL PRIMARY KEY,
    nombre VARCHAR(55) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS asignaturas(
    id_asignatura SERIAL PRIMARY KEY,
    asignatura VARCHAR(55) UNIQUE NOT NULL,
    clave CHAR(6) UNIQUE NOT NULL,
    creditos INTEGER NOT NULL,
    semestre INTEGER NOT NULL,  
);

CREATE TABLE IF NOT EXISTS grupos(
    id_grupo SERIAL PRIMARY KEY,
    id_asignatura INTEGER NOT NULL,
    id_profesor INTEGER,
    grupo CHAR(2) NOT NULL,
    horario_lunes CHAR(14),
    horario_martes CHAR(14),
    horario_miercoles CHAR(14),
    horario_jueves CHAR(14),
    horario_viernes CHAR(14),
    aula_lunes CHAR(14),
    aula_martes CHAR(14),
    aula_miercoles CHAR(14),
    aula_jueves CHAR(14),
    aula_viernes CHAR(14),
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas (id_asignatura) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_profesor) REFERENCES profesores (id_profesor) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS grupos_alumnos(
    id_alumno UUID NOT NULL,
    id_grupo INTEGER NOT NULL,
    estado CHAR(35),
    semestre_cursada INTEGER,
    calificacion INTEGER,
    regularizacion CHAR(4),
    evaluacion CHAR(40),
    observaciones CHAR(20) 
    PRIMARY KEY (id_alumno, id_grupo, estado),
    FOREIGN KEY (id_alumno) REFERENCES alumnos (id_alumno) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_grupo) REFERENCES grupos (id_grupo) ON UPDATE CASCADE ON DELETE CASCADE
);

-- @BLOCK
-- DROP TABLE IF EXISTS domicilios;
-- DROP TABLE IF EXISTS colonias;
-- DROP TABLE IF EXISTS municipios;
-- DROP TABLE IF EXISTS estados;
-- DROP TABLE IF EXISTS asignaturas_alumnos;
-- DROP TABLE IF EXISTS asignaturas_profesores;
-- DROP TABLE IF EXISTS asignaturas;
-- DROP TABLE IF EXISTS profesores;
-- DROP TABLE IF EXISTS alumnos;
