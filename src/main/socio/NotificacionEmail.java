package main.socio;

public class NotificacionEmail implements EstrategiaNotificacion {
    @Override
    public void enviarNotificacion(String mensaje, Socio socio) {
        System.out.println("Se le envio una notificacion al socio al mail: " + socio.obtenerEmail());
    }
}
