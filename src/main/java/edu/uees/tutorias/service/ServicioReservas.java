package edu.uees.tutorias.service;

import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notification.Notificador;

public class ServicioReservas {
    // Dependemos de contratos (interfaces), no de implementaciones concretas
    private final RepositorioReservas repositorio;
    private final Notificador notificador;

    public ServicioReservas(RepositorioReservas repositorio, Notificador notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void procesarReserva(Reserva reserva, String emailEstudiante) {
        reserva.confirmar();
        repositorio.guardar(reserva);
        notificador.enviar(emailEstudiante, "Tu cita ha sido agendada con éxito.");
    }
}
