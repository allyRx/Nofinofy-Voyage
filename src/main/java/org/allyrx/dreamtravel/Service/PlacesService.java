package org.allyrx.dreamtravel.Service;

import lombok.AllArgsConstructor;
import org.allyrx.dreamtravel.Entity.Places;
import org.allyrx.dreamtravel.Entity.User;
import org.allyrx.dreamtravel.Repository.PlacesRepository;
import org.allyrx.dreamtravel.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class PlacesService {

    private PlacesRepository placesRepository;
    private UserService userService;
    public void addPlaces(Places places) throws Exception {
         User userinfo = userService.FindPlaceWithEmail(places.getUser());
         places.setUser(userinfo);
        // places.setVisited(false);
         placesRepository.save(places);
    }

    public List<Places> displayPlaces(){
        return placesRepository.findAll();
    }

    public Optional<Places> getPlaceById(Long id){
        return  placesRepository.findById(id);
    }


    public ResponseEntity<String> updatePlace(Long id,Places place) throws Exception {
      Optional<Places> searchPlace = placesRepository.findById(id);

      if(searchPlace.isPresent()){
          Places newPlace = searchPlace.get(); //on recupere notre donnes existant pour remplacer celui du nouveau
          newPlace.setUser(place.getUser());
          newPlace.setName(place.getName());
          newPlace.setCity(place.getCity());
          newPlace.setCountry(place.getCountry());
          placesRepository.save(newPlace);
          return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
      }else throw new Exception("Il y a une Erreur");

    }


    public ResponseEntity<String> deletePlace(Long id){
        placesRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
    }


}
