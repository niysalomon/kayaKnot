package kaya.knot.kayaKnot.policy.repo;

import kaya.knot.kayaKnot.policy.entity.PersonalPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalPolicyRepo extends JpaRepository<PersonalPolicy, String> {
}
