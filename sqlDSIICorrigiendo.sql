-----ENTREGA MODELO DE DATOS, SISTEMA TRANSPORTE MASIVO
-----Nombre: Juan David Patiño 0932180
-----Codigo: 200932180


DROP TABLE pasajero CASCADE;
DROP TABLE empleado CASCADE;
DROP TABLE tarjeta CASCADE;
DROP TABLE tarjeta_generica CASCADE;
DROP TABLE tarjeta_personalizada CASCADE;
DROP TABLE bus CASCADE;
DROP TABLE ruta CASCADE;
DROP TABLE reclamo CASCADE;
DROP TABLE recarga CASCADE;
DROP TABLE tarjeta_estacion CASCADE;
DROP TABLE estacion_auxservicio CASCADE;
DROP TABLE estacion_directorestacion CASCADE;
DROP TABLE conductor_bus CASCADE;
DROP TABLE bus_ruta CASCADE;
DROP TABLE estacion CASCADE;
DROP TABLE reclamo_directorestacion CASCADE;



CREATE TABLE empleado (
identificacion_empleado VARCHAR(50),
nombre_empleado VARCHAR(50),
direccion_empleado VARCHAR(50),
telefono_empleado VARCHAR(50),
email_empleado VARCHAR(50),
tipo_empleado VARCHAR(50),
password_empleado VARCHAR(50),
PRIMARY KEY(identificacion_empleado)
);

CREATE TABLE pasajero (
identificacion_pasajero VARCHAR(50),
nombre_pasajero VARCHAR(50),
direccion_pasajero VARCHAR(50),
telefono_pasajero VARCHAR(50),
email_pasajero VARCHAR(50),
PRIMARY KEY(identificacion_pasajero)
);

CREATE TABLE tarjeta (
pin_tarjeta VARCHAR(50),
saldo INT,
estado VARCHAR(50),
PRIMARY KEY(pin_tarjeta)
);

CREATE TABLE tarjeta_generica (
pin_generica VARCHAR(50),
PRIMARY KEY(pin_generica),
FOREIGN KEY(pin_generica) REFERENCES tarjeta(pin_tarjeta)
);

CREATE TABLE tarjeta_personalizada (
pin_personalizada VARCHAR(50),
identificacion_pasajero VARCHAR(50),
identificacion_auxservicio VARCHAR(50),
fecha DATE,
costo INT,
PRIMARY KEY(pin_personalizada),
FOREIGN KEY(pin_personalizada) REFERENCES tarjeta(pin_tarjeta),
FOREIGN KEY(identificacion_pasajero) REFERENCES pasajero(identificacion_pasajero),
FOREIGN KEY(identificacion_auxservicio) REFERENCES empleado(identificacion_empleado)
);


CREATE TABLE bus (
numerochasis_bus VARCHAR(50),
placa_bus VARCHAR(50),
numeropasajeros_bus VARCHAR(50),
tipo_bus VARCHAR(50),
PRIMARY KEY(numerochasis_bus)
);

CREATE TABLE ruta (
nombre_ruta VARCHAR(50),
nombrerecorrido_ruta VARCHAR(50),
descripcion_ruta VARCHAR(50),
PRIMARY KEY(nombre_ruta)
);

CREATE TABLE reclamo (
ticket_reclamo VARCHAR(50),
motivo_reclamo VARCHAR(50),
descripcion_reclamo VARCHAR(50),
solucion_reclamo VARCHAR(50),
estado_reclamo VARCHAR(50),
fecha_reclamo DATE,
identificacion_pasajero VARCHAR(50),
identificacion_auxservicio VARCHAR(50), 
PRIMARY KEY(ticket_reclamo),
FOREIGN KEY(identificacion_pasajero) REFERENCES pasajero(identificacion_pasajero),
FOREIGN KEY(identificacion_auxservicio) REFERENCES empleado(identificacion_empleado)
);


CREATE TABLE reclamo_directorestacion(
ticket_reclamo VARCHAR(50),
identificacion_directorestacion VARCHAR(50), 
fecha_solucion DATE,
PRIMARY KEY(ticket_reclamo,identificacion_directorestacion),
FOREIGN KEY(ticket_reclamo) REFERENCES reclamo(ticket_reclamo),
FOREIGN KEY(identificacion_directorestacion) REFERENCES empleado(identificacion_empleado)
);

CREATE TABLE estacion (
nombre_estacion VARCHAR(50),
direccion_estacion VARCHAR(50),
PRIMARY KEY(nombre_estacion)
);


CREATE TABLE recarga (
pin_tarjeta VARCHAR(50),
identificacion_auxservicio VARCHAR(50),
fecha DATE,
hora TIME,
valorRecarga INT,
PRIMARY KEY(pin_tarjeta, identificacion_auxservicio, fecha, hora),
FOREIGN KEY(identificacion_auxservicio) REFERENCES empleado(identificacion_empleado),
FOREIGN KEY(pin_tarjeta) REFERENCES tarjeta(pin_tarjeta)
);

CREATE TABLE tarjeta_estacion (
pin_tarjeta VARCHAR(50),
nombre_estacion VARCHAR(50),
fecha DATE,
hora TIME,
PRIMARY KEY(pin_tarjeta, nombre_estacion, fecha, hora),
FOREIGN KEY(nombre_estacion) REFERENCES estacion(nombre_estacion),
FOREIGN KEY(pin_tarjeta) REFERENCES tarjeta(pin_tarjeta)
);

CREATE TABLE estacion_auxservicio (
identificacion_auxservicio VARCHAR(50),
nombre_estacion VARCHAR(50),
fecha DATE,
PRIMARY KEY(identificacion_auxservicio, nombre_estacion, fecha),
FOREIGN KEY(nombre_estacion) REFERENCES estacion(nombre_estacion),
FOREIGN KEY(identificacion_auxservicio) REFERENCES empleado(identificacion_empleado)
);


CREATE TABLE estacion_directorestacion (
identificacion_directorestacion VARCHAR(50),
nombre_estacion VARCHAR(50),
fecha DATE,
PRIMARY KEY(identificacion_directorestacion, nombre_estacion, fecha),
FOREIGN KEY(nombre_estacion) REFERENCES estacion(nombre_estacion),
FOREIGN KEY(identificacion_directorestacion) REFERENCES empleado(identificacion_empleado)
);


CREATE TABLE conductor_bus (
identificacion_conductor VARCHAR(50),
numerochasis_bus VARCHAR(50),
fecha DATE,
horario VARCHAR(50),
PRIMARY KEY(identificacion_conductor, numerochasis_bus, fecha),
FOREIGN KEY(numerochasis_bus) REFERENCES bus(numerochasis_bus),
FOREIGN KEY(identificacion_conductor) REFERENCES empleado(identificacion_empleado)
);

CREATE TABLE bus_ruta (
nombre_ruta VARCHAR(50),
numerochasis_bus VARCHAR(50),
fecha DATE,
PRIMARY KEY(nombre_ruta, numerochasis_bus, fecha),
FOREIGN KEY(numerochasis_bus) REFERENCES bus(numerochasis_bus),
FOREIGN KEY(nombre_ruta) REFERENCES ruta(nombre_ruta)
);



