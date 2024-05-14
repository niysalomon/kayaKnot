package kaya.knot.kayaKnot.policy.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kaya.knot.kayaKnot.user.entity.Users;
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
public class UserCancellationPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private Users userId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cancellation_id", nullable = false)
    @JsonManagedReference
    private CancellationPolicy cancellationId;
    @Column(name = "createdDate")
    @CreatedDate
    private Timestamp createdDate;

    @Column(name = "createdBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private Timestamp updatedDate;

    @Column(name = "lastUpdatedBy")
    @LastModifiedBy
    private String lastUpdatedBy;
}
