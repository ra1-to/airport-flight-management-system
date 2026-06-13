CREATE DATABASE IF NOT EXISTS gestion_aeropuertos;
USE gestion_aeropuertos;

CREATE TABLE IF NOT EXISTS vol (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero_vol VARCHAR(20) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    compagnie VARCHAR(100) NOT NULL,
    type_vol VARCHAR(50) NOT NULL,
    places_disponibles INT NOT NULL,
    statut BOOLEAN NOT NULL
);
