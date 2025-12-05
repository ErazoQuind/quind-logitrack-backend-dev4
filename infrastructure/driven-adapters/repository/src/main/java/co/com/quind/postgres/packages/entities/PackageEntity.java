package co.com.quind.postgres.packages.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
public class PackageEntity {
    @Id
    @Column(name = "tracking_id", nullable = false, unique = true)
    private String trackingId;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Column(name = "recipient_address", nullable = false)
    private String recipientAddress;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double depth;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "packageId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LocationHistory> locationHistories = new ArrayList<>();
}
