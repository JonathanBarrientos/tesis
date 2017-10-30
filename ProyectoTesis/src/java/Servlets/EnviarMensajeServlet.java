/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.MensajeDao;
import Dao.TerminoDao;
import Principal.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "EnviarMensajeServlet", urlPatterns = {"/EnviarMensajeServlet"})
public class EnviarMensajeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
        }
    }

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Usuario  usu= (Usuario)request.getSession().getAttribute("usuario");
        
      String nombre = request.getParameter("nombre");
      String mensaje= request.getParameter("message");
      String dolor = request.getParameter("dolor");
      String tiempo = request.getParameter("tiempo");
      
      String termino= null ;
      
      termino = TerminoDao.getInstance().SacarTermino(mensaje, tiempo, dolor);
        
      MensajeDao.getInstance().CreateMensaje(usu.getNombre(), mensaje, termino);
        
     request.logout();
      response.sendRedirect("Login.jsp");
        
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
