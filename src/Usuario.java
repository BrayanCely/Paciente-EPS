public class Usuario {
    private String nombreCompleto;
    private String fechaNacimiento;
    private String numeroIdentificacion;
    private String contrasena;
    private String barrio;
    private String telefono;
    private String email;

    public Usuario(String nombreCompleto, String fechaNacimiento, String numeroIdentificacion,
                   String contrasena, String barrio, String telefono, String email) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroIdentificacion = numeroIdentificacion;
        this.contrasena = contrasena;
        this.barrio = barrio;
        this.telefono = telefono;
        this.email = email;
    }


    public String getNombreCompleto() { return nombreCompleto; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public String getContrasena() { return contrasena; }
    public String getBarrio() { return barrio; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
}
