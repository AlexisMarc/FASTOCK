package fastock.fastock.Mapping.fabricacion;

public class DTOAdmin {

    // -----------------------ID-----------------------//
    private Integer id;
    // --------------------NOMBRE-----------------------//
    private String nombre;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DTOAdmin(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public DTOAdmin() {
    }

}
