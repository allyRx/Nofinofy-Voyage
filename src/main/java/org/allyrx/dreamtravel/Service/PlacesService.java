package org.allyrx.dreamtravel.Service;

import lombok.AllArgsConstructor;
import org.allyrx.dreamtravel.Entity.Places;
import org.allyrx.dreamtravel.Entity.User;
import org.allyrx.dreamtravel.Repository.PlacesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class PlacesService {

    private PlacesRepository placesRepository;
    private UserService userService;
    public void addPlaces(Places places){
         User userinfo = userService.createOrGetPlace(places.getUser());
         places.setUser(userinfo);
         places.setVisited(false);
         placesRepository.save(places);
    }

    public List<Places> displayPlaces(){
        return List.of();
    }

    public Optional<Places> getPlaceById(String id){
        return Optional.empty();
    }


    public ResponseEntity<String> updatePlace(String id,Places place){
        return null;
    }


    public ResponseEntity<String> deletePlace(String id){
        return null;
    }


}
