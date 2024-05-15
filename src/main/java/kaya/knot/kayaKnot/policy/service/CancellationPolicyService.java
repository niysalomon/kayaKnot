package kaya.knot.kayaKnot.policy.service;

import kaya.knot.kayaKnot.policy.entity.CancellationPolicy;

import java.util.List;
import java.util.Optional;

public interface CancellationPolicyService {
    CancellationPolicy createNewCancellationPolicy(CancellationPolicy cancellationPolicy);
    CancellationPolicy updateCancellationPolicy(CancellationPolicy cancellationPolicy);
    List<CancellationPolicy> fetchAllCancellationPolicies();
     Optional<CancellationPolicy> fetchCancellationPoliciesById(final String id);
}
