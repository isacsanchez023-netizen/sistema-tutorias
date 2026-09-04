package edu.uees.tutorias.notification;

import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.domain.ReservaObserver;

public class EmailObserver implements ReservaObserver {
    @Override
    public void onReservaConfirmada(Reserva reserva) {
        System.out.println("[EMAIL] Cita confirmada enviada al correo del estudiante.");
    }
}