package kaya.knot.kayaKnot.booking.controller;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.booking.entity.Corenting;
import kaya.knot.kayaKnot.booking.entity.dto.CorentingDetailsDTO;
import kaya.knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO;
import kaya.knot.kayaKnot.booking.entity.dto.UserHouseJoinDTO;
import kaya.knot.kayaKnot.booking.service.HouseStatusService;
import kaya.knot.kayaKnot.booking.service.CorentingService;
import kaya.knot.kayaKnot.house.entity.HousePhoto;
import kaya.knot.kayaKnot.house.service.HousePhotoService;
import kaya.knot.kayaKnot.house.service.HouseService;
import kaya.knot.kayaKnot.payload.response.RequestResponse;
import kaya.knot.kayaKnot.user.entity.Users;
import kaya.knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private HouseService houseService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private HousePhotoService housePhotoService;

    @PostMapping("create_corenting")
    public ResponseEntity<Map<String, Object>> createNewHouseType(@RequestBody UserHouseJoinDTO userHouseJoinDTO, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            Corenting corenting = new Corenting();
            corenting.setHouseStatusId(houseStatusService.fetchHouseStatusById(userHouseJoinDTO.getHouseStatusId()));
            corenting.setRenterId(usersService.fetchUserById(userHouseJoinDTO.getRenterId()));
            corenting.setRenterComment(userHouseJoinDTO.getRenterComment());
            corenting.setActive(true);
            corenting.setRenterStatus("READY");
            corentingService.createNewCorenting(corenting);

            map.put("status", "success");
            map.put("data", corenting);
            map.put("message", "added in co-renting list");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("fetch_corenting_by_house/{house_id}")
    public ResponseEntity<Map<String, Object>> getHouseTypeById(@PathVariable("house_id") String house_id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<CorentingUserHouseDTO> corenting = corentingService.fetchCorentingByHouseStatusId(house_id);
            map.put("status", "success");
            map.put("data", corenting);
            map.put("message", "corenting fetched successful");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("fetch_corentingByHouseStatus/{status_id}")
    public ResponseEntity<Map<String, Object>> getHouseDetailByHouse(@PathVariable("status_id") String status_id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<CorentingUserHouseDTO> corenting = corentingService.fetchCorentingByHouseStatusId(status_id);
            List<Users> usersList= new ArrayList<>();
            List<HousePhoto> housePhotoList=new ArrayList<>();
            corenting.forEach(item->{
                Users users=usersService.fetchUserById(item.getRenterId());
                usersList.add(users);
            });

            map.put("status", "success");
//            map.put("data", corenting);
//            map.put("houseDetails",houseService.fetchHouseById(corenting.get(0).getHouseId()));
            map.put("usersList",usersList);
            map.put("houseStatus",houseStatusService.fetchHouseStatusById(corenting.get(0).getHouseStatusId()));
            map.put("housePhoto",housePhotoService.getHousePhotoByHouse(corenting.get(0).getHouseSingleUnity()));
            map.put("message", "corenting fetched successful");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("corenting_details/{house_id}")
    public ResponseEntity<RequestResponse> getCorentingDetails(@PathVariable String house_id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            Gson gson = new Gson();
//            CorentingUserHouseDTO corenting = corentingService.fetchCorentingDetailsByHouse(house_id);
            System.out.println("========");
            CorentingDetailsDTO corentingDetailsDTO = CorentingDetailsDTO.builder()
                    .corentingId("corenting.getCorentingId()")
                    .email("corenting.getEmail()")
                    .renterFirstName("corenting.getRenterFirstName()")
                    .renterStatus("corenting.getRenterStatus()")
//                    .houseStatus(gson.fromJson(houseStatusService.fetchHouseStatusById(house_id),HouseStatusDTO)
                    .build();

            return new ResponseEntity<>(RequestResponse
                    .builder()
                    .status(HttpStatus.OK)
                    .data(corentingDetailsDTO).build(), HttpStatus.OK);
//            map.put("status","success");
//            map.put("data",corenting);
//            map.put("message","corenting fetched successful");
//            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(RequestResponse
                    .builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Something went wrong!")
                    .data(e)
                    .build(), HttpStatus.BAD_REQUEST
            );
        }

    }
}
