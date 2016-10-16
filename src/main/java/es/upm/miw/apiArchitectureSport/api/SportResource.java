package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.controllers.SportController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportFieldException;

public class SportResource {
    
    // POST **/sport   body="sportName"
    public void createSport(String SportName) throws InvalidSportFieldException {
        this.validateField(SportName);
        //new SportController().createSport(SportName);
    }    

    private void validateField(String SportName) throws InvalidSportFieldException {
        if (SportName == null ||SportName.isEmpty()) {
            throw new InvalidSportFieldException("Deporte vacio");
        }else if(new SportController().findSportByName(SportName) != null){
            throw new InvalidSportFieldException("Deporte ya almacenado");
        }
    } 
}
