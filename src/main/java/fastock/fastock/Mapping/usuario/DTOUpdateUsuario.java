package fastock.fastock.Mapping.usuario;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fastock.fastock.Utils.EnumGenero;
import fastock.fastock.Utils.EnumTipoIdentificacion;

public class DTOUpdateUsuario {

  // -----------------------ID-----------------------//
  @NotNull(message = "El ID no debe estar vacío")
  private Integer id;
  // -----------------------Tipo Identificacion-----------------------//
  @NotEmpty(message = "El tipo de identificacion no debe estar vacío")
  @Size(min = 2, max = 30, message = "El tipo de identificacion debe tener entre 2 y 30 carcateres")
  private EnumTipoIdentificacion tipo;
  // -----------------------Idenficacion-----------------------//
  @NotNull(message = "La identificación no debe estar vacío")
  private Long identificacion;
  // -----------------------Nombre-----------------------//
  @NotEmpty(message = "El nombre no debe estar vacío")
  @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
  private String nombre;

  // -----------------------Apellido-----------------------//

  @NotEmpty(message = "El apellido no debe estar vacío")
  @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
  private String apellido;

  // -----------------------Genero-----------------------//
  @NotEmpty(message = "El género no debe estar vacío")
  @Size(min = 2, message = "El género no debe tener mínimo 2 caracteres")
  private EnumGenero genero;

  // -----------------------Fecha de nacimiento-----------------------//
  @NotEmpty(message = "La fecha de nacimiento no debe estar vacío")
  private String fecha;

  // -----------------------Direccion-----------------------//

  @NotEmpty(message = "La dirección no debe estar vacío")
  @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres")
  private String direccion;

  // -----------------------Telefono-----------------------//
  @NotNull(message = "El número teléfono no debe estar vacío")
  private Long telefono;

  // -----------------------Email-----------------------//

  @NotEmpty(message = "EL Email no debe estar vacío")
  @Email(message = "EL Email no valido")
  @Size(min = 4, max = 200, message = "La dirección debe tener entre 4 y 200 carcateres")
  private String email;

  // -----------------------imagen-----------------------//
  private String imagen;

  // -----------------------Estado-----------------------//
  @NotNull(message = "El estado no debe estar vacío")
  private Boolean estado;

  // -----------------------inicio-----------------------//
  @NotNull(message = "El inicio no debe estar vacío")
  private Boolean inicio;
  // ************************************************//
  // -------------Relacion con cargo-----------------//
  // ************************************************//
  @NotNull(message = "El cargo no debe estar vacío")
  private List<Integer> cargo;

  public DTOUpdateUsuario() {
  }

  public DTOUpdateUsuario(@NotNull(message = "El ID no debe estar vacío") Integer id,
      @NotEmpty(message = "El tipo de identificacion no debe estar vacío") @Size(min = 2, max = 30, message = "El tipo de identificacion debe tener entre 2 y 30 carcateres") EnumTipoIdentificacion tipo,
      @NotNull(message = "La identificación no debe estar vacío") Long identificacion,
      @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String nombre,
      @NotEmpty(message = "El apellido no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String apellido,
      @NotEmpty(message = "El género no debe estar vacío") @Size(min = 2, message = "El género no debe tener mínimo 2 caracteres") EnumGenero genero,
      @NotEmpty(message = "La fecha de nacimiento no debe estar vacío") String fecha,
      @NotEmpty(message = "La dirección no debe estar vacío") @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres") String direccion,
      @NotNull(message = "El número teléfono no debe estar vacío") Long telefono,
      @NotEmpty(message = "EL Email no debe estar vacío") @Email(message = "EL Email no valido") @Size(min = 4, max = 200, message = "La dirección debe tener entre 4 y 200 carcateres") String email,
      String imagen, @NotNull(message = "El estado no debe estar vacío") Boolean estado,
      @NotNull(message = "El inicio no debe estar vacío") Boolean inicio,
      @NotNull(message = "El cargo no debe estar vacío") List<Integer> cargo) {
    this.id = id;
    this.tipo = tipo;
    this.identificacion = identificacion;
    this.nombre = nombre;
    this.apellido = apellido;
    this.genero = genero;
    this.fecha = fecha;
    this.direccion = direccion;
    this.telefono = telefono;
    this.email = email;
    this.imagen = imagen;
    this.estado = estado;
    this.inicio = inicio;
    this.cargo = cargo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EnumTipoIdentificacion getTipo() {
    return tipo;
  }

  public void setTipo(EnumTipoIdentificacion tipo) {
    this.tipo = tipo;
  }

  public Long getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(Long identificacion) {
    this.identificacion = identificacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public EnumGenero getGenero() {
    return genero;
  }

  public void setGenero(EnumGenero genero) {
    this.genero = genero;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Long getTelefono() {
    return telefono;
  }

  public void setTelefono(Long telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public Boolean getInicio() {
    return inicio;
  }

  public void setInicio(Boolean inicio) {
    this.inicio = inicio;
  }

  public List<Integer> getCargo() {
    return cargo;
  }

  public void setCargo(List<Integer> cargo) {
    this.cargo = cargo;
  }

}