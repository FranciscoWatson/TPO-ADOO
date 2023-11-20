package main.socio.estrategiaNotificacion;

import main.socio.Socio;

public class NotificacionWhatsApp implements EstrategiaNotificacion {
    public void enviarNotificacion(String mensaje, Socio socio) {
        System.out.println("Se le envio una notificacion de WhatsApp al socio al telefono: " + socio.getTelefono() + " con el mensaje: " + mensaje);
    }
}
