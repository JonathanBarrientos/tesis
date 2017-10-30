/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.MensajeDao;
import Dao.UsuarioDao;
import Principal.Mensaje;
import Principal.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.print("Entrar aca");
        String codigo = request.getParameter("codigo");
        String password = request.getParameter("password");
      //  List<Mensaje> mensajes = new ArrayList<>();
    
            
        Usuario usu = UsuarioDao.getInstance().GetUsuario(codigo, password);
   //     mensajes= MensajeDao.getInstance().retrievePorUsuario(usu);
         
        
        
        
        if (usu == null) {
            // Login incorrect
            response.sendRedirect("Login.jsp");
            System.out.print("Login incorrecto");
        } else {
            // Login correcto
            request.getSession().setAttribute("usuario", usu);
            
            if (usu.getTipoUsuario().equals("paciente")) {
             //   request.setAttribute("listaMensaje", mensajes);
                response.sendRedirect("MirarMensajesPacienteServlet");
            } else if (usu.getTipoUsuario().equals("dentista")) {
                //MirarMensajesPacienteServlet
                response.sendRedirect("MirarMensajesDentistaServelt");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
