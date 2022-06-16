package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User submitUser(UserDto userDto) throws IOException {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAlamat(userDto.getAlamat());
        user.setNotelepon(userDto.getNotelepon());
        user.setImg(userDto.getImg().getBytes());
        userRepository.save(user);

        return user;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User display_by_id(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public Boolean update_user(UserDto userDto) throws IOException {
        if (userRepository.existsById(userDto.getUserId())) {
            User user = new User();
            user.setUserId(userDto.getUserId());
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setAlamat(userDto.getAlamat());
            user.setNotelepon(userDto.getNotelepon());
            user.setImg(userDto.getImg().getBytes());

            userRepository.save(user);
            return true;
        } else {
            return false;
        }

    }
    public Boolean delete_user(Long userId)
    {
        if(userRepository.existsById(userId))
        {
            userRepository.deleteById(userId);
            return true;
        }
        else
        {
            return false;
        }
    }
}
