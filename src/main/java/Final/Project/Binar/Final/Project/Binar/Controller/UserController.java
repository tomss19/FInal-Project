package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("submit")
    public ResponseEntity<User> submitUser(UserDto userDto, @RequestParam("img")MultipartFile file) throws IOException {
        userDto.setImg(file);
        userService.submitUser(userDto);
        return new ResponseEntity<User>(userService.submitUser(userDto), HttpStatus.CREATED);
    }
    @GetMapping("display")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>( userService.getUser(),HttpStatus.ACCEPTED);
    }
    @GetMapping("display/{userId}")
    public ResponseEntity<User> display_by_id_response(@PathVariable("userId") Long user_id){
       return new ResponseEntity<User>(userService.display_by_id(user_id), HttpStatus.ACCEPTED);
    }
    @PutMapping("update-user")
    public ResponseEntity<UserDto> update_response(@RequestBody UserDto userDto) throws IOException {
        if(userService.update_user(userDto))
        {
            return new ResponseEntity<UserDto>(userDto, HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity<UserDto>(userDto, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("delete-user/{userId}")
    public ResponseEntity<User> delete_response(@PathVariable ("userId") Long user_id)
    {
        User user = userService.display_by_id(user_id);
        if(userService.delete_user(user_id))
        {
            return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
        }
    }

}
