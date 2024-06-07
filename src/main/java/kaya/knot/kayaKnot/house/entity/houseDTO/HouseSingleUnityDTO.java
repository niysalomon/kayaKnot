package kaya.knot.kayaKnot.house.entity.houseDTO;

import jakarta.persistence.Column;
import kaya.knot.kayaKnot.house.entity.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseSingleUnity {
    private String id;
    private String unityName;
    private String referenceNumber;
    private String unityStatus;
    private String houseId;
    private String unityType; //Commercial,house part, single apartment, shop, office, or residential to display more details
    private int bedrooms;
    private int bathrooms;
    private int salons;
    private int dinningRooms;
    private String description;
    private  boolean isActive;
}
