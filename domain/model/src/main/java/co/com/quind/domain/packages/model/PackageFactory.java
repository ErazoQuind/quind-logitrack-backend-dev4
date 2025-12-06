package co.com.quind.domain.packages.model;

import java.util.List;

public class PackageFactory {
    private PackageFactory() {
    }

    public static PackageDomain updatePackage(PackageDomain existingPackage, PackageDomain newPackage) {
        return PackageDomain.builder()
                .trackingId(existingPackage.getTrackingId())
                .recipientInfo(newPackage.getRecipientInfo() != null ? newPackage.getRecipientInfo() : existingPackage.getRecipientInfo())
                .dimensions(newPackage.getDimensions() != null ? newPackage.getDimensions() : existingPackage.getDimensions())
                .weight(newPackage.getWeight() != null ? newPackage.getWeight() : existingPackage.getWeight())
                .status(newPackage.getStatus() != null ? newPackage.getStatus() : existingPackage.getStatus())
                .locationHistories(newPackage.getLocationHistories() != null ? newPackage.getLocationHistories() : existingPackage.getLocationHistories())
                .build();

    }

    public static PackageDomain map(PackageMapperDTO dto) {
        return PackageDomain.builder()
                .trackingId(dto.trackingId())
                .recipientInfo(dto.recipientInfo())
                .dimensions(dto.dimensions())
                .weight(dto.weight())
                .status(dto.status())
                .locationHistories(dto.history())
                .build();

    }

    public record PackageMapperDTO(
            String trackingId,
            RecipientInfo recipientInfo,
            Dimensions dimensions,
            Double weight,
            Status status,
            List<LocationHistory> history
    ) {
    }
}
