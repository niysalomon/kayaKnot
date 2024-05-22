package kaya.knot.kayaKnot.booking.controller;

import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.booking.entity.HouseStatus;
import kaya.knot.kayaKnot.booking.entity.impl.HouseStatusDTO;
import kaya.knot.kayaKnot.booking.service.HouseStatusService;
import kaya.knot.kayaKnot.house.entity.House;
import kaya.knot.kayaKnot.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HouseStatusController {
    @Autowired
    private HouseStatusService houseStatusService;
    @Autowired
    private HouseService houseService;
    @PostMapping("create_new_house_status")
    public ResponseEntity<Map<String,Object>> createNewHouseType(@RequestBody HouseStatusDTO houseStatusDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseStatus houseStatus=new HouseStatus();

            houseStatus.setCurrency(houseStatusDTO.getCurrency());
            houseStatus.setLandLordConfirmation("AVAILABLE");
            houseStatus.setBookingStatus("NOT BOOKED");
            houseStatus.setLandLordConfirmation("PENDING");
            houseStatus.setPrice(houseStatusDTO.getPrice());
            houseStatus.setActive(true);
            houseStatus.setHouseId(houseService.fetchHouseById(houseStatusDTO.getHouseId()));
            houseStatusService.createNewHouseStatus(houseStatus);
            map.put("status","success");
            map.put("data",houseStatus);
            map.put("message","house status created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

//    @PostMapping("fetch_houseStatus_by_house/{id}")
//    public ResponseEntity<Map<String,Object>> getHouseTypeById(@PathVariable("id") String id, HttpServletRequest request){
//        Map<String,Object> map=new HashMap<>();
//        try {
//            HouseStatus houseStatus=houseStatusService.
//            map.put("status","success");
//            map.put("data",house);
//            map.put("message","house fetched successful");
//            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
//
//        }
//        catch (Exception e){
//            map.put("status", "fail");
//            map.put("message", e);
//            e.printStackTrace();
//            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
//
//        }
//    }

}
