package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("submit")
    public ResponseEntity<User> submitUser(@RequestBody UserDto userDto){
        return new ResponseEntity<User>(userService.submitUser(userDto), HttpStatus.CREATED);
    }
    @GetMapping("user")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>( userService.getUser(),HttpStatus.ACCEPTED);
    }

}
