package edu.uees.tutorias.domain;

public class Reserva {
    private Long id;
    private EstadoReserva estado;

    // Al crear una reserva, nace automáticamente como PENDIENTE
    public Reserva(Long id) {
        this.id = id;
        this.estado = EstadoReserva.PENDIENTE;
    }

    // Comportamientos que cambian el estado de forma segura
    public void confirmar() {
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public Long getId() {
        return id;
    }
}