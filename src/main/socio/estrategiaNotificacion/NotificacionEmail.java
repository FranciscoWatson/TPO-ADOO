package main.socio.estrategiaNotificacion;

import main.socio.Socio;

public class NotificacionEmail implements EstrategiaNotificacion {
    @Override
    public void enviarNotificacion(String mensaje, Socio socio) {
        System.out.println("Se le envio una notificacion al socio al mail: " + socio.getEmail() + " con el mensaje: " + mensaje);
    }
}
