/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import umariana.proyectoclinica.GestionarPaciente;
import umariana.proyectoclinica.Paciente;

/**
 *
 * @author daavv
 */
@WebServlet(name = "listarPacientes", urlPatterns = {"/listarPacientes"})
public class listarPacientes extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet listarPacientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listarPacientes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            gestionar.cargarPacientes();

            request.setAttribute("listaPacientes", gestionar.getMisPacientes());

            request.getRequestDispatcher("listadoPacientes.jsp").forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
