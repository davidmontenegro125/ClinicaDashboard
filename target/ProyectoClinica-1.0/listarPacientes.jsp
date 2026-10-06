<%-- 
    Document   : listarPacientes
    Created on : 6/10/2026, 1:52:27 p. m.
    Author     : daavv
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="umariana.proyectoclinica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "header.jsp"%>

<%
    ArrayList<Paciente> lista = (ArrayList<Paciente>) request.getAttribute("listaPacientes");
%>
<div class ="container p-4">
    <div class ="row">
        <div class ="col-md-8">
            <div class ="card card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Diagnostico</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Paciente p : lista) {%>
                        <tr>
                            <td><%= p.getIdPaciente()%></td>
                            <td><%= p.getNombre()%></td>
                            <td><%= p.getApellido()%></td>
                            <td><%= p.getDiagnostico()%></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div><!-- card-body -->
        </div><!-- col-md-8 -->
    </div>
</div>

<%@include file = "footer.jsp"%>
