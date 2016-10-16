package es.upm.miw.apiArchitectureSport.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserController {

    public void createUser(String nick, String email) {
        User user = new User(nick, email);
        DaoFactory.getFactory().getUserDao().create(user);
    }

    public UserListWrapper UserList() {

        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper usw = new UserListWrapper();

        for (User user : userList) {
            usw.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail()));
        }
        return usw;
    }

    public UserWrapper findUserByNick(String nick) {
        User userWithNick = DaoFactory.getFactory().getUserDao().findUserByNick(nick);
        if (userWithNick != null) {
            return new UserWrapper(userWithNick.getId(), userWithNick.getNick(), userWithNick.getEmail());
        } else {
            return null;
        }
    }

    public void addSport(String nick, String sportName) {
        User user = DaoFactory.getFactory().getUserDao().findUserByNick(nick);
        if (!user.PracticeSport(nick)) {
            user.addSport(DaoFactory.getFactory().getSportDao().findSportByName(sportName));
        }
    }

    public UserListWrapper findUserBySport(String sportName) {
        List<User> userList = DaoFactory.getFactory().getUserDao().findUsersBySportName(sportName);
        UserListWrapper userNickListWrapper = new UserListWrapper();
        for (User user : userList) {
            userNickListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail()));
        }
        return userNickListWrapper;
    }

}
