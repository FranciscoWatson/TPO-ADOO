package main.socio.estrategiaNotificacion;

import main.socio.Socio;

public interface EstrategiaNotificacion {
    void enviarNotificacion(String mensaje, Socio socio);
}
