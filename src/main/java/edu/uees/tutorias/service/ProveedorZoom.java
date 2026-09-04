package edu.uees.tutorias.service;

// Esta clase simula la API de Zoom que usa parámetros diferentes y que no podemos modificar
public class ProveedorZoom {
    public String scheduleMeeting(String subject, String organizer) {
        return "Enlace Zoom generado para: " + subject + " (Host: " + organizer + ")";
    }
}