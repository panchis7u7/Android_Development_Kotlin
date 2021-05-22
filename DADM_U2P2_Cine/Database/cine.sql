#DROP DATABASE cine;
CREATE DATABASE cine;
use cine;

			CREATE TABLE horarios (
                id_horario INTEGER PRIMARY KEY auto_increment, 
                horario TEXT NOT NULL 
            );
            
            CREATE TABLE fechas (
                id_fecha INTEGER PRIMARY KEY NOT NULL auto_increment, 
                fecha TEXT NOT NULL
            );
            
            CREATE TABLE fechashorarios (
				id_fecha INTEGER NOT NULL, 
                id_horario INTEGER NOT NULL, 
                PRIMARY KEY (id_fecha, id_horario), 
                FOREIGN KEY (id_fecha) REFERENCES fechas(id_fecha) ON UPDATE CASCADE ON DELETE CASCADE, 
                FOREIGN KEY (id_horario) REFERENCES horarios(id_horario) ON UPDATE CASCADE ON DELETE CASCADE
            );
            
            CREATE TABLE peliculas (
                id_pelicula INTEGER PRIMARY KEY auto_increment, 
                titulo TEXT NOT NULL, 
                imagen TEXT NOT NULL, 
                cover TEXT NOT NULL, 
                rating INT NOT NULL,
                director TEXT NOT NULL,
                duracion TEXT NOT NULL,
                genero TEXT NOT NULL,
                sinopsis TEXT NOT NULL
            );
            
            CREATE TABLE fechaspeliculas (
                id_pelicula INTEGER NOT NULL, 
                id_fecha INTEGER NOT NULL, 
                PRIMARY KEY (id_pelicula, id_fecha), 
                FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula) ON UPDATE CASCADE ON DELETE CASCADE, 
                FOREIGN KEY (id_fecha) REFERENCES fechas(id_fecha) ON UPDATE CASCADE ON DELETE CASCADE
            );
            
            CREATE TABLE compras (
                id_compra INTEGER PRIMARY KEY auto_increment,
                total REAL NOT NULL,
                noAsientos INTEGER,
                asientos TEXT,
                departamento TEXT NOT NULL,
                id_pelicula INTEGER,
                FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula) ON UPDATE CASCADE ON DELETE CASCADE
            );
            
            INSERT INTO horarios (horario) VALUES ('9:00');
            INSERT INTO horarios (horario) VALUES ("10:00");
            INSERT INTO horarios (horario) VALUES ("11:00");
            INSERT INTO horarios (horario) VALUES ("12:00");
            INSERT INTO horarios (horario) VALUES ("13:00");
            INSERT INTO horarios (horario) VALUES ("14:00");
            INSERT INTO horarios (horario) VALUES ("15:00");
            INSERT INTO horarios (horario) VALUES ("16:00");
            INSERT INTO horarios (horario) VALUES ("17:00");
            INSERT INTO horarios (horario) VALUES ("18:00");
            INSERT INTO horarios (horario) VALUES ("19:00");
            INSERT INTO horarios (horario) VALUES ("20:00");
            
            INSERT INTO fechas (fecha) VALUES ('11 Marzo');
            INSERT INTO fechas (fecha) VALUES ('12 Marzo');
            INSERT INTO fechas (fecha) VALUES ('13 Marzo');
            INSERT INTO fechas (fecha) VALUES ('14 Marzo');
            INSERT INTO fechas (fecha) VALUES ('15 Marzo');
            INSERT INTO fechas (fecha) VALUES ('16 Marzo');
            INSERT INTO fechas (fecha) VALUES ('17 Marzo');
            INSERT INTO fechas (fecha) VALUES ('18 Marzo');
            
            INSERT INTO fechashorarios VALUES (1,1);
            INSERT INTO fechashorarios VALUES (1,2);
            INSERT INTO fechashorarios VALUES (1,3);
            INSERT INTO fechashorarios VALUES (2,5);
            INSERT INTO fechashorarios VALUES (2,6);
            INSERT INTO fechashorarios VALUES (2,1);
            INSERT INTO fechashorarios VALUES (5,1);
            INSERT INTO fechashorarios VALUES (5,2);
            INSERT INTO fechashorarios VALUES (4,4);
            
            INSERT INTO peliculas VALUES (1,"Avengers Endgame", "imagen", "cover", 4.2, "director", "duracion", "drama", "sinopsis");
            INSERT INTO peliculas VALUES (2,"Avengers Endgame", "imagen", "cover", 4.2, "director", "duracion", "drama", "sinopsis");
            INSERT INTO peliculas VALUES (3,"Avengers Endgame", "imagen", "cover", 4.2, "director", "duracion", "drama", "sinopsis");
            INSERT INTO peliculas VALUES (4,"Avengers Endgame", "imagen", "cover", 4.2, "director", "duracion", "drama", "sinopsis");
            
            INSERT INTO fechaspeliculas VALUES (1,1);
            INSERT INTO fechaspeliculas VALUES (1,2);
            INSERT INTO fechaspeliculas VALUES (1,3);
            INSERT INTO fechaspeliculas VALUES (2,4);
            INSERT INTO fechaspeliculas VALUES (3,1);
            INSERT INTO fechaspeliculas VALUES (4,6);
            
            SELECT * FROM peliculas;
            
            SELECT fecha, horario FROM peliculas AS p
            INNER JOIN fechaspeliculas AS fp ON fp.id_pelicula = 1
            INNER JOIN fechas as f ON f.id_fecha = fp.id_fecha
            INNER JOIN fechashorarios as fh ON fh.id_fecha =f.id_fecha
            INNER JOIN horarios as h ON h.id_horario = fh.id_horario
            WHERE p.id_pelicula = 1;
            
            SELECT p.id_pelicula, titulo, imagen, cover, rating, director, duracion, genero, sinopsis, fecha, horario FROM peliculas AS p
            INNER JOIN fechaspeliculas AS fp ON fp.id_pelicula = p.id_pelicula
            INNER JOIN fechas as f ON f.id_fecha = fp.id_fecha
            INNER JOIN fechashorarios as fh ON fh.id_fecha =f.id_fecha
            INNER JOIN horarios as h ON h.id_horario = fh.id_horario