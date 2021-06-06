-- Esto no lo hice a mano... Automatice la generacion de los inserts con python en base a archivos JSON que contienen los datos de cada profesor, materia y horarios; Lo demas es copy paste bruh. 

INSERT INTO profesores VALUES (1, 'Mora Garcia Jorge');
INSERT INTO profesores VALUES (2, 'Huerta Cortes Andres Ivan');
INSERT INTO profesores VALUES (3, 'Pacheco Pimentel Efren de Jesus');
INSERT INTO profesores VALUES (4, 'Mora Tenorio Sandra');
INSERT INTO profesores VALUES (5, 'Gallegos Perez Joxim');
INSERT INTO profesores VALUES (6, 'Florian Ernesto Claudio Ernesto');
INSERT INTO profesores VALUES (7, 'Sanchez Vega Jorge');
INSERT INTO profesores VALUES (8, 'Florian Arenas Claudio Ernesto');
INSERT INTO profesores VALUES (9, 'Antolino Hernandez Anastacio');
INSERT INTO profesores VALUES (10, 'Amaro Flores Alejandro');
INSERT INTO profesores VALUES (11, 'Ortiz Ortiz Octavio Salud');
INSERT INTO profesores VALUES (12, 'Chavez Jacobo Victor Manuel');
INSERT INTO profesores VALUES (13, 'Rios Ponce Juan');
INSERT INTO profesores VALUES (14, 'Calderon Cortez Javier');
INSERT INTO profesores VALUES (15, 'Alcaraz Chaves Jesus Eduardo');
INSERT INTO profesores VALUES (16, 'Flores Tinoco Alma Lilia Deni');
INSERT INTO profesores VALUES (17, 'Morales Lopez Felipe');
INSERT INTO profesores VALUES (18, 'Lopez Torres Joel');
INSERT INTO profesores VALUES (19, 'Villagomez Cardenas Salvador Jonathan');
INSERT INTO profesores VALUES (20, 'Jimenez Murillo Jose Alfredo');
INSERT INTO profesores VALUES (21, 'Tapia Colin Luis Enrique');
INSERT INTO profesores VALUES (22, 'Blancas Martinez Monica Adriana');
INSERT INTO profesores VALUES (23, 'Lopez Ruiz Manuel');
INSERT INTO profesores VALUES (24, 'Hernandez Esquivel Jose Omar');
INSERT INTO profesores VALUES (25, 'Guzman Marines Raymundo');
INSERT INTO profesores VALUES (26, 'Manzo Mora Reynaldo');
INSERT INTO profesores VALUES (27, 'Robledo Torrecilla Eva Maria');
INSERT INTO profesores VALUES (28, 'Rodriguez Baltazar Margarita');
INSERT INTO profesores VALUES (29, 'Atienzo de la Cruz Mora Lizeth');
INSERT INTO profesores VALUES (30, 'Felix Escalona Samuel');
INSERT INTO profesores VALUES (31, 'Duran Ibarra Miguel Alberto');
INSERT INTO profesores VALUES (32, 'Martinez Rosiles Carol Aidee');
INSERT INTO profesores VALUES (33, 'Garcia Ramirez Maria del Carmen');
INSERT INTO profesores VALUES (34, 'Casimiro Linares Edgar');
INSERT INTO profesores VALUES (35, 'Ramos Diaz J. Guadalupe');
INSERT INTO profesores VALUES (36, 'Hernandez Lopez Hugo Fernando');
INSERT INTO profesores VALUES (37, 'Amauri Cortes Coria');
INSERT INTO profesores VALUES (38, 'Lara Barcenas Ruben');
INSERT INTO profesores VALUES (39, 'Viacava Breiding Fernando Pedro');
INSERT INTO profesores VALUES (40, 'Rojas Prospero Ireri Tsipekua');
INSERT INTO profesores VALUES (41, 'Millarez Torres Cristhian');
INSERT INTO profesores VALUES (42, 'Rodriguez Tapia Marco Alonso');
INSERT INTO profesores VALUES (43, 'Perez Arreola Cesar Alejandro');
INSERT INTO profesores VALUES (44, 'Vaca Astorga Jordi');
INSERT INTO profesores VALUES (45, 'Solis Robles Juan Javier');
INSERT INTO profesores VALUES (46, 'Vargas Lua Gabriela');
INSERT INTO profesores VALUES (47, 'Vasconcelos Duarte Jose Raul');
INSERT INTO profesores VALUES (48, 'NA');

