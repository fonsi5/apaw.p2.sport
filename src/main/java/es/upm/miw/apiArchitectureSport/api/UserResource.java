package es.upm.miw.apiArchitectureSport.api;

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

}
