package kaya.knot.kayaKnot.house.controller;

import jakarta.servlet.http.HttpServletRequest;
import kaya.knot.kayaKnot.house.entity.House;
import kaya.knot.kayaKnot.house.entity.houseDTO.HouseDTO;
import kaya.knot.kayaKnot.house.service.HouseService;
import kaya.knot.kayaKnot.house.service.HouseTypeService;
import kaya.knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseTypeService houseTypeService;
    @Autowired
    private UsersService usersService;
    @PostMapping("create_new_house")
    public ResponseEntity<Map<String,Object>> createNewHouseType(@RequestBody HouseDTO houseDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            House house=new House();
            house.setHouseType(houseTypeService.fetchHouseById(houseDTO.getHouseType()));
            house.setHouseName(houseDTO.getHouseName());
            house.setAvailable(houseDTO.isAvailable());
            house.setBathrooms(houseDTO.getBathrooms());
            house.setBedrooms(houseDTO.getBedrooms());
            house.setActive(true);
            house.setProvince(houseDTO.getProvince());
            house.setDistrict(houseDTO.getDistrict());
            house.setSector(houseDTO.getSector());
            house.setCell(houseDTO.getCell());
            house.setVillage(houseDTO.getVillage());
            house.setDescription(houseDTO.getDescription());
            house.setFurnished(houseDTO.isFurnished());
            house.setLandLordId(usersService.fetchUserById(houseDTO.getLandLordId()));
            houseService.createNewHouse(house);
            map.put("status","success");
            map.put("data",house);
            map.put("message","house created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("update_house")
    public ResponseEntity<Map<String,Object>> updateHouseType(@RequestBody HouseDTO houseDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            House house=new House();
            house.setHouseType(houseTypeService.fetchHouseById(houseDTO.getHouseType()));
            house.setId(houseDTO.getId());
            house.setHouseName(houseDTO.getHouseName());
            house.setAvailable(houseDTO.isAvailable());
            house.setBathrooms(houseDTO.getBathrooms());
            house.setBedrooms(houseDTO.getBedrooms());
            house.setProvince(houseDTO.getProvince());
            house.setDistrict(houseDTO.getDistrict());
            house.setSector(houseDTO.getSector());
            house.setCell(houseDTO.getCell());
            house.setVillage(houseDTO.getVillage());
            house.setDescription(houseDTO.getDescription());
            house.setFurnished(houseDTO.isFurnished());
            house.setLandLordId(usersService.fetchUserById(houseDTO.getLandLordId()));
            houseService.updateHouse(house);
            map.put("status","success");
            map.put("data",house);
            map.put("message","house updated successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("fetch_house/{id}")
    public ResponseEntity<Map<String,Object>> getHouseTypeById(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            House house=houseService.fetchHouseById(id);
            map.put("status","success");
            map.put("data",house);
            map.put("message","house fetched successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("get_all_house")
    public ResponseEntity<Map<String,Object>> getPersonalPolicyByUser( HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<House> houseList=houseService.fetchingAllHouse();
            map.put("status","success");
            map.put("data",houseList);
            map.put("message","house fetched successful");
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
