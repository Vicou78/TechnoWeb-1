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

@WebServlet("/Connexion")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /*public Login() {
        super();Failed with error: unable to access 'https://github.com/Thoreuxyohan/TechnoWeb.git/': The requested URL returned error: 403
        // TODO Auto-generated constructor stub
    }*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String user = request.getParameter("username");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
        boolean reserv=Authentication.Authentic(request, user,pass);
        if(reserv) {
        	System.out.println("boucle");
        	getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        	 session.setAttribute("session", "on");
        }
        else {
        	/*plutot que de renvoyer vers une page error.jsp, autant rappeler index en indiquant une erreur de connexion*/
        	System.out.println("boucle2");
        	request.setAttribute("erreur", "Les informations de connexion ne sont pas correctes");
        	getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
	}

}