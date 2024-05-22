package kaya.knot.kayaKnot.booking.repo;

import kaya.knot.kayaKnot.booking.entity.HouseStatus;
import kaya.knot.kayaKnot.house.entity.HouseOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseStatusRepo extends JpaRepository<HouseStatus,String> {
    @Query(value = "UPDATE house_status SET booking_status='AVAILABLE' WHERE house=:house_id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public int settingHouseAvailable(String house_id);
    @Query(value = "UPDATE house_status SET booking_status='OCCUPIED' WHERE house=:house_id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public int settingHouseOccupied(String house_id);

    @Query(value = "SELECT * FROM house_status WHERE id=:id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public HouseStatus fetchHouseStatusById(String id);
}
