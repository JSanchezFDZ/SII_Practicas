/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jesus Sanchez
 * Created: 24-may-2019
 */

/* USUARIO DEL SISTEMA BÁSICOS */
INSERT INTO APP.USUARIO (USUARIO, APELLIDOS, EMAIL, PASS, ROL, SOCIO_ID) VALUES ('admin', 'apellido1', 'admin@acoes.es', 'pass', 0, NULL)
INSERT INTO APP.USUARIO (USUARIO, APELLIDOS, EMAIL, PASS, ROL, SOCIO_ID) VALUES ('socio', 'apellido2', 'socio@acoes.es', 'pass', 1, NULL)
/* CUOTAS BÁSICAS DEL SISTEMA */
INSERT INTO APP.CUOTA (CODIGOCUOTA, NOMBRECUOTA, TIPO, "APORTACIÓN") VALUES (1,'Básica', 'Anual', 30)
INSERT INTO APP.CUOTA (CODIGOCUOTA, NOMBRECUOTA, TIPO, "APORTACIÓN") VALUES (2,'Estándar', 'Mensual', 15)

/* DATOS DE EJEMPLO:

    - CREACIÓN DE UN SOCIO
    - CREACIÓN DE USUARIO
    - ASIGNAR USUARIO
    - CREACIÓN NIÑO
    - CREAR APADRINAMIENTO
    - ASOCIAR APADRINAMIENTO
    - CREAR ENVIO
    - ASOCIAR ENVIO

    ¡¡ADVERTENCIA!!: DEBE IR JUSTAMENTE EN ESTE ORDEN.

*/
INSERT INTO APP.SOCIOS (ID, FECHAALTA, FECHABAJA, APELLIDO, CERTIFICADO, CODPOSTAL, CORREO, DIRECCION, ESTADO, NOMBRE, OBSERVACIONES, POBLACION, PROVINCIA, SECTOR, TELEFONO, USUARIO_USUARIO) VALUES (101, '2019-05-30 13:30:19.142', '2020-05-30 13:30:27.21', 'Martinez', 'Certificado A', 29010, 'juanM@gmail.com', 'c/ alameda nº 56', 'Padrino', 'Juan', 'Es voluntario', 'Málaga', 'Málaga', 'Empresario', '697282549', NULL)

INSERT INTO APP.USUARIO (USUARIO, APELLIDOS, EMAIL, PASS, ROL, SOCIO_ID) VALUES ('JuanM', 'Martinez', 'juanM@gmail.com', 'pass', 1, 101)

UPDATE APP.SOCIOS SET "USUARIO_USUARIO" = 'JuanM' WHERE ID = 101

INSERT INTO APP.NINOS (ID, AGENTE, APELLIDOS, BECA, COLONIAACTUAL, COMUNIDADPROCEDENCIA, ESTADO, FECHAALTA, FECHABAJA, FECHANAC, FOTO, GRADOCURSO, NOMBRE, OBSERVACIONES, PROYECTO, SEXO, CODAPADRINAMIENTO_CODAPADRINAMIENTO) VALUES (101, 'Manolo Ortiz', 'Jimenez Camacho', 'Educativa', 'Tegucigalpa', 'Villa Nueva', '', '2019-05-30 13:30:19.142', '2020-05-30 13:30:19.142', '2002-04-17 13:40:11.422', NULL, 'Cuarto curso', 'Maria', 'Es celiaca', 'Educativo', 'F', 101)

INSERT INTO APP.APADRINAMIENTO (CODAPADRINAMIENTO, FECHAAPADRINAMIENTO, OBSERVACIONES, NUMSOCIO_ID, CODNINO_ID) VALUES (101, '2019-05-30 13:30:19.142', 'Comprobar numero de cuenta', 101, 101)

INSERT INTO APP.SOCIOS_APADRINAMIENTO (SOCIOS_ID, APADR_CODAPADRINAMIENTO) VALUES (101, 101)

INSERT INTO APP.ENVIO (CODENVIO, FECHAENVIO, FECHALLEGADA, OBSERVACIONES, CODAPADRINAMIENTO_CODAPADRINAMIENTO) VALUES (101, '2019-06-10 13:30:19.142', '2019-06-30 13:30:19.142', 'Dos contenedores', 101)

INSERT INTO APP.APADRINAMIENTO_ENVIO (APADRINAMIENTO_CODAPADRINAMIENTO, CODENVIO_CODENVIO) VALUES (101, 101)