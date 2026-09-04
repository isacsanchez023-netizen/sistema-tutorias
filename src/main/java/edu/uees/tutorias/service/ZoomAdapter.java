package edu.uees.tutorias.service;

public class ZoomAdapter implements Videoconferencia {
    private final ProveedorZoom apiZoom;

    public ZoomAdapter() {
        this.apiZoom = new ProveedorZoom(); // Instanciamos la API externa
    }

    @Override
    public String crearSala(String titulo, String correoDocente) {
        // Traducimos los parámetros de nuestro sistema a los que exige Zoom
        return apiZoom.scheduleMeeting(titulo, correoDocente);
    }
}