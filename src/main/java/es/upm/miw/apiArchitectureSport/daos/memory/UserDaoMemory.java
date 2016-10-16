package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.UserDao;
import es.upm.miw.apiArchitectureSport.entities.User;



public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);

	}

    @Override
    public List<User> findUsersBySportName(String sportPractice) {
        List<User> users = this.findAll();
        List<User> usersPracticeSport = new ArrayList<>();
        for (User user : users) {
            if (user.PracticeSport(sportPractice)) {
                usersPracticeSport.add(user);
            }
        }
        return usersPracticeSport;
    }

    @Override
    public User findUserByNick(String userNick) {
        List<User> users = this.findAll();
        for (User user : users) {
            if (user.getNick().equals(userNick)) {
                return user;
            }
        }
        return null;
    }

}