package fastock.fastock.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTime {

    public String obtenerFecha() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }

    public String soloFecha(){
        String formato = "yyyy-MM-dd";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }
}
