package kaya.knot.kayaKnot.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.user.entity.UserType;
import kaya.knot.kayaKnot.user.entity.Users;
import kaya.knot.kayaKnot.user.entity.userDTO.UserTypeDTO;
import kaya.knot.kayaKnot.user.entity.userDTO.UsersDTO;
import kaya.knot.kayaKnot.user.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;

    @PostMapping("create_new_user_type")
    public ResponseEntity<Map<String,Object>> createNewUser(@RequestBody UserTypeDTO userTypeDTO, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            UserType userType= new UserType();
            userType.setUserType(userTypeDTO.getUserType());
            userTypeService.createNewUserType(userType);
            map.put("data", userType);
            map.put("status", "success");
            map.put("message", "user type created successful");

            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            map.put("status", "fail");
             e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
        }

    @RequestMapping(value = "/get_users_types", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getUserTypes(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
            try {
                List<UserType> userTypes=userTypeService.fetchUserTypes();
                map.put("message","user type fetched successful");
                map.put("userTypes",userTypes);
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            } catch (Exception e) {
                 e.printStackTrace();
                map.put("message", e);
                map.put("status", "fail");
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
            }

            }
}
