package Controller;

import Helper.DB;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String dob = request.getParameter("date");
        
        HttpSession session = request.getSession();
        ResultSet result = null;
        try {
            result = DB.Insert(username,password,email,dob);
            
            while (result.next()){
                
               session.setAttribute("user",result.getString("username"));
               session.setAttribute("id",result.getInt("id"));
            }

            response.sendRedirect(request.getContextPath()+"/Views/Landing.jsp");
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
       
        }
  
    }

}
