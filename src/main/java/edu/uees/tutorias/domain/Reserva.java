package edu.uees.tutorias.domain;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Long id;
    private EstadoReserva estado;

    // Nueva relación del patrón Observer: Lista de interesados en escuchar los cambios
    private List<ReservaObserver> observadores = new ArrayList<>();

    // Al crear una reserva, nace automáticamente como PENDIENTE
    public Reserva(Long id) {
        this.id = id;
        this.estado = EstadoReserva.PENDIENTE;
    }

    // Nuevo método del patrón Observer: Permite suscribir notificadores (ej. Email, Calendario)
    public void agregarObservador(ReservaObserver observer) {
        observadores.add(observer);
    }

    // Comportamientos que cambian el estado de forma segura
    public void confirmar() {
        // 1. Mantenemos tu lógica original de cambio de estado
        this.estado = EstadoReserva.CONFIRMADA;

        // 2. Nueva lógica Observer: Notificamos a todos los observadores suscritos
        for (ReservaObserver obs : observadores) {
            obs.onReservaConfirmada(this);
        }
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