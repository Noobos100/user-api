package fr.univamu.iut.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@ApplicationScoped
public class UserApplication extends Application {
    /**
     * Méthode appelée par l'API CDI pour injecter la connection à la base de données au moment de la création
     * de la ressource
     * @return un objet implémentant l'interface UserRepositoryInterface utilisée
     *          pour accéder aux données des users, voire les modifier
     */

    @Produces
    private UserRepositoryInterface openDbConnection(){
        UserRepositoryMariadb db = null;

        try{
            db = new UserRepositoryMariadb("jdbc:mariadb://mysql-cdaw.alwaysdata.net/cdaw_library_db", "cdaw_library", "vraimdp");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return db;
    }

    /**
     * Méthode permettant de fermer la connexion à la base de données lorsque l'application est arrêtée
     * @param userRepo la connexion à la base de données instanciée dans la méthode @openDbConnection
     */
    private void closeDbConnection(@Disposes UserRepositoryInterface userRepo ) {
        userRepo.close();
    }

}