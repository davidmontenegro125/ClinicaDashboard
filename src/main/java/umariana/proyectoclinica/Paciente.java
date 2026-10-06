package umariana.proyectoclinica;

import java.io.Serializable;

/**
 *
 * @author daavv
 */
public class Paciente implements Serializable{

    private int idPaciente;
    private String nombre;
    private String apellido;
    private String diagnostico;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nombre, String apellido, String diagnostico) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.diagnostico = diagnostico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String mostrarInfo() {
        return idPaciente + " | " + nombre + " | " + apellido + " | " + diagnostico;
    }
}
