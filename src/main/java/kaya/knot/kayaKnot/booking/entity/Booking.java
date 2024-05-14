package kaya.knot.kayaKnot.booking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kaya.knot.kayaKnot.house.entity.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id", nullable = false)
    @JsonManagedReference
    private House houseId;
    private String landLordConfirmation;
    private String bookingStatus;
    private  boolean isActive;
    private boolean isDeleted;
    @Column(name = "createdDate")
    @CreatedDate
    private Timestamp createdDate;

    @Column(name = "createdBy")
    @CreatedBy
    private long createdBy;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private Timestamp updatedDate;

    @Column(name = "lastUpdatedBy")
    @LastModifiedBy
    private long lastUpdatedBy;

}
