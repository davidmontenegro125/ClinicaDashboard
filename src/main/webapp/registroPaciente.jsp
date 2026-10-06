<%-- 
    Document   : index
    Created on : 22/09/2026, 4:35:05 p. m.
    Author     : daavv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "header.jsp"%>

<div class ="container p-4">
    <div class ="row">
        <div class ="col-md-4">
            <div class ="card card-body">
                <form action = "recibePaciente" method = "post">
                    <div class = "form-group">
                        <input type = "text" name = "idPaciente" class = "form-control" placeholder = "Ingrese el id del paciente" autofocus required><!-- Input id paciente -->
                    </div><!-- form-group -->
                    <br><!-- salto de línea -->
                    <div class = "form-group">
                        <input type = "text" name = "nombre" class = "form-control" placeholder = "Ingrese el nombre del paciente" required><!-- Input nombre paciente -->
                    </div><!-- form-group -->
                    <br><!-- salto de línea -->
                    <div class = "form-group">
                        <input type = "text" name = "apellido" class = "form-control" placeholder = "Ingrese el apellido del paciente" required><!-- Input apellido paciente -->
                    </div><!-- form-group -->
                    <br><!-- salto de línea -->
                    <div class = "form-group">
                        <textarea class = "form-control" name = "diagnostico" rows = "3" placeholder = "Diagnóstico"></textarea>
                    </div><!-- form-group -->
                    <br><!-- salto de línea -->
                    <input type = "submit" class = "btn btn-success btn-block" name = "guardar" value = "Guardar"><!-- Boton de guardado -->
                    <a class="btn btn-disabled btn-block" href="index.html" name="cancelar" value="Cancelar">Cancelar</a><!<!-- Boton de listado -->
                </form>
            </div><!-- card-body -->
        </div><!-- col-md-4 -->
    </div>
</div>

<%@include file = "footer.jsp"%>