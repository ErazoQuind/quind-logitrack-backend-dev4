package co.com.quind.domain.packages.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

    public void addLocation(LocationHistory location) {
        if (location == null) throw new IllegalArgumentException("La ubicación es requerido");
        if (!locationHistories.isEmpty()) {
            LocationHistory last = locationHistories.getLast();
            if (location.date().isBefore(last.date())) {
                throw new IllegalArgumentException("La ubicación debe ser cronológico");
            }
        }
        locationHistories.add(location);
    }

    public void changeStatus(Status newStatus) {
        status = newStatus;
    }
}

