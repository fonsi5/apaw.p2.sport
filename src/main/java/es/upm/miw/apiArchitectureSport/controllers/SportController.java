package es.upm.miw.apiArchitectureSport.controllers;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.wrappers.SportWrapper;

public class SportController {

    public void createSport(String SportName) {
        DaoFactory.getFactory().getSportDao().create(new Sport(SportName));
    }

    public SportWrapper findSportByName(String SportName) {
        Sport sport = DaoFactory.getFactory().getSportDao().findSportByName(SportName);
        if (sport != null) {
            return new SportWrapper(sport.getId(), sport.getName());
        } else {
            return null;
        }
    }
}
