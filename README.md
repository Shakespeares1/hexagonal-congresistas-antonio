CRUD Congresistas – Arquitectura Hexagonal (Java + MySQL)

Este repositorio contiene la aplicación desarrollada para el examen final de la asignatura Desarrollo de Software, implementada en Java Standalone (Swing) siguiendo estrictamente la Arquitectura Hexagonal (Ports & Adapters).

Características principales

Arquitectura Hexagonal completa

CRUDL sobre la entidad Congresista

MySQL + JDBC (adaptador secundario)

Java Swing (adaptador primario)

Dominio puro totalmente desacoplado

Servicio que orquesta casos de uso

Estructura organizada por capas

Estructura del proyecto
src/
 └─ com.congreso.domain
 └─ com.congreso.ports
 └─ com.congreso.application
 └─ com.congreso.adapters.db
 └─ com.congreso.adapters.gui
 └─ com.congreso.main

Script SQL
CREATE DATABASE congresodb;

USE congresodb;

CREATE TABLE congresistas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(150),
    pais VARCHAR(80)
);

Ejecución del proyecto

Importar el proyecto en NetBeans

Agregar MySQL Connector (mysql-connector-j-8.0.xx.jar)

Configurar tu usuario/contraseña en:
MySQLCongresistaRepository.java

Ejecutar MainApp.java

Se abrirá la interfaz gráfica para ejecutar el CRUD

Video de sustentación

Enlace del video de sustentación:
https://studio.youtube.com/video/aTBofRBML84/edit

👨‍💻 Autor

Antonio Luis De Ávila Pájaro
Ingeniería de Software – Universidad de Cartagena
2025
