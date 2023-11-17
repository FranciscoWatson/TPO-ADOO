public class NotificacionSMS implements EstrategiaNotificacion{
    public void enviarNotificacion(String mensaje, Socio socio) {
        System.out.println("Se le envio una notificacion sms al socio al telefono: " + socio.obtenerTelefono());
    }
}
