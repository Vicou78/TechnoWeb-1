package lab.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.mvc.model.Authentication;
import lab.mvc.model.Authentication;
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id_user = session.getAttribute("id_user").toString();
		List<String> infoProfil = Authentication.infoprofil(request, id_user);
		request.setAttribute( "Nom_User", infoProfil.get(0) );
		request.setAttribute( "Prenom_User", infoProfil.get(1) );
		request.setAttribute( "mail", infoProfil.get(2) );
		request.setAttribute( "Username", infoProfil.get(3) );
		request.setAttribute( "Password", infoProfil.get(4) );
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/profil.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		HttpSession session = request.getSession();
		String id_user = session.getAttribute("id_user").toString();
		String nom_user_modif = request.getParameter("nom_user_modif");
		String prenom_user_modif = request.getParameter("prenom_user_modif");
		String mail_modif = request.getParameter("mail_modif");
		String username_modif = request.getParameter("username_modif");
		String password_modif = request.getParameter("password_modif");
		System.out.println(id_user);
		System.out.println(nom_user_modif);
		System.out.println(prenom_user_modif);
		System.out.println(mail_modif);
		System.out.println(username_modif);
		Authentication.Modifprofil(request, id_user,nom_user_modif,prenom_user_modif,mail_modif,username_modif,password_modif);
		request.setAttribute( "Nom_User", nom_user_modif );
		request.setAttribute( "Prenom_User", prenom_user_modif );
		request.setAttribute( "mail", mail_modif );
		request.setAttribute( "Username", username_modif );
		request.setAttribute( "Password", password_modif );
		this.getServletContext().getRequestDispatcher("/profil.jsp" ).forward( request, response );
	}
}