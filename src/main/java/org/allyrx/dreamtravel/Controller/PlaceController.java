package org.allyrx.dreamtravel.Controller;

import lombok.AllArgsConstructor;
import org.allyrx.dreamtravel.Entity.Places;
import org.allyrx.dreamtravel.Entity.User;
import org.allyrx.dreamtravel.Service.PlacesService;
import org.allyrx.dreamtravel.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/places") @AllArgsConstructor
public class PlaceController {
    private PlacesService placesService;
    private UserService userService;
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPlaces(@RequestBody Places places){
       try{
           User existingUser = userService.FindPlaceWithEmail(places.getUser());
           places.setUser(existingUser);
           if (existingUser == null) {
                throw new Exception("User not found");
           }
           placesService.addPlaces(places);
           return ResponseEntity
                   .status(HttpStatus.CREATED)
           .body("Places added successfully");
       }catch (Exception e){
           return  ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
       }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Places> displayPlaces(){
        return placesService.displayPlaces();
    }

    @GetMapping(path = "{id}")
    public Optional<Places> getPlaceById(@PathVariable String id){
        return Optional.empty();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> updatePlace(@PathVariable String id, @RequestBody Places place){
        return null;
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deletePlace(@PathVariable String id){
        return null;
    }
}