--1er Semestre.
INSERT INTO asignaturas VALUES (1, 'Calculo Diferencial', 'B1T1', 5, 1);
INSERT INTO asignaturas VALUES (2, 'Fundamentos de Programacion', 'B1T2', 5, 1);
INSERT INTO asignaturas VALUES (3, 'Matematicas Discretas I', 'B1T3', 5, 1);
INSERT INTO asignaturas VALUES (4, 'Introduccion a las TICs', 'B1T4', 3, 1);
INSERT INTO asignaturas VALUES (5, 'Taller de Etica', 'B1T5', 4, 1);
INSERT INTO asignaturas VALUES (6, 'Fundamentos de Investigacion', 'B1T6', 4, 1);
INSERT INTO grupos VALUES (1, 1, 21, 'A', '17:00-18:00', '17:00-18:00', '17:00-18:00', '17:00-18:00', '17:00-18:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (2, 2, 23, 'A', '18:00-19:00', '18:00-19:00', '18:00-19:00', '18:00-20:00', '', 'LC3', 'F6', 'F6', 'LC3', '');
INSERT INTO grupos VALUES (3, 3, 20, 'A', '16:00-17:00', '16:00-17:00', '16:00-17:00', '16:00-17:00', '16:00-17:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (4, 4, 24, 'A', '19:00-20:00', '19:00-20:00', '19:00-20:00', '', '', 'F6', 'F6', 'F6', '', '');
INSERT INTO grupos VALUES (5, 5, 24, 'A', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', '', 'F6', 'F6', 'F6', 'F6', '');
INSERT INTO grupos VALUES (6, 6, 22, 'A', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', '', 'F6', 'F6', 'F6', 'F6', '');

--2do Semestre.
INSERT INTO asignaturas VALUES (7, 'Calculo Integral', 'B2T1', 5, 2, 2, 90, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (8, 'Programacion Orientada a Objetos', 'B2T2', 5, 2, 2, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (9, 'Matematicas Discretas II', 'B2T3', 5, 2, 2, 95, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (10, 'Algebra Lineal', 'B2T4', 5, 2, 2, 95, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (11, 'Probabilidad y Estadistica', 'B2T5', 5, 2, 2, 87, 'R1', 'Evaluacion Regularizacion Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (12, 'Contabilidad y Costos', 'B2T6', 5, 2, 2, 89, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO grupos VALUES (7, 7, 29, 'A', '8:00-9:00', '8:00-9:00', '8:00-9:00', '8:00-9:00', '8:00-9:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (8, 7, 27, 'B', '7:00-8:00', '7:00-8:00', '7:00-8:00', '7:00-8:00', '7:00-8:00', 'F5', 'F5', 'F5', 'F5', 'F5');
INSERT INTO grupos VALUES (8, 8, 25, 'A', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', 'LC2', 'LC2', 'F6', 'LC2', 'LC3');
INSERT INTO grupos VALUES (10, 9, 36, 'A', '7:00-8:00', '7:00-8:00', '7:00-8:00', '7:00-8:00', '7:00-8:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (11, 10, 26, 'A', '9:00-10:00', '9:00-10:00', '9:00-10:00', '9:00-10:00', '9:00-10:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (12, 10, 30, 'B', '8:00-9:00', '8:00-9:00', '8:00-9:00', '8:00-9:00', '8:00-9:00', 'F5', 'F5', 'F5', 'F5', 'F5');
INSERT INTO grupos VALUES (13, 11, 28, 'A', '10:00-11:00', '10:00-11:00', '10:00-11:00', '10:00-11:00', '10:00-11:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (14, 12, 31, 'A', '12:00-13:00', '12:00-13:00', '12:00-13:00', '12:00-13:00', '12:00-13:00', 'F6', 'F6', 'F6', 'F6', 'F6');

--3er Semestre.
INSERT INTO asignaturas VALUES (13, 'Desarrollo Sustentable', 'B6T5', 5, 3, 4, 95, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (14, 'Estructura y Organizacion de Datos', 'B3T2', 5, 3, 3, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (15, 'Matematicas para la Toma de Desiciones', 'B3T3', 5, 3, 3, 94, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (16, 'Fundamentos de Base de Datos', 'B3T4', 5, 3, 3, 95, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (17, 'Laboratorio de Electricidad y Magnetismo', 'B3TA', 0, 3, 2, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (18, 'Electricidad y Magnetismo', 'B3T5', 4, 3, 2, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (19, 'Administracion Gerencial', 'B3T6', 4, 3, 3, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO grupos VALUES (15, 13, 12, 'A', '13:00-14:00', '13:00-14:00', '13:00-14:00', '', '13:00-14:00', 'K5', 'K5', 'K5', '', 'K5');
INSERT INTO grupos VALUES (16, 13, 12, 'B', '15:00-16:00', '15:00-16:00', '15:00-16:00', '', '15:00-16:00', 'K5', 'K5', 'K5', '', 'K5');
INSERT INTO grupos VALUES (17, 14, 15, 'A', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', 'LC2', 'LC2', 'LC2', 'LC2', 'F2');
INSERT INTO grupos VALUES (18, 14, 17, 'B', '13:00-14:00', '13:00-14:00', '13:00-14:00', '13:00-14:00', '13:00-14:00', 'LC2', 'LC2', 'LC2', 'LC2', 'F2');
INSERT INTO grupos VALUES (19, 15, 13, 'A', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', 'F5', 'F5', 'F5', 'F5', 'F5');
INSERT INTO grupos VALUES (20, 16, 5, 'A', '16:00-17:00', '16:00-17:00', '16:00-17:00', '16:00-17:00', '16:00-17:00', 'LTW', 'LTW', 'F1', 'LTW', 'LTW');
INSERT INTO grupos VALUES (21, 16, 19, 'B', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', 'LTW', 'LTW', 'LTW', 'LTW', 'F3');
INSERT INTO grupos VALUES (22, 17, 14, 'AA', '', '', '17:00-19:00', '', '', '', '', 'LF2', '', '');
INSERT INTO grupos VALUES (23, 17, 14, 'AB', '', '', '', '', '17:00-19:00', '', '', '', '', 'LF2');
INSERT INTO grupos VALUES (24, 18, 16, 'A', '18:00-19:00', '18:00-19:00', '', '', '', 'F5', 'F5', '', '', '');
INSERT INTO grupos VALUES (25, 18, 16, 'B', '', '', '18:00-19:00', '18:00-19:00', '', '', 'F5', 'F5', '', '');
INSERT INTO grupos VALUES (26, 19, 18, 'A', '17:00-18:00', '17:00-18:00', '17:00-18:00', '17:00-18:00', '', 'F5', 'F5', 'F5', 'F5', '');

--4to Semestre.
INSERT INTO asignaturas VALUES (20, 'Matematicas Aplicadas a Comunicaciones', 'B4T1', 5, 4, 3, 95, 'R1', 'Evaluacion Regularizacion Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (21, 'Programacion II', 'B4T2', 5, 4, 4, 98, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (22, 'Fundamentos de Redes', 'B4T3', 5, 4, 3, 98, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (23, 'Taller de Base de Datos', 'B4T4', 5, 4, 4, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (24, 'Circuitos Electricos y Electronicos', 'B4T5', 5, 4, 3, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (25, 'Ingenieria de Software', 'B4T6', 4, 4, 4, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO grupos VALUES (27, 20, 34, 'A', '13:00-14:00', '13:00-14:00', '13:00-14:00', '13:00-14:00', '', 'F5', 'F5', 'F5', 'F5', '');
INSERT INTO grupos VALUES (28, 20, 34, 'B', '12:00-13:00', '12:00-13:00', '12:00-13:00', '12:00-13:00', '', 'F6', 'F6', 'F6', 'F6', '');
INSERT INTO grupos VALUES (29, 21, 35, 'A', '10:00-11:00', '10:00-11:00', '10:00-11:00', '10:00-11:00', '10:00-11:00', 'LC1', 'LC1', 'F5', 'LC1', 'LC1');
INSERT INTO grupos VALUES (30, 22, 36, 'A', '9:00-10:00', '9:00-10:00', '9:00-10:00', '9:00-10:00', '9:00-10:00', 'F5', 'F5', 'LRD', 'F5', 'LRD');
INSERT INTO grupos VALUES (31, 22, 42, 'B', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', 'LRD', 'F5', 'F5', 'F5', 'LRD');
INSERT INTO grupos VALUES (32, 23, 17, 'A', '12:00-13:00', '12:00-13:00', '', '12:00-13:00', '12:00-13:00', 'LC3', 'LC3', '', 'LC3', 'LC3');
INSERT INTO grupos VALUES (33, 23, 37, 'B', '15:00-14:00', '15:00-14:00', '15:00-14:00', '15:00-14:00', '', 'LC1', 'LC1', 'LC1', 'LC1', '');
INSERT INTO grupos VALUES (34, 24, 33, 'A', '8:00-9:00', '', '8:00-9:00', '8:00-9:00', '', '', '', '', '', '');
INSERT INTO grupos VALUES (35, 24, 33, 'B', '7:00-8:00', '', '7:00-8:00', '7:00-8:00', '', 'F4', '', 'F4', 'F4', '');
INSERT INTO grupos VALUES (36, 25, 32, 'A', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', 'F5', 'F5', 'F5', 'F5', '');

--5to Semestre.
INSERT INTO asignaturas VALUES (26,  'Analisis de Señales y Sistemas de Comunicacion', 'B5T1', 5, 5, 5, 97, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (27,  'Administracion de Proyectos', 'B5T2', 5, 5, 4, 88, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (28,  'Redes de Computadoras', 'B5T3', 5, 5, 4, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (29,  'Bases de Datos Distribuidas', 'B5T4', 5, 5, 5, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (30,  'Arquitectura de Computadoras', 'B5T5', 4, 5, 4, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (31,  'Taller de Ingenieria en Software', 'B5T6', 4, 5, 5, 100, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO grupos VALUES (37, 26, 2, 'A', '', '13:00-14:00', '13:00-14:00', '13:00-14:00', '', '', 'F4', 'F4', 'F4', '');
INSERT INTO grupos VALUES (38, 26, 2, 'B', '13:00-14:00', '13:00-14:00', '', '13:00-14:00', '', 'F4', 'F3', '', 'F3', '');
INSERT INTO grupos VALUES (39, 27, 7, 'A', '17:00-18:00', '17:00-18:00', '17:00-18:00', '17:00-18:00', '', 'F3', 'F3', 'F3', 'F3', '');
INSERT INTO grupos VALUES (40, 27, 7, 'B', '', '18:00-19:00', '18:00-19:00', '18:00-19:00', '18:00-19:00', '', 'F4', 'F4', 'F4', 'F4');
INSERT INTO grupos VALUES (41, 28, 3, 'A', '', '11:00-13:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', '', 'LRD', 'F3', 'F3', 'F3');
INSERT INTO grupos VALUES (42, 28, 1, 'B', '11:00-13:00', '12:00-13:00', '12:00-13:00', '12:00-13:00', '', 'LRD', 'K7', 'K7', 'K7', '');
INSERT INTO grupos VALUES (43, 29, 5, 'A', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', 'LC1', 'F3', 'LC1', 'F3', 'LC1');
INSERT INTO grupos VALUES (44, 30, 4, 'A', '', '16:00-17:00', '', '16:00-17:00', '', '', 'F3', '', 'F3', '');
INSERT INTO grupos VALUES (45, 30, 1, 'B', '10:00-11:00', '10:00-11:00', '', '', '', 'K7', 'K7', '', '', '');
INSERT INTO grupos VALUES (46, 31, 6, 'A', '18:00-19:00', '18:00-19:00', '18:00-19:00', '18:00-19:00', '', 'F3', 'F3', 'F3', 'F3', '');

--6to Semestre.
INSERT INTO asignaturas VALUES (32, 'Telecomunicaciones', 'B6T1', 5, 6, 6, null, '', '', '');
INSERT INTO asignaturas VALUES (33, 'Tecnologias Inalambricas', 'B6T6', 4, 6, 5, 94, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (34, 'Interaccion Humano Computadora', 'B7T6', 4, 6, 4, 99, '01', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (35, 'Sistemas Operativos I', 'B6T4', 4, 6, 6, null, '', '', '');
INSERT INTO asignaturas VALUES (36, 'Programacion Web', 'B6T2', 5, 6, 5, 100, '01', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (37, 'Desarrollo de Emprendedores', 'B6T3', 5, 6, 4, 88, '01', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO grupos VALUES (47, 32, 41, 'A', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', 'F4', 'F4', 'F4', 'F4', 'LRD');
INSERT INTO grupos VALUES (48, 32, 40, 'B', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', '11:00-12:00', 'F4', 'F4', 'F4', 'F4', 'LRD');
INSERT INTO grupos VALUES (49, 33, 40, 'A', '', '9:00-11:00', '', '9:00-11:00', '', '', 'F4', '', 'F4', '');
INSERT INTO grupos VALUES (50, 34, 42, 'A', '', '8:00-9:00', '8:00-9:00', '8:00-9:00', '8:00-9:00', '', 'F4', 'F4', 'F4', 'F4');
INSERT INTO grupos VALUES (51, 35, 24, 'A', '12:00-13:00', '12:00-13:00', '12:00-13:00', '12:00-13:00', '', 'F5', 'F5', 'F5', 'F5', '');
INSERT INTO grupos VALUES (52, 35, 24, 'B', '11:00-12:00','11:00-12:00','11:00-12:00','11:00-12:00','', 'F2','F2','F2','F2','');
INSERT INTO grupos VALUES (53, 36, 43, 'A', '9:00-10:00', '', '9:00-11:00', '', '9:00-11:00', 'LC2', '', 'LC3', '', 'LC3');
INSERT INTO grupos VALUES (54, 37, 39, 'A', '7:00-8:00', '7:00-8:00', '7:00-8:00', '7:00-8:00', '7:00-8:00', 'F4', 'F4', 'F4', 'F4', 'F4');
INSERT INTO grupos VALUES (55, 37, 39, 'B', '15:00-16:00', '15:00-16:00', '15:00-16:00', '16:00-16:00', '15:00-16:00', 'F4', 'F4', 'F4', 'F4', 'F4');

--7mo Semestre.
INSERT INTO asignaturas VALUES (38, 'Introduccion a la Seguridad de la Informacion', 'B7T7', 5, 7, 6, null, '', '', '');
INSERT INTO asignaturas VALUES (39, 'Redes Emergentes', 'B7T1', 5, 7, 6, null, '', '', '');
INSERT INTO asignaturas VALUES (40, 'Taller de Investigacion I', 'B7T3', 4, 7, 6, null, '', '', '');
INSERT INTO asignaturas VALUES (41,  'Sistemas Operativos II', 'B7T4', 5, 7, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (42, 'Desarrollo de Aplicaciones para Dispositivos Moviles', 'B7T2', 5, 7, 6, null, '', '', '');
INSERT INTO asignaturas VALUES (43,  'Negocios Electronicos I', 'B7T5', 4, 7, 5, 100, '01', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado');
INSERT INTO asignaturas VALUES (44,  'Actividades Complementarias', 'B9T1', 5, 7, 5, null, 'AD', 'AD', 'AD');
INSERT INTO grupos VALUES (56, 38, 9, 'A', '13:00-14:00', '13:00-14:00', '13:00-14:00', '13:00-14:00', '13:00-14:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (57, 38, 9, 'B', '12:00-13:00','12:00-13:00','12:00-13:00','12:00-13:00','12:00-13:00', 'K1','K1','K1','K1','K1');
INSERT INTO grupos VALUES (58, 39, 1, 'A', '16:00-17:00', '16:00-17:00', '16:00-17:00', '16:00-17:00', '16:00-17:00', 'F1', 'F1', 'LRD', 'F1', 'LRD');
INSERT INTO grupos VALUES (59, 39, 1, 'B', '15:00-16:00','15:00-16:00','15:00-16:00','15:00-16:00','15:00-16:00', 'LRD','K5','LRD','K5','K5');
INSERT INTO grupos VALUES (60, 40, 11, 'A', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', '', 'F1', 'F1', 'F1', 'F1', '');
INSERT INTO grupos VALUES (61, 41, 46, 'A', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', '15:00-16:00', 'F1', 'F1', 'F1', 'F1', 'F1');
INSERT INTO grupos VALUES (62, 42, 10, 'A', '18:00-19:00', '18:00-20:00', '', '18:00-20:00', '', 'LIS', 'LIS', '', 'LIS', '');
INSERT INTO grupos VALUES (63, 42, 10, 'B', '', '17:00-18:00', '18:00-20:00', '', '18:00-20:00', '', 'LIS', 'LIS', '', 'LIS');
INSERT INTO grupos VALUES (64, 43, 8, 'A', '17:00-18:00', '17:00-18:00', '', '17:00-18:00', '17:00-18:00', 'F1', 'P1', '', 'F1', 'F3');
INSERT INTO grupos VALUES (65, 44, 47, 'AD', '', '', '', '', '', '', '', '', '', '');

--8vo Semestre.
INSERT INTO asignaturas VALUES (45, 'Computo en la Nube', 'B8T8', 5, 8, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (46, 'Seguridad en Sistemas Operativos', 'B8T9', 5, 8, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (47, 'Negocios Electronicos II', 'B8T5', 5, 8, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (48, 'Administracion y Seguridad de Redes', 'B8T1', 5, 8, 6, null, '', '', '');
INSERT INTO asignaturas VALUES (49, 'Auditoria en Tecnologias de la Informacion', 'B8T2', 5, 8, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (50, 'Taller de Investigacion II', 'B8T3', 5, 8, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (51, 'Servicio Social', 'B9T2', 10, 8, 0, null, '', '', '');
INSERT INTO grupos VALUES (66, 45, 45, 'A', '12:00-13:00', '12:00:13:00', '12:00:13:00', '12:00-13:00', '12:00:13:00', 'F4', 'F4', 'F4', 'F4', 'F4');
INSERT INTO grupos VALUES (67, 46, 27, 'A', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', 'LC2', 'LC2', 'LC2', 'LC2', 'F2');
INSERT INTO grupos VALUES (68, 46, 38, 'B', '13:00-14:00', '13:00-14:00', '13:00-14:00', '13:00-14:00', '13:00-14:00', 'LC2', 'LC2', 'LC2', 'LC2', 'F1');
INSERT INTO grupos VALUES (69, 47, 32, 'A', '16:00-17:00', '16:00:17:00', '16:00:17:00', '16:00:17:00', '16:00:17:00', 'F3', 'F3', 'F3', 'F3', 'F3');
INSERT INTO grupos VALUES (70, 48, 38, 'A', '8:00-10:00', '8:00-10:00', '8:00-10:00', '', '8:00-10:00', 'LRD', 'F3', 'F3', '', 'F3');
INSERT INTO grupos VALUES (71, 49, 44, 'A', '14:00-15:00', '14:00:15:00', '14:00:15:00', '14:00:15:00', '14:00:15:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (72, 49, 44, 'B', '14:00-15:00', '14:00:15:00', '14:00:15:00', '14:00:15:00', '14:00:15:00', 'F6', 'F6', 'F6', 'F6', 'F6');
INSERT INTO grupos VALUES (73, 50, 11, 'A', '15:00-16:00', '15:00:16:00', '15:00:16:00', '15:00:16:00', '15:00:16:00', 'F3', 'F3', 'F3', 'F3', 'F3');

--9no Semestre.
INSERT INTO asignaturas VALUES (52, 'Seguridad en Redes', 'B9T7', 5, 9, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (53, 'Sistemas de Gestion de la Seguridad Informatica', 'B9T8', 5, 9, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (54, 'Ingenieria del Conocimiento', 'B8T4', 5, 9, 0, null, '', '', '');
INSERT INTO asignaturas VALUES (55, 'Residencias Profesionales', 'B9T3', 10, 9, 0, null, '', '', '');
INSERT INTO grupos VALUES (75, 52, 47, 'A', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', 'LSI', 'LSI', 'LSI', 'LRD', 'LRD');
INSERT INTO grupos VALUES (76, 53, 45, 'A', '9:00-10:00', '9:00-10:00', '9:00-10:00', '9:00-10:00', '9:00-10:00', 'F2', 'F2', 'F2', 'F2', 'F2');
INSERT INTO grupos VALUES (77, 53, 38, 'B', '10:00-11:00', '10:00-11:00', '10:00-11:00', '10:00-11:00', '10:00-11:00', 'K2', 'LSI', 'LSI', 'LSI', 'LRD');
INSERT INTO grupos VALUES (78, 54, 6, 'A', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', '14:00-15:00', 'F1', 'F1', 'F1', 'F1', 'F1');
INSERT INTO grupos VALUES (79, 55, 48, 'AD', '', '', '', '', '', '', '', '', '', '');

INSERT INTO grupos_alumnos VALUES ('1575c67f-e248-46bb-8cc7-748278f33b6a', 1, 1, 73, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado')
INSERT INTO grupos_alumnos VALUES ('1575c67f-e248-46bb-8cc7-748278f33b6a', 2, 1, 93, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado')
INSERT INTO grupos_alumnos VALUES ('1575c67f-e248-46bb-8cc7-748278f33b6a', 3, 1, 70, 'R1', 'Evaluacion Regularizacion Primera Vez', 'Curso Aprobado')
INSERT INTO grupos_alumnos VALUES ('1575c67f-e248-46bb-8cc7-748278f33b6a', 4, 1, 83, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado')
INSERT INTO grupos_alumnos VALUES ('1575c67f-e248-46bb-8cc7-748278f33b6a', 5, 1, 70, 'O1', 'Evaluacion Ordinaria Primera Vez', 'Curso Aprobado')
INSERT INTO grupos_alumnos VALUES ('1575c67f-e248-46bb-8cc7-748278f33b6a', 6, 1, 86, 'R1', 'Evaluacion Regularizacion Primera Vez', 'Curso Aprobado')
