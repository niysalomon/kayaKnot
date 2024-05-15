package kaya.knot.kayaKnot.policy.service.impl;

import kaya.knot.kayaKnot.policy.entity.BookingPolicy;
import kaya.knot.kayaKnot.policy.repo.BookingPolicyRepo;
import kaya.knot.kayaKnot.policy.service.BookingPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingPolicyServiceImpl implements BookingPolicyService {
    @Autowired
    private BookingPolicyRepo bookingRepo;
    @Override
    public BookingPolicy createNewBookingPolicy(BookingPolicy bookingPolicy) {
        return bookingRepo.save(bookingPolicy);
    }

    @Override
    public List<BookingPolicy> fetchingBookingPolicy() {
        return bookingRepo.findAll();
    }

    @Override
    public Optional<BookingPolicy> fetchingBookingPolicyById(final String id) {
        return bookingRepo.findById(id);
    }

    @Override
    public BookingPolicy updateBookingPolicy(BookingPolicy bookingPolicy) {
        return bookingRepo.save(bookingPolicy);
    }
}
