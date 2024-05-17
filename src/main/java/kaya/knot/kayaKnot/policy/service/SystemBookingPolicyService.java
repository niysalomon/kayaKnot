package kaya.knot.kayaKnot.policy.service;

import kaya.knot.kayaKnot.policy.entity.SystemBookingPolicy;

import java.util.List;

public interface SystemBookingPolicyService {
    SystemBookingPolicy createNewSystemPolicy(SystemBookingPolicy systemBookingPolicy);
    SystemBookingPolicy updateSystemPolicy(SystemBookingPolicy systemBookingPolicy);
    List<SystemBookingPolicy> fetchAllSystemPolicies();
    SystemBookingPolicy fetchSinglePolicy(String id);
}
