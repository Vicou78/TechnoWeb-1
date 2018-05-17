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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	/*
	 * CONNEXION A LA BASE DE DONNEES
	 * */
	
	  public static String url = "jdbc:mysql://localhost:3306/site";
	  public static String utilisateur = "root";
	  public static	 String motDePasse = "tanguy";
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
	public List<String> Correspond(HttpServletRequest request, String depart,String arrivee,String ville) {
		// TODO Auto-generated method stub
		 ArrayList<String> messages2 = new ArrayList<String>();
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
	        	String description=resultat.getString("description");
	        	
	        messages2.add("Une maison est disponible dans la ville "+ville+", son nom est "+nom_maison+" et voici sa description :"+description);}
	           
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
	public List<String> Cherche_id(HttpServletRequest request, String ville) {
		// TODO Auto-generated method stub
		 ArrayList<String> id_maison = new ArrayList<String>();
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
		        resultat = statement2.executeQuery( "SELECT idmaison FROM maison WHERE ville='"+ville+"';" );
		        
		        while ( resultat.next() ) {
		        
		        	String id=resultat.getString("idmaison");
		        	
		        id_maison.add(id);}
		           
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

			return id_maison;
	}
	public List<String> recupInfos(HttpServletRequest request, String num) {
		// TODO Auto-generated method stub
		 ArrayList<String> info_maison = new ArrayList<String>();
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
		        resultat = statement2.executeQuery( "SELECT id_utilisateur, nom_maison, description, img_maison FROM maison WHERE idmaison='"+num+"';" );
		        
		        while ( resultat.next() ) {
		        	String id_utilisateur=resultat.getString("id_utilisateur");
		        	String nom_maison=resultat.getString("nom_maison");
		        	String description=resultat.getString("description");
		        	String img_maison=resultat.getString("img_maison");
		        info_maison.add(img_maison);
		        info_maison.add(id_utilisateur);
		        info_maison.add(nom_maison);
		        info_maison.add(description);
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

			return info_maison;
	}
}
