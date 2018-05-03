package lab.mvc.model;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Authentication implements Serializable{


	   private static List<String> messages = new ArrayList<String>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	   public static boolean Authentic( HttpServletRequest request, String user,String pass) {
		    /* Chargement du driver JDBC pour MySQL */
		    try {

		        Class.forName( "com.mysql.jdbc.Driver" );

		    } catch ( ClassNotFoundException e ) {
		                e.getMessage();
		    }

		    /* Connexion à la base de données */
		    String url = "jdbc:mysql://localhost:3306/site";
		 String utilisateur = "root";
			 String motDePasse = "jenk1000";
	    Connection connexion2 = null;
	    Statement statement2 = null;
	    ResultSet resultat = null;
		    try {

		        connexion2 = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );


		        /* Création de l'objet gérant les requêtes */
		        statement2 = (Statement) connexion2.createStatement();


		        /* Exécution d'une requête de lecture */
		        resultat = statement2.executeQuery( "SELECT username, password FROM utilisateur;" );

		        while ( resultat.next() ) {
		        	String username=resultat.getString("username");
		        	String password=resultat.getString("password");
		        /* Récupération des données du résultat de la requête de lecture */
		        	System.out.println( "user : " + username + ", pass = " + password);
		        	if( username.equals(user) && password.equals(pass)) {
		        		
		        			return true;}
		           
		        
		    }} catch ( SQLException e ) {
		      
		    } finally {

		        if ( resultat != null ) {
		            try {
		                resultat.close();
		            } catch ( SQLException ignore ) {
		            }
		        }

		        if ( statement2 != null ) {
		            try {
		                statement2.close();
		            } catch ( SQLException ignore ) {
		            }
		        }

		        if ( connexion2 != null ) {
		            try {
		                connexion2.close();
		            } catch ( SQLException ignore ) {
		            }
		        }
		    }

		    return false;
		}
	
	
}
