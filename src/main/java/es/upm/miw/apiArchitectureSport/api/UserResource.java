package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserResource {

    // GET **/users
    public UserListWrapper userList() {
        UserWrapper uw = new UserWrapper(1, "pepe", "ppe@p.com");
        UserListWrapper usw = new UserListWrapper();
        usw.addUserWrapper(uw);

        return usw;
    }

    // POST **/users   body="nick:email"
    public void createUser(String nick,String email) throws InvalidUserFieldException {
        this.validateField(nick,email);
        //new UserController().createUser(nick,email);
    }    

    private void validateField(String nick, String email) throws InvalidUserFieldException {
        if (nick == null ||nick.isEmpty()) {
            throw new InvalidUserFieldException("Nick vacio");
        }else if(email == null ||email.isEmpty()){
            throw new InvalidUserFieldException("Email vacio");
        }elseif(new UserController().findUserByNick(nick) != null){
            throw new InvalidUserFieldException("Nick usado");
        }
    }    
    
}
