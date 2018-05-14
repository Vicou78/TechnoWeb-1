package lab.mvc.controller;

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
import javax.servlet.http.HttpSession;

import lab.mvc.model.Maison;
@WebServlet("/recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_MESSAGES2 = "messages2";

    /*public Login() {
        super();Failed with error: unable to access 'https://github.com/Thoreuxyohan/TechnoWeb.git/': The requested URL returned error: 403
        // TODO Auto-generated constructor stub
    }*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 String num = request.getParameter("num");
		  session.setAttribute("id_choisi", num);
		 
		this.getServletContext().getRequestDispatcher("/page_maison.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		 HttpSession session = request.getSession();
		
        Maison maison = new Maison();

		String depart = request.getParameter("depart");
        String arrivee = request.getParameter("arrivee");
        String ville = request.getParameter("country");
        List<String> messages2 =maison.Correspond(request, depart,arrivee,ville);
        ArrayList<String> id_maison =(ArrayList<String>) maison.Cherche_id(request,ville);
        session.setAttribute("id_maison", id_maison);
        request.setAttribute( ATT_MESSAGES2, messages2 );
        System.out.println(id_maison);
        this.getServletContext().getRequestDispatcher("/results_maison.jsp" ).forward( request, response );
       
	}

}