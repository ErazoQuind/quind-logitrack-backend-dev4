package co.com.quind.domain.packages.model;

import co.com.quind.domain.common.BusinessRuleException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Builder(toBuilder = true, access = AccessLevel.MODULE)
public class PackageDomain {
    private final String trackingId;
    private final RecipientInfo recipientInfo;
    private final Dimensions dimensions;
    private final Double weight;
    private Status status;
    private final List<LocationHistory> locationHistories;

    public PackageDomain addLocation(LocationHistory location) {
        if (location == null) {
            throw new BusinessRuleException("La ubicación es requerida.");
        }

        if (!locationHistories.isEmpty()) {
            LocationHistory last = locationHistories.getLast();
            if (location.date().isBefore(last.date())) {
                throw new BusinessRuleException("La ubicación debe ser cronológica.");
            }
        }

        List<LocationHistory> newHistory = new ArrayList<>(this.locationHistories);
        newHistory.add(location);

        return this.toBuilder()
                .locationHistories(newHistory)
                .build();
    }

    public PackageDomain changeStatus(Status newStatus) {
        if (newStatus == null) {
            throw new BusinessRuleException("El estado no puede ser nulo.");
        }

        return this.toBuilder()
                .status(newStatus)
                .build();
    }
}

