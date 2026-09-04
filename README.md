# Sistema de Gestión de Tutorías - Incremento 1 (Ae3)

## 1. Descripción del Problema
Este proyecto implementa el diseño orientado a objetos para el núcleo de un sistema de gestión de tutorías académicas. Su propósito es permitir que los docentes publiquen su disponibilidad y los estudiantes reserven citas, protegiendo las reglas de negocio (como evitar que un horario se reserve dos veces) y manteniendo una arquitectura altamente cohesiva y con bajo acoplamiento.

**Actualización (Incremento 1):** En esta fase, el sistema evoluciona para resolver dos cuellos de botella de diseño mediante patrones justificados:
* **Acoplamiento en notificaciones:** Se requería que múltiples receptores (correo, calendario) reaccionen al confirmar una cita sin modificar ni acoplar el flujo principal.
* **Incompatibilidad de APIs:** El modelo genérico necesitaba integrarse con proveedores externos de salas virtuales (como Zoom) que exigen parámetros diferentes a nuestro contrato interno.

## 2. Clases Principales, Componentes y Patrones
El dominio se ha diseñado distribuyendo las responsabilidades para evitar una "Clase Dios":
* **Usuario (Abstracta), Estudiante y Docente:** Manejan la identidad y disponibilidad de los actores.
* **HorarioTutoria:** Encapsula el bloque de tiempo y protege la regla de disponibilidad.
* **ServicioReservas:** Orquesta el caso de uso central sin acoplarse a detalles de infraestructura.
* **Reserva (Sujeto Observable):** Gestiona el ciclo de vida de la cita y ahora notifica automáticamente sus cambios de estado aplicando el patrón **Observer**.
* **ReservaObserver (EmailObserver, CalendarioObserver):** Observadores concretos que reaccionan de forma asíncrona a la confirmación de la reserva.
* **Videoconferencia y ZoomAdapter:** Implementación del patrón **Adapter** para traducir los parámetros de nuestro sistema a los requeridos por la API externa (`ProveedorZoom`), resolviendo la incompatibilidad de interfaces.

## 3. Decisiones de Diseño y Principios SOLID Aplicados
* **Principio de Responsabilidad Única (SRP):** Cada clase controla su propio estado. `Reserva` es la única encargada de evaluarse a sí misma. Con el nuevo incremento, el patrón Observer permitió delegar el envío de correos y actualizaciones de calendario a clases independientes.
* **Principio Abierto/Cerrado (OCP):** El sistema permite integrar nuevos observadores (ej. notificaciones por SMS o WhatsApp) sin modificar la lógica principal de la clase `Reserva` o de `ServicioReservas`.
* **Principio de Inversión de Dependencias (DIP):** El `ServicioReservas` no depende de bases de datos concretas, sino de la interfaz `RepositorioReservas`. Asimismo, con el patrón Adapter, el sistema asegura depender de nuestro contrato estable `Videoconferencia` y no directamente de la herramienta externa `ProveedorZoom`.

## 4. Diagrama UML de Clases
El diseño visual de la arquitectura, incluyendo la integración del incremento 1 con los nuevos patrones, se encuentra en la carpeta de documentación:
![Diagrama de Clases Incremento 1](docs/uml-incremento1.png)[cite: 

## 5. Ejecución y Compilación
Para verificar que el código compila correctamente sin errores de sintaxis, ejecute el siguiente comando de Maven en la terminal:
```bash
mvn clean compile