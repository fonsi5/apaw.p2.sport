package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.HashMap;

import es.upm.miw.apiArchitectureSport.daos.SportDao;
import es.upm.miw.apiArchitectureSport.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

    public SportDaoMemory() {
        this.setMap(new HashMap<Integer, Sport>());
    }

    @Override
    protected Integer getId(Sport entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Sport entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public Sport findSportByName(String sportName) {
        for (Sport sport : this.findAll()) {
            if (sport.getName().equals(sportName)) {
                return sport;
            }
        }
        return null;
    }

}
