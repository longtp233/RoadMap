package servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
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

/**
 * Servlet implementation class Create
 */
@WebServlet(urlPatterns = {"/admin-list"})
public class ListAndEdit extends HttpServlet { 
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -372995911599156359L; 

    public ListAndEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    private INewService newService;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aString=request.getParameter("type");
		String id=request.getParameter("id");     // als 
	    newService=new NewService();
		NewModel model=new NewModel();
		
		String view = "";
		if(aString!=null) {
			if(aString.equals("edit")) {
				view="views/admin/edit.jsp";
				Long idTemp= Long.parseLong(id); 
				model = newService.findOne(idTemp); 
			//	request.setAttribute("categories", categoryService.findAll()); 
				request.setAttribute(Const.MODEL,model );
				
			}else if(aString.equals("new")) {
				view="views/admin/edit.jsp";
				
			}else if (aString.equals("delete")) {
				Long idTemp= Long.parseLong(id); 
				newService.delete(idTemp); 
				model.setListResult(newService.takeAll());
				request.setAttribute(Const.MODEL, model); 
				view="views/admin/list.jsp";
			}
		
		}else {
			model.setListResult(newService.takeAll());
			request.setAttribute(Const.MODEL, model); 
			view="views/admin/list.jsp";
		}
		
		RequestDispatcher rdDispatcher =request.getRequestDispatcher(view);
		rdDispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
