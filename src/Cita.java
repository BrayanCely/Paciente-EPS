
// Definimos las caracteristicas de la cita asignada

public class Cita {
    private Usuario paciente;
    private Medico medico;
    private String fechaHora;
    private String motivo;

    public Cita(Usuario paciente, Medico medico, String fechaHora, String motivo) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    public Usuario getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public String getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }
}
