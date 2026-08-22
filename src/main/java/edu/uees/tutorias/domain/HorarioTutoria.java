package edu.uees.tutorias.domain;

import java.time.LocalDateTime;

public class HorarioTutoria {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private boolean disponible;

    // Al crear un nuevo horario, nace disponible por defecto
    public HorarioTutoria(LocalDateTime inicio, LocalDateTime fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.disponible = true;
    }

    // Comportamiento que protege la regla de negocio
    public void reservar() {
        if (!disponible) {
            throw new IllegalStateException("El horario ya no está disponible para ser reservado");
        }
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }

    public LocalDateTime getInicio() { return inicio; }
    public LocalDateTime getFin() { return fin; }
    public boolean isDisponible() { return disponible; }
}