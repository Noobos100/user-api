package fr.univamu.iut.user;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.util.ArrayList;

public class UserService {

    /**
     * Objet permettant d'accéder au dépôt où sont stockées les informations sur les utilisateurs
     */
    protected UserRepositoryInterface userRepo ;

    /**
     * Constructeur permettant d'injecter l'accès aux données
     * @param userRepo objet implémentant l'interface d'accès aux données
     */

    public UserService( UserRepositoryInterface userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Méthode retournant les informations (sans mail et mot de passe) sur les utilisateurs au format JSON
     * @return une chaîne de caractère contenant les informations au format JSON
     */
    public String getAllUsersJSON(){

        ArrayList<User> allUsers = userRepo.getAllUsers();

        // on supprime les informations sur les mots de passe et les mails
//        for( User currentUser : allUsers ){
//            currentUser.setMail("");
//            currentUser.setPwd("");
//        }

        // création du json et conversion de la liste de users
        String result = null;
        try( Jsonb jsonb = JsonbBuilder.create()){
            result = jsonb.toJson(allUsers);
        }
        catch (Exception e){
            System.err.println( e.getMessage() );
        }

        return result;
    }

    /**
     * Méthode retournant au format JSON les informations sur un utilisateur recherché
     * @param id l'identifiant de l'utilisateur recherché
     * @return une chaîne de caractère contenant les informations au format JSON
     */
    public String getUserJSON( int id ){

            User user = userRepo.getUser(id);

            // on supprime les informations sur les mots de passe et les mails
            user.setMail("");
            user.setPwd("");

            // création du json et conversion de la liste de users
            String result = null;
            try( Jsonb jsonb = JsonbBuilder.create()){
                result = jsonb.toJson(user);
            }
            catch (Exception e){
                System.err.println( e.getMessage() );
            }

            return result;

    }
}
