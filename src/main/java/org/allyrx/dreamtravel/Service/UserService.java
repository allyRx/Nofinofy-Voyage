package org.allyrx.dreamtravel.Service;

import lombok.AllArgsConstructor;
import org.allyrx.dreamtravel.Entity.Places;
import org.allyrx.dreamtravel.Entity.User;
import org.allyrx.dreamtravel.Enum.EnumUser;
import org.allyrx.dreamtravel.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Service @AllArgsConstructor
public class UserService {

    //Injection d'user repository
    private UserRepository userRepository;

    public void adduser(User user){
        user.setRole(EnumUser.USER);  //mettre user pardefaut
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(Long.valueOf(id));
    }

    public void updateUser(User userUpdate , Integer id){
            Optional<User> searchUser = userRepository.findById(Long.valueOf(id)); //verifions si l'user existe

            if (searchUser.isPresent()){
                User NewUser = searchUser.get(); //s'il est present donc on get

                NewUser.setEmail(userUpdate.getEmail());
                NewUser.setUsername(userUpdate.getUsername());
                NewUser.setPassword(userUpdate.getPassword());
                NewUser.setRole(NewUser.getRole()); //on ne change pas le role donc on recupere celui du NewUser


                userRepository.save(NewUser);
            }else throw new RuntimeException("Utilisateur avec ID " + id + " non trouvé.");
    }

    public void deleteUserById(@PathVariable Integer id){
        userRepository.deleteById(Long.valueOf(id));
    }

    public User FindPlaceWithEmail(User user) throws Exception {
        User userFound = userRepository.findByEmail(user.getEmail());
        if(userFound == null){
            throw new Exception("User not found");
        }
        return userFound;
    }
}
