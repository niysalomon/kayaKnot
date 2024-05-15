package kaya.knot.kayaKnot.house.repo;

import kaya.knot.kayaKnot.house.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepo extends JpaRepository<House , String> {
}
