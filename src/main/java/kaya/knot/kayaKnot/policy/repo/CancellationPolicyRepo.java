package kaya.knot.kayaKnot.policy.repo;

import kaya.knot.kayaKnot.policy.entity.CancellationPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationPolicyRepo extends JpaRepository<CancellationPolicy,String> {
}
