package fastock.fastock.Messages.Global;

import java.util.Date;

public class ErrorDetalles {
        private Date marcaDeTiempo;
        private String mensaje;
        private String detalles;

        public ErrorDetalles() {
        }

        public ErrorDetalles(Date marcaDeTiempo, String mensaje, String detalles) {
                this.marcaDeTiempo = marcaDeTiempo;
                this.mensaje = mensaje;
                this.detalles = detalles;
        }

        public Date getMarcaDeTiempo() {
                return marcaDeTiempo;
        }

        public void setMarcaDeTiempo(Date marcaDeTiempo) {
                this.marcaDeTiempo = marcaDeTiempo;
        }

        public String getMensaje() {
                return mensaje;
        }

        public void setMensaje(String mensaje) {
                this.mensaje = mensaje;
        }

        public String getDetalles() {
                return detalles;
        }

        public void setDetalles(String detalles) {
                this.detalles = detalles;
        }

}