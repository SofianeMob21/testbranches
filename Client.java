package javaMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Client {
    public static void AjouterClient(String prenom, String motdepasse, String email, int nbfilmvus) {
        {

            String BDD = "netflix";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            // L'essaie de connexion à votre base de donées
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connecter");
                // Déclaration de la connexion avec la base de donnée
                Statement state = conn.createStatement();
                //L'objet ResultSet contient le résultat de la requête SQL
                String sql = "INSERT INTO client (`id`, `Prénom`, `MotDePasse`, `AdresseMail`, `NbFilmVus`) VALUES (NULL, '"+prenom+"', '"+motdepasse+"', '"+email+"', '"+nbfilmvus+"')";
                state.executeUpdate(sql);

// On ferme tout les connexion à la base de données
                state.close();
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Erreur");
                System.exit(0);
            }

        }
    }

}
