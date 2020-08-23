package servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyleConstants.ColorConstants;

import org.apache.taglibs.standard.tag.common.xml.IfTag;

import com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel;

import constance.Const;

@WebServlet(urlPatterns = {"/admin"})
public class Admin extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String actString=req.getParameter("action");
		////if(actString!=null) {
			//if (actString.equals("login")) {
				RequestDispatcher rdDispatcher =req.getRequestDispatcher("views/admin/home.jsp");
				rdDispatcher.forward(req, resp);
			//}
			
//		}else {
//			RequestDispatcher rdDispatcher =req.getRequestDispatcher("views/admin/login.jsp");
//			rdDispatcher.forward(req, resp);
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
