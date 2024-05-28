package kaya.knot.kayaKnot.booking.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CorentingUserHouseDTO {
    private String corentingId;
    private String renterStatus;
     private String renterFirstName;
     private String email;
     private String houseStatus;

    public CorentingUserHouseDTO(String corentingId, String renterStatus, String renterFirstName, String email,String houseStatus) {
        this.corentingId = corentingId;
        this.renterStatus = renterStatus;
        this.renterFirstName = renterFirstName;
        this.email = email;
        this.houseStatus=houseStatus;
    }
}
