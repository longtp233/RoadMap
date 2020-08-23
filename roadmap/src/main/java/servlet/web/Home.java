package servlet.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constance.Const;
import model.NewModel;
import service.INewService;
import service.impl.NewService;

@WebServlet(urlPatterns = {"/home"})

public class Home  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private INewService newService;
	    
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			newService=new NewService();
			NewModel model=new NewModel();
			model.setListResult(newService.takeAll());
			req.setAttribute(Const.MODEL, model); 
			RequestDispatcher rdDispatcher =req.getRequestDispatcher("views/web/home.jsp");
			rdDispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
