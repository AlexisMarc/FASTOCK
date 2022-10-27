package yeilux.com.proyecto.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTime {

    public String obtenerFecha() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }
}
