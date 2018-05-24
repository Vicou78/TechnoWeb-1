package lab.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.mvc.model.Authentication;
@WebServlet("/Inscrire")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String name = request.getParameter("name");
        String prenom = request.getParameter("prenom");
		String user = request.getParameter("username");
        String pass1 = request.getParameter("password1");
        String mail = request.getParameter("mail");
        String pass2 = request.getParameter("password2");
        HttpSession session = request.getSession();
        if(pass1.equals(pass2)) {
        	Authentication.Inscription(request,name,prenom,mail,user, pass1);
       	 session.setAttribute("session", "on");
        	List<String> infoUtilisateur = Authentication.infoUser(request, user,pass1);
        	System.out.println(infoUtilisateur);
        	request.setAttribute( "info_user", infoUtilisateur.get(0) );
        	session.setAttribute( "id_user", infoUtilisateur.get(1) );
        	getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
   
        }

        else {
        	/*plutot que de renvoyer vers une page error.jsp, autant rappeler index en indiquant une erreur de connexion*/
        	System.out.println("boucle2");
        	request.setAttribute("erreur", "Les informations de connexion ne sont pas correctes");
        	getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
	}
}
