package org.allyrx.dreamtravel.Controller;

import lombok.AllArgsConstructor;
import org.allyrx.dreamtravel.Entity.User;
import org.allyrx.dreamtravel.Service.UserService;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public void adduser(@RequestBody User user){
        userService.adduser(user);
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
    public void updateUser(@RequestBody User userUpdate , @PathVariable Integer id){
        userService.updateUser(userUpdate, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }
}
