package co.com.quind.postgres.packages.entities;

import co.com.quind.domain.packages.model.*;
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
    private List<LocationHistoryEntity> locationHistories = new ArrayList<>();

    public static PackageEntity fromDomain(PackageDomain packageDomain) {
        PackageEntity entity = new PackageEntity();
        entity.setTrackingId(packageDomain.getTrackingId());
        entity.setRecipientName(packageDomain.getRecipientInfo().name());
        entity.setRecipientAddress(packageDomain.getRecipientInfo().address());
        entity.setHeight(packageDomain.getDimensions().height());
        entity.setWidth(packageDomain.getDimensions().width());
        entity.setDepth(packageDomain.getDimensions().depth());
        entity.setWeight(packageDomain.getWeight());
        entity.setStatus(packageDomain.getStatus().name());

        List<LocationHistoryEntity> locationHistoryEntities = packageDomain.getLocationHistories().stream()
                .map(locationHistory -> {
                    LocationHistoryEntity locationHistoryEntity = new LocationHistoryEntity();
                    locationHistoryEntity.setCity(locationHistory.city());
                    locationHistoryEntity.setCountry(locationHistory.country());
                    locationHistoryEntity.setDate(locationHistory.date());
                    locationHistoryEntity.setPackageId(entity);
                    return locationHistoryEntity;
                })
                .toList();

        entity.setLocationHistories(locationHistoryEntities);

        return entity;
    }

    public PackageDomain toDomain() {
        PackageFactory.PackageMapperDTO dto = new PackageFactory.PackageMapperDTO(
                this.trackingId,
                new RecipientInfo(this.recipientName, this.recipientAddress),
                new Dimensions(this.height, this.width, this.depth),
                this.weight,
                Status.valueOf(this.status),
                this.locationHistories.stream()
                        .map(LocationHistoryEntity::toDomain)
                        .toList()
        );

        return PackageFactory.map(dto);
    }
}
