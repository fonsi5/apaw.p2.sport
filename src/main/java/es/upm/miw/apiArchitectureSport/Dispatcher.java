package es.upm.miw.apiArchitectureSport;

import es.upm.miw.apiArchitectureSport.api.*;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportFieldException;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;
import es.upm.miw.web.http.HttpRequest;

public class Dispatcher {

    private UserResource userResource = new UserResource();

    private SportResource sportResource = new SportResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        // **/users
        if ("users".equals(request.getPath())) {
            response.setBody(userResource.userList().toString(false));    
        } else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])) {
            try {
                response.setBody(userResource.findUserBySport(request.getParams().get("sport")).toString(true));
            } catch (Exception e) {
                responseError(response, e);
            }
        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        // POST **/sports body="sportName"
        case "sports":
            String SportName = request.getBody();
            try {                
                sportResource.createSport(SportName);
                response.setStatus(HttpStatus.CREATED);
            } catch (InvalidSportFieldException e) {
                responseError(response, e);
            }
            break;
        // POST votes body="nick:email"
        case "users":
            String nick = request.getBody().split(":")[0];
            String email = request.getBody().split(":")[1];
            try {
                userResource.createUser(nick,email);
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                responseError(response, e);
            }
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        
        switch (request.paths()[0]) {

        case "users":
            if ("sport".equals(request.paths()[2])) {
                String sportName = request.getBody();
                String nick = request.paths()[1];
                try {
                    userResource.addSportToUser(nick, sportName);
                } catch (Exception e) {
                    responseError(response, e);
                }
            } else {
                responseError(response, new InvalidRequestException(request.getPath()));
            }
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

}
