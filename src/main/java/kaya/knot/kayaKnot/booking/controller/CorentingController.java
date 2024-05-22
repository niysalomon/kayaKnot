package kaya.knot.kayaKnot.booking.controller;

import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.booking.entity.Corenting;
import kaya.knot.kayaKnot.booking.entity.impl.UserHouseJoinDTO;
import kaya.knot.kayaKnot.booking.service.HouseStatusService;
import kaya.knot.kayaKnot.booking.service.CorentingService;
import kaya.knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CorentingController {
    @Autowired
    private CorentingService corentingService;
    @Autowired
    private HouseStatusService houseStatusService;
    @Autowired
    private UsersService usersService;
    @PostMapping("create_corenting")
    public ResponseEntity<Map<String,Object>> createNewHouseType(@RequestBody UserHouseJoinDTO userHouseJoinDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            Corenting corenting = new Corenting();
            corenting.setHouseStatusId(houseStatusService.fetchHouseStatusById(userHouseJoinDTO.getHouseStatusId()));
            corenting.setRenterId(usersService.fetchUserById(userHouseJoinDTO.getRenterId()));
            corenting.setRenterComment(userHouseJoinDTO.getRenterComment());
            corenting.setActive(true);
            corenting.setRenterStatus("READY");
            corentingService.createNewCorenting(corenting);

            map.put("status","success");
            map.put("data", corenting);
            map.put("message","added in co-renting list");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

        @GetMapping("fetch_corenting_by_house/{house_id}")
    public ResponseEntity<Map<String,Object>> getHouseTypeById(@PathVariable("house_id") String house_id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<Corenting> corenting=corentingService.fetchCorentingByHouse(house_id);
            map.put("status","success");
            map.put("data",corenting);
            map.put("message","corenting fetched successful");
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
