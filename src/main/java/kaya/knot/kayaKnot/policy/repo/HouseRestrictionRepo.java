package kaya.knot.kayaKnot.policy.repo;

import kaya.knot.kayaKnot.policy.entity.HouseRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRestrictionRepo extends JpaRepository<HouseRestriction,String> {
}
