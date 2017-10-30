

package Servlets;

import Dao.ClientesDao;
import Dao.MensajeDao;
import Dao.UsuarioDao;
import Principal.Mensaje;
import Principal.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "MirarMensajesDentistaServelt", urlPatterns = {"/MirarMensajesDentistaServelt"})
public class MirarMensajesDentistaServelt extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MirarMensajesDentistaServelt</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MirarMensajesDentistaServelt at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       
        
      Usuario  usu= (Usuario)request.getSession().getAttribute("usuario");
      
      List<Mensaje> mensajes = new ArrayList<>();
      
      List<Usuario> usuarios = new ArrayList<>();
      
      mensajes= MensajeDao.getInstance().retrieveTotal();
      
      usuarios= UsuarioDao.getInstance().mirarClientes();
        
        
      
       if (mensajes != null){
              request.setAttribute("listaMensaje", mensajes);
       }
       if (usuarios != null){
              request.setAttribute("listaUsuario", usuarios);
       }
       
       
       
       RequestDispatcher rd= request.getRequestDispatcher("InicioDentista.jsp");
       
       rd.forward(request, response);  
      
        
        
        
        
    }

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

                
                
                
                
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
