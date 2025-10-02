public class Medico {
    private String nombre;
    private String especialidad;
    private String horarioAtencion;

    public Medico(String nombre, String especialidad, String horarioAtencion) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horarioAtencion = horarioAtencion;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getHorarioAtencion() { return horarioAtencion; }
}