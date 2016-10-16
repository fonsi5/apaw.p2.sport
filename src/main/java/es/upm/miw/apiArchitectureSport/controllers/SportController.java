package es.upm.miw.apiArchitectureSport.controllers;

import es.upm.miw.apiArchitectureSport.wrappers.SportWrapper;

public class SportController {
    
    public void createTheme(String SportName) {
      //  DaoFactory.getFactory().getSportDao().create(new Sport(SportName));
    }    

    public SportWrapper findSportByName(String SportName){
        //UserWrapper uw = 
       return new SportWrapper(1, "tenis");
    }    
    
    
}
