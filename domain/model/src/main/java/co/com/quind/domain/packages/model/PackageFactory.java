package co.com.quind.domain.packages.model;

import java.util.List;

public class PackageFactory {
    private PackageFactory() {
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
