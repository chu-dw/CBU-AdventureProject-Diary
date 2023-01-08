package diary_project.backend.user.controller;

import diary_project.backend.user.dto.UserRequest;
import diary_project.backend.user.dto.UserResponse;
import diary_project.backend.user.entity.User;
import diary_project.backend.user.repository.UserRepository;
import diary_project.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/new")
    public User create(@RequestBody UserRequest request){
        return userRepository.save(request.getUser());
    }

    @GetMapping("/users/info")
    public List<Object[]> getInfo(){
        return  userRepository.getList();
    }

    @PostMapping("/users/login")
    public Optional<User> login(@RequestBody UserRequest request){
        return userService.SignIn(request.getUser());
    }

    @GetMapping("/users/logout")
    public String logout(@RequestBody UserResponse response){
        userService.logout(response.getEmail());
        return "logout";
    }
}
