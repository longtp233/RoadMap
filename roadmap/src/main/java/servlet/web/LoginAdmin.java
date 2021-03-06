package servlet.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import service.INewService;
import service.impl.UserService;
import utils.SessionUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UserService service;
	private UserModel userModel;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			response.getWriter().append("Served at: ").append(request.getContextPath());
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			service=new UserService();
			userModel= new UserModel();
			
			userModel=service.findUser(username, password); 
			
			if(userModel!=null) {
				response.sendRedirect(request.getContextPath()+"/admin");
				SessionUtil.getInstance().putValue(request, "USERMODEL",userModel);
			}else {
				System.out.println("null login");
				request.setAttribute("errorMessage", "username or password invalid !");
	            request.getRequestDispatcher("/views/login.jsp").forward(
	                    request, response);
			}
		}else 
			doGet(request, response);
	}

}
