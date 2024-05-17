package kaya.knot.kayaKnot.policy.controller;

import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.policy.entity.CancellationPolicy;
import kaya.knot.kayaKnot.policy.entity.SystemBookingPolicy;
import kaya.knot.kayaKnot.policy.entity.dto.SystemBookingPolicyDTO;
import kaya.knot.kayaKnot.policy.repo.SystemBookingPolicyRepo;
import kaya.knot.kayaKnot.policy.service.SystemBookingPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemBookingPolicyController {
   @Autowired
   private SystemBookingPolicyService systemBookingPolicyService;
    @PostMapping("create_bookingPolicy")
    public ResponseEntity<Map<String,Object>> createNewSystemBookingPolicy(@RequestBody SystemBookingPolicyDTO systemBookingPolicyDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            SystemBookingPolicy systemBookingPolicy = new SystemBookingPolicy();
            systemBookingPolicy.setBookingPolicy(systemBookingPolicyDTO.getBookingPolicy());
            systemBookingPolicyService.createNewSystemPolicy(systemBookingPolicy);
            map.put("status","success");
            map.put("message","system policy created successful");
            map.put("data",systemBookingPolicy);

        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

    }
        catch (Exception e){
        map.put("status", "fail");
        map.put("message", e);
        e.printStackTrace();
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

    }
    }
    @PostMapping("update_bookingPolicy")
    public ResponseEntity<Map<String,Object>> updateSystemBookingPolicy(@RequestBody SystemBookingPolicyDTO systemBookingPolicyDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            SystemBookingPolicy systemBookingPolicy = new SystemBookingPolicy();
            systemBookingPolicy.setBookingPolicy(systemBookingPolicyDTO.getBookingPolicy());
            systemBookingPolicyService.updateSystemPolicy(systemBookingPolicy);
            map.put("status","success");
            map.put("message","system policy updated successful");
            map.put("data",systemBookingPolicy);
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @RequestMapping(value = "/get_system_policy", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getUsers(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<SystemBookingPolicy> systemBookingPolicies=systemBookingPolicyService.fetchAllSystemPolicies();
            map.put("message","system policies fetched successful");
            map.put("data",systemBookingPolicies);
            map.put("status", "success");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", e);
            map.put("status", "fail");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }

}
