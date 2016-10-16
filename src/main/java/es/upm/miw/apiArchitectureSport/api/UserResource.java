package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.controllers.SportController;
import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;

public class UserResource {

    // GET **/users
    public UserListWrapper userList() {
        return new UserController().UserList();
    }

    // POST **/users body="nick:email"
    public void createUser(String nick, String email) throws InvalidUserFieldException {
        this.validateNickEmail(nick, email);
        new UserController().createUser(nick, email);
    }

    private void validateNickEmail(String nick, String email) throws InvalidUserFieldException {
        if (nick == null || nick.isEmpty()) {
            throw new InvalidUserFieldException("Nick vacio");
        } else if (email == null || email.isEmpty()) {
            throw new InvalidUserFieldException("Email vacio");
        } else if (new UserController().findUserByNick(nick) != null) {
            throw new InvalidUserFieldException("Nick usado");
        }
    }

    public void addSportToUser(String nick, String sportName) throws InvalidUserFieldException {
        this.validateFieldNickSport(nick, sportName);                        
        new UserController().addSport(nick,sportName);        
    }    
 
    private void validateFieldNickSport(String nick, String sport) throws InvalidUserFieldException {
        if (nick == null || nick.isEmpty()) {
            throw new InvalidUserFieldException("Nick vacio");
        } else if (sport == null || sport.isEmpty()) {
            throw new InvalidUserFieldException("Deporte");
        } else if (new UserController().findUserByNick(nick) == null) {
            throw new InvalidUserFieldException("Usuario no encontrado");
        } else if (new SportController().findSportByName(sport) == null) {
            throw new InvalidUserFieldException("Deporte no encontrado");                
        }
    }    
    
    
}
