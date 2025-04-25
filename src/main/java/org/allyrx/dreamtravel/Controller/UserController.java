package org.allyrx.dreamtravel.Controller;

import org.allyrx.dreamtravel.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserController {


    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public void adduser(@RequestBody User user){}

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return List.of();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable Integer id){
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "{id}" , consumes = APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User userUpdate , @PathVariable Integer id){}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable Integer id){}
}
