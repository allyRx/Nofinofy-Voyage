package org.allyrx.dreamtravel.Controller;

import lombok.AllArgsConstructor;
import org.allyrx.dreamtravel.Entity.User;
import org.allyrx.dreamtravel.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    //Injection du service
    private final UserService userService;


    @PostMapping(consumes = APPLICATION_JSON_VALUE , produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> adduser(@RequestBody User user){

        try {
            userService.adduser(user);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("User added successfully");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Veuillez verifier cette erreur: "+e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "{id}" , consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestBody User userUpdate , @PathVariable Integer id){
        userService.updateUser(userUpdate, id);
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body("User updated successfully");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return  ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("User deleted successfully");
    }
}
