package kaya.knot.kayaKnot.policy.controller;

import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.policy.entity.PersonalPolicy;
import kaya.knot.kayaKnot.policy.entity.dto.PersonalPolicyDTO;
import kaya.knot.kayaKnot.policy.service.PersonalPolicyService;
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
public class PersonalPolicyController {
    @Autowired
    private PersonalPolicyService personalPolicyService;
    @Autowired
    private UsersService usersService;
    @PostMapping("create_new_personal_policy")
    public ResponseEntity<Map<String,Object>> createNewPersonalPolicy(@RequestBody PersonalPolicyDTO personalPolicyDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            PersonalPolicy personalPolicy= new PersonalPolicy();
            personalPolicy.setPersonalPolicy(personalPolicyDTO.getPersonalPolicy());
            System.out.println("userr=========="+personalPolicyDTO.getUserId());
            personalPolicy.setUserId(usersService.fetchUserById(personalPolicyDTO.getUserId()));

            personalPolicyService.createNewPersonalPolicy(personalPolicy);
            map.put("status","success");
            map.put("data",personalPolicy);
            map.put("message","personal policy created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }
}
