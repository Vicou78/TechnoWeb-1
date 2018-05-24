package lab.mvc.model;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

public class Authentication implements Serializable{


	   private static List<String> messages = new ArrayList<String>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	/*
	 * CONNEXION A LA BASE DE DONNEES
	 * */
	
	  public static String url = "jdbc:mysql://localhost:3306/site";
	  public static String utilisateur = "root";
	  public static	 String motDePasse = "root";
	  public static Connection connexion2 = null;
	  public static Statement statement2 = null;
	  public static ResultSet resultat = null;

	  
	  
	  
	  
	  
	  
	  
	   public static boolean Authentic( HttpServletRequest request, String user,String pass) {
		    /* Chargement du driver JDBC pour MySQL */
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
	   public static boolean Inscription( HttpServletRequest request,String name,String prenom,String mail,String user,String pass1) {
		    /* Chargement du driver JDBC pour MySQL */
		    try {

		        Class.forName( "com.mysql.jdbc.Driver" );

		    } catch ( ClassNotFoundException e ) {
		                e.getMessage();
		    }


		    try {

		    	 connexion2 = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );

			        /* Création de l'objet gérant les requêtes */
			        statement2 = (Statement) connexion2.createStatement();

			        String req = " insert into utilisateur (nom,prenom,mail,username,password)"
			                + " values (?, ?, ?, ?, ?)";
			        PreparedStatement preparedStmt = (PreparedStatement) connexion2.prepareStatement(req);
			        preparedStmt.setString   (1, name);
			        preparedStmt.setString   (2, prenom);
			        preparedStmt.setString   (3, mail);
			        preparedStmt.setString   (4, user);
			        preparedStmt.setString   (5, pass1);

			        // execute the java preparedstatement
			        preparedStmt.executeUpdate();

		           
		        
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

		    return false;
		}
	
	   public static List<String> infoUser( HttpServletRequest request, String user,String pass) {
		    List<String> messagesInfo = new ArrayList<String>();
		    /* Chargement du driver JDBC pour MySQL */
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
		        resultat = statement2.executeQuery( "SELECT nom, prenom, idutilisateur FROM utilisateur where username ='"+user+"' and password ='"+pass+"';" );

		        while ( resultat.next() ) {
		        	String nomUtilisateur = resultat.getString( "nom" );
	                String prenomUtilisateur = resultat.getString( "prenom" );
	                String id_utilisateur = resultat.getString( "idutilisateur" );
	                messagesInfo.add(nomUtilisateur + " " +prenomUtilisateur);
	                messagesInfo.add(id_utilisateur);
		        			}
		           
		        
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
		    return messagesInfo;
		}
	   
	   
	   
}
