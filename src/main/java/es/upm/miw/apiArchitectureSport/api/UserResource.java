package es.upm.miw.apiArchitectureSport.api;

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
        this.validateField(nick, email);
        new UserController().createUser(nick, email);
    }

    private void validateField(String nick, String email) throws InvalidUserFieldException {
        if (nick == null || nick.isEmpty()) {
            throw new InvalidUserFieldException("Nick vacio");
        } else if (email == null || email.isEmpty()) {
            throw new InvalidUserFieldException("Email vacio");
        } else if (new UserController().findUserByNick(nick) != null) {
            throw new InvalidUserFieldException("Nick usado");
        }
    }

}
