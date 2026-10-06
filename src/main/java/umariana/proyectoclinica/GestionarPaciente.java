package umariana.proyectoclinica;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author daavv
 */
public class GestionarPaciente {

    ArrayList<Paciente> misPacientes = new ArrayList<>();

    private final File archivo;

    public GestionarPaciente(String rutaArchivo) {
        this.archivo = new File(rutaArchivo);
        try {
            System.out.println(rutaArchivo);
            cargarPacientes();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("-> Error: No se encontró el archivo. " + e.toString());
            } else if (e instanceof IOException) {
                System.out.println("-> Error: No se pudo leer el archivo. " + e.toString());
            } else {
                System.out.println(e.toString());
            }
        }

    }

    //Método para agregar paciente
    public void agregarPaciente(int idPaciente, String nombre, String apellido, String diagnostico) {
        try {
            Paciente miPaciente = new Paciente(idPaciente, nombre, apellido, diagnostico);
            misPacientes.add(miPaciente);
            guardarPacientes();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("-> Error: No se encontró el archivo. " + e.toString());
            } else if (e instanceof IOException) {
                System.out.println("-> Error: No se pudo leer el archivo. " + e.toString());
            } else {
                System.out.println(e.toString());
            }
        }
    }

    //Método para guardar datos de serialización
    public void guardarPacientes() throws FileNotFoundException, IOException, Exception {
        archivo.getParentFile().mkdirs();
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(misPacientes);
            System.out.println("-> Lista de pacientes guardada en: " + archivo.getAbsolutePath() + mostrarPacientes());
        }
    }

    //Método para cargar datos de serialización
    public void cargarPacientes() throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        if (!archivo.exists()) {
            System.out.println("-> Error: No se encontró el archivo.");
        }
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            misPacientes = (ArrayList<Paciente>) entrada.readObject();
            System.out.println("Comprobando existencia de pacientes en lista: " + mostrarPacientes() + "\n");
        }
    }

    //Método para comprobar pacientes
    public String mostrarPacientes() throws Exception {
        String lista = "";
        if (misPacientes.isEmpty()) {
            throw new Exception("Lista de pacientes vacía.");
        }
        for (Paciente p : misPacientes) {
            lista += "\n        - " + p.mostrarInfo();
        }
        return lista;
    }

    public boolean pacienteYaExiste(int idPaciente, String nombre, String apellido) {
        String nomAp1 = nombre + " " + apellido;
        for (Paciente p : misPacientes) {
            String nomAp2 = p.getNombre() + " " + p.getApellido();
            if (p.getIdPaciente() == idPaciente || nomAp2.equalsIgnoreCase(nomAp1)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Paciente> getMisPacientes() {
        return misPacientes;
    }
}
