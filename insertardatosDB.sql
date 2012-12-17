INSERT INTO "public".bus (numerochasis_bus, placa_bus, numeropasajeros_bus, tipo_bus) VALUES ('101010', 'VCD-189', '50', 'Articulado');
INSERT INTO "public".bus (numerochasis_bus, placa_bus, numeropasajeros_bus, tipo_bus) VALUES ('12315', 'VCD-156', '50', 'Articulado');

INSERT INTO "public".bus_ruta (nombre_ruta, numerochasis_bus, fecha) VALUES ('E31', '12315', '2012-12-17');
INSERT INTO "public".bus_ruta (nombre_ruta, numerochasis_bus, fecha) VALUES ('E21', '101010', '2012-12-17');

INSERT INTO "public".empleado (identificacion_empleado, nombre_empleado, direccion_empleado, telefono_empleado, email_empleado, tipo_empleado, password_empleado) VALUES ('1', 'Andres', 'Calle 20', '4561254', 'andres@correo.com', 'Director Operativo', '1');
INSERT INTO "public".empleado (identificacion_empleado, nombre_empleado, direccion_empleado, telefono_empleado, email_empleado, tipo_empleado, password_empleado) VALUES ('2', 'Julian', 'Carrera 50', '6985698', 'julian@correo.com', 'Conductor', '2');
INSERT INTO "public".empleado (identificacion_empleado, nombre_empleado, direccion_empleado, telefono_empleado, email_empleado, tipo_empleado, password_empleado) VALUES ('3', 'Hector', 'Calle 63', '9483982', 'hector@correo.com', 'Aux Servicio', '3');
INSERT INTO "public".empleado (identificacion_empleado, nombre_empleado, direccion_empleado, telefono_empleado, email_empleado, tipo_empleado, password_empleado) VALUES ('4', 'Luis', 'Cr 98', '45698621', 'luis@correo.com', 'Director Estacion', '4');

INSERT INTO "public".conductor_bus (identificacion_conductor, numerochasis_bus, fecha, horario) VALUES ('2', '12315', '2012-12-17', '18:00 - 23:00');

INSERT INTO "public".estacion (nombre_estacion, direccion_estacion) VALUES ('Chiminangos', 'Cr 1 Calle 70');
INSERT INTO "public".estacion (nombre_estacion, direccion_estacion) VALUES ('Univalle', 'Cr 100 Calle 13');

INSERT INTO "public".pasajero (identificacion_pasajero, nombre_pasajero, direccion_pasajero, telefono_pasajero, email_pasajero) VALUES ('5', 'Juan', 'Cr 65', '3232653', 'juan@correo.com');

INSERT INTO "public".reclamo (ticket_reclamo, motivo_reclamo, descripcion_reclamo, solucion_reclamo, estado_reclamo, fecha_reclamo, identificacion_pasajero, identificacion_auxservicio) VALUES ('1', 'Mala informacion', 'un conductor me dio mal la informacion', 'Recompensa con pasajes','Solucionado', '2012-12-17', '5', '3');

INSERT INTO "public".ruta (nombre_ruta, nombrerecorrido_ruta, descripcion_ruta) VALUES ('E31', 'Chiminangos-Universidades', 'Chiminangos-Centro-Universidades');
INSERT INTO "public".ruta (nombre_ruta, nombrerecorrido_ruta, descripcion_ruta) VALUES ('E21', 'Alamos-Universidades', 'Alamos-Centro-Universidades');

INSERT INTO "public".tarjeta (pin_tarjeta, saldo, estado) VALUES ('123', 1000, 'activa');

INSERT INTO "public".tarjeta_personalizada (pin_personalizada, identificacion_pasajero, identificacion_auxservicio, fecha, costo) VALUES ('123', '5', '3', '2012-12-17', 3000);

