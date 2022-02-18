package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import enterNames.enterNames;
import model.SantaStuff;

/**
 * Servlet implementation class SantaServlet
 */
@WebServlet("/SantaServlet")
public class SantaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private enterNames enter = new enterNames();
	
    public SantaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		out.println("helloGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/secretsanta.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String names = request.getParameter("nameTxt");
		String emails = request.getParameter("emailTxt");
		String message = request.getParameter("msgTxt");
		
		SantaStuff obtainInfo = new SantaStuff();
		obtainInfo.setAllEmails(emails);
		obtainInfo.setAllNames(names);
		obtainInfo.setMessage(message);
		
		enter.doProcess(obtainInfo.getAllNames(), obtainInfo.getAllEmails(), obtainInfo.getMessage());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/secretsanta.jsp");
		dispatcher.forward(request, response);
		
	}

}
