package edu.uees.tutorias.notification;

import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.domain.ReservaObserver;

public class CalendarioObserver implements ReservaObserver {
    @Override
    public void onReservaConfirmada(Reserva reserva) {
        System.out.println("[CALENDARIO] Bloque de tiempo reservado en el calendario del docente.");
    }
}