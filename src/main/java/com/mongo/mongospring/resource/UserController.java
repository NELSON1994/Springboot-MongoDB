package com.mongo.mongospring.resource;

import com.mongo.mongospring.entity.DbSequence;
import com.mongo.mongospring.model.User;
import com.mongo.mongospring.repository.UserRepository;
import com.mongo.mongospring.service.SequenceGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SequenceGenerator sequenceGenerator;
    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user){
        user.setId(sequenceGenerator.getSequenceNumber(User.SEQUENCE_NAME));
        userRepository.save(user);
        //get seq

        return "User with id : "+user.getId() + " saved successfully";
    }
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/findUser/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return "Book deleted successfully";
    }

    @GetMapping("/findUsersByName/{name}")
    public List<User> getUsersByName(@PathVariable String name){
        return userRepository.findByFirstName(name);
    }

    @GetMapping("/findUserByCity/{city}")
    public List<User> getUsersByCity(@PathVariable String city){
        return userRepository.findByCity(city);
    }
}
