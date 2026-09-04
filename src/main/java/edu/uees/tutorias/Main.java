package edu.uees.tutorias;

import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notification.CalendarioObserver;
import edu.uees.tutorias.notification.EmailObserver;
import edu.uees.tutorias.service.Videoconferencia;
import edu.uees.tutorias.service.ZoomAdapter;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" DEMOSTRACIÓN DEL PATRÓN OBSERVER");
        System.out.println("=========================================\n");

        // 1. Creamos la reserva (Nace como PENDIENTE)
        Reserva reserva = new Reserva(1001L);
        System.out.println("Reserva creada - ID: " + reserva.getId() + " | Estado Inicial: " + reserva.getEstado());

        // 2. Suscribimos los observadores (Simulando que el panel o sistema los conecta)
        reserva.agregarObservador(new EmailObserver());
        reserva.agregarObservador(new CalendarioObserver());

        // 3. Confirmamos la reserva (Esto debe disparar las notificaciones automáticamente)
        System.out.println("\nProcesando confirmación...");
        reserva.confirmar();
        System.out.println("\nEstado Final de la reserva: " + reserva.getEstado());


        System.out.println("\n\n=========================================");
        System.out.println(" DEMOSTRACIÓN DEL PATRÓN ADAPTER");
        System.out.println("=========================================\n");

        // 1. Instanciamos el Adapter usando nuestro propio contrato interno
        Videoconferencia salaVirtual = new ZoomAdapter();

        // 2. Solicitamos la sala con nuestros parámetros (El Adapter traducirá por detrás)
        String enlace = salaVirtual.crearSala("Tutoría de Diseño de Software", "docente@uees.edu.ec");

        System.out.println("Resultado de la integración: \n" + enlace);
    }
}