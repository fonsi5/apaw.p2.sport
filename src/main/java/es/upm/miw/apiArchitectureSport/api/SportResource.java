package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidUserFieldException;

public class SportResource {
    
    // POST **/sport   body="sportName"
    public void createUser(String SportName) throws InvalidSportFieldException {
        this.validateField(SportName);
        //new SportController().createSport(SportName);
    }    

    private void validateField(String sPortName) throws InvalidSportFieldException {
        if (sPortName == null ||sPortName.isEmpty()) {
            throw new InvalidUserFieldException("Deporte vacio");
        }elseif(new SportController().findSportByName(sPortName) != null){
            throw new InvalidSportFieldException("Deporte ya almacenado");
        }
    } 
}
