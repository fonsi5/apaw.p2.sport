package es.upm.miw.apiArchitectureSport.daos.memory;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.daos.SportDao;
import es.upm.miw.apiArchitectureSport.daos.UserDao;

public class DaoFactoryMemory extends DaoFactory {

    private UserDao userDao;

    private SportDao sportDao;

    public DaoFactoryMemory() {
    }

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoMemory();
        }
        return userDao;
    }

    @Override
    public SportDao getSportDao() {
        if (sportDao == null) {
            sportDao = new SportDaoMemory();
        }
        return sportDao;
    }

}
