package co.com.quind.postgres.packages.entities;


import co.com.quind.domain.packages.model.LocationHistory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "location_history")
@Data
@NoArgsConstructor
public class LocationHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_tracking_id", nullable = false)
    private PackageEntity packageId;

    public LocationHistory toDomain() {
        return new LocationHistory(
                this.city,
                this.country,
                this.date
        );
    }
}