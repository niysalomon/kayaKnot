package kaya.knot.kayaKnot.booking.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CorentingUserHouseDTO {
    private String corentingId;
    private String renterStatus;
    private String renterComment;
     private String renterId;
     private String houseStatusId;
     private String houseId;

    public CorentingUserHouseDTO(String corentingId, String renterStatus, String renterComment, String renterId, String houseStatusId, String houseId) {
        this.corentingId = corentingId;
        this.renterStatus = renterStatus;
        this.renterComment = renterComment;
        this.renterId = renterId;
        this.houseStatusId = houseStatusId;
        this.houseId = houseId;
    }
}
