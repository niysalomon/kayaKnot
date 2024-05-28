package kaya.knot.kayaKnot.booking.repo;

import kaya.knot.kayaKnot.booking.entity.Corenting;
import kaya.knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorentingRepo extends JpaRepository<Corenting,String> {
    @Query(value = "SELECT * FROM kaya.corenting,kaya.house_status WHERE corenting.house_status_id=house_status.id and house_status.id=:house_id and corenting.is_deleted=0 and corenting.is_active=1",nativeQuery = true)
    public List<Corenting> findCorentingHouse(String house_id);

    @Query("SELECT new kaya.knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO(a.id,a.renterStatus,u.firstName,u.email,h.bookingStatus ) FROM Corenting a JOIN Users u  ON a.renterId.id=u.id JOIN HouseStatus h ON a.houseStatusId.id=h.id")
    public List<CorentingUserHouseDTO> fetchingHouseAndUser(String house_id);
}
