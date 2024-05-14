package kaya.knot.kayaKnot.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.user.entity.Users;
import kaya.knot.kayaKnot.user.entity.userDTO.UsersDTO;
import kaya.knot.kayaKnot.user.repo.UserTypeRepo;
import kaya.knot.kayaKnot.user.service.UserTypeService;
import kaya.knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRestController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private UserTypeRepo userTypeRepo;
    @Autowired
    private UserTypeService userTypeService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostMapping("create_new_user")
    public ResponseEntity<Map<String,Object>> createNewUser(@RequestBody UsersDTO usersDTO, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            Users users= new Users();
            users.setFirstName(usersDTO.getFirstName());
            users.setLastName(usersDTO.getLastName());
            users.setLandLord(usersDTO.isLandLord());
            users.setGender(usersDTO.getGender());
            users.setNidPassport(usersDTO.getNidPassport());
            users.setNationality(usersDTO.getNationality());
            users.setPhone(usersDTO.getPhone());
            users.setPassword( usersDTO.getPassword());
            users.setUserType(userTypeService.getUserTypeById(usersDTO.getUserType()));
            users.setEmail(usersDTO.getEmail());

            users.setProfilePicture("usersDTO.getPassword()");
            System.out.println("================"+usersDTO.getUserType());
            usersService.createNewUser(users);
            map.put("saved", users);
            map.put("saved", "users");
            map.put("message", "successful");

            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            // e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }

    }
}
