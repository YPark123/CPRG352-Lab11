package servlets;

import dataaccess.UserDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.AccountService;

public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uuid = request.getParameter("uuid");
        
        if(uuid != null){
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String action = request.getParameter("action");
        AccountService as = new AccountService();
        
        if(action.equals("submitreset")){
            String email = request.getParameter("email");
            
            String path = getServletContext().getRealPath("/WEB-INF");
            String url = request.getRequestURL().toString();
            
            if(email.equals("")){
                request.setAttribute("message", "null");
            }
            
            else{
                as.resetPassword(email, path, url);
                request.setAttribute("message", "success");
            }

            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        }
        
        if(action.equals("resetpassword")){
            String uuid = request.getParameter("uuid");
            String password = request.getParameter("password");

            boolean isSucceed = as.changePassword(uuid, password);
            
            if(isSucceed){
                request.setAttribute("message", "success");   
            }  
            else{
                request.setAttribute("message", "error");   
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
        }


    }
}
