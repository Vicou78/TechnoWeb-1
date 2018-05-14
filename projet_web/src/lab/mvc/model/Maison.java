package lab.mvc.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Maison {
	   public static ArrayList<String> messages = new ArrayList<String>();
	   public static ArrayList<String> messages2 = new ArrayList<String>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	/*
	 * CONNEXION A LA BASE DE DONNEES
	 * */
	
	  public static String url = "jdbc:mysql://localhost:3306/site";
	  public static String utilisateur = "root";
	  public static	 String motDePasse = "jenk1000";
	  public static Connection connexion2 = null;
	  public static Statement statement2 = null;
	  public static ResultSet resultat = null;

	public static ArrayList<String> get_villes() {
		// TODO Auto-generated method stub
		try {

	        Class.forName( "com.mysql.jdbc.Driver" );

	    } catch ( ClassNotFoundException e ) {
	                e.getMessage();
	    }


	    try {

	        connexion2 = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );


	        /* Création de l'objet gérant les requêtes */
	        statement2 = (Statement) connexion2.createStatement();


	        /* Exécution d'une requête de lecture */
	        resultat = statement2.executeQuery( "SELECT ville FROM maison;" );

	        while ( resultat.next() ) {
	        	String maison=resultat.getString("ville");
	        	if(!messages.contains(maison)) {
	        messages.add(maison);}
	           
	        
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

		return messages;
	}
	public static List<String> Correspond(HttpServletRequest request, String depart,String arrivee,String ville) {
		// TODO Auto-generated method stub
		try {

	        Class.forName( "com.mysql.jdbc.Driver" );

	    } catch ( ClassNotFoundException e ) {
	                e.getMessage();
	    }


	    try {

	        connexion2 = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );


	        /* Création de l'objet gérant les requêtes */
	        statement2 = (Statement) connexion2.createStatement();


	        /* Exécution d'une requête de lecture */
	        resultat = statement2.executeQuery( "SELECT nom_maison, description FROM maison WHERE ville='"+ville+"';" );
	        
	        while ( resultat.next() ) {
	        
	        	String nom_maison=resultat.getString("nom_maison");
	        	String description=resultat.getString("descrption");
	        	
	        messages2.add("Une maison est disponible dans la ville "+ville+", son nom est"+nom_maison+"et voici sa desciption :"+description);}
	           
	        messages2.add("Une maison est disponible dans la ville ");
	        } catch ( SQLException e ) {
	      
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

		return messages2;
	}
}
