package es.upm.miw.apiArchitectureSport.controllers;

import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserController {

    public void createUser(String nick, String email) {
        //  DaoFactory.getFactory().getUserDao().create(new User(SportName));
      }        

    public UserListWrapper UserList(){
        UserWrapper uw = new UserWrapper(1, "pepe", "ppe@p.com");
        UserListWrapper usw = new UserListWrapper();
        usw.addUserWrapper(uw);
        return usw;
    }

    
    public UserWrapper findUserByNick(String nick){
        //UserWrapper uw = 
       return new UserWrapper(1, "pepe", "ppe@p.com");
    }
    
    
}
