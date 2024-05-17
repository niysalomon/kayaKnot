package kaya.knot.kayaKnot.policy.service;

import kaya.knot.kayaKnot.policy.entity.SystemCancellationPolicy;

import java.util.List;

public interface SystemCancellationPolicyService {
    SystemCancellationPolicy createNewSystemPolicy(SystemCancellationPolicy systemCancellationPolicy);
    SystemCancellationPolicy updateSystemPolicy(SystemCancellationPolicy systemCancellationPolicy);
    List<SystemCancellationPolicy> fetchAllSystemPolicies();
    SystemCancellationPolicy fetchSinglePolicy(String id);
}
