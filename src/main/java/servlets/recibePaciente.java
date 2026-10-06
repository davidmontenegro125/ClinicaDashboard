package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import umariana.proyectoclinica.GestionarPaciente;

/**
 *
 * @author daavv
 */
@WebServlet(name = "recibePaciente", urlPatterns = {"/recibePaciente"})
public class recibePaciente extends HttpServlet {

    GestionarPaciente gestionar;

    @Override
    public void init() throws ServletException {
        String rutaArchivo = getServletContext().getRealPath("") + "data" + File.separator + "pacientes.dat";
        gestionar = new GestionarPaciente(rutaArchivo);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet recibePaciente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet recibePaciente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(getServletInfo() + ", método doPost\n    -> Agregando nuevo paciente...");
        request.setCharacterEncoding("UTF-8");

        String idTxt = request.getParameter("idPaciente");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String diagnostico = request.getParameter("diagnostico");

        System.out.println("    DEBUG idPaciente = " + idTxt + " | nombre = " + nombre); // temporal

        try {
            int idPaciente = Integer.parseInt(idTxt.trim());
            boolean yaExiste = gestionar.pacienteYaExiste(idPaciente, nombre, apellido);
            if (yaExiste) {
                throw new Exception("Ya existe paciente con: " + idPaciente + " | " + nombre + " | " + apellido);
                
            } else {
                JOptionPane.showMessageDialog(null, "Paciente creado con éxito", "Registro", JOptionPane.INFORMATION_MESSAGE);
                gestionar.agregarPaciente(idPaciente, nombre, apellido, diagnostico);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("    -> Error:ID inválido: " + idTxt);
        }
        response.sendRedirect("registroPaciente.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet de 'recibePaciente' corriendo";
    }

}
