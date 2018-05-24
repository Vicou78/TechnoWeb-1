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

@WebServlet("/Maison")
public class MesMaisons extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /*public Login() {
        super();Failed with error: unable to access 'https://github.com/Thoreuxyohan/TechnoWeb.git/': The requested URL returned error: 403
        // TODO Auto-generated constructor stub
    }*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}