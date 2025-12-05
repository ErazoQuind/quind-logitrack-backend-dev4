package co.com.quind.domain.model.packages;

import lombok.Builder;

import java.util.List;

@Builder
public class Package {
    private final String trackingId;
    private final RecipientInfo recipientInfo;
    private final Dimensions dimensions;
    private final Double weight;
    private Status status;
    private final List<LocationHistory> history;

    public void addLocation(LocationHistory location) {
        if (location == null) throw new IllegalArgumentException("La ubicación es requerido");
        if (!history.isEmpty()) {
            LocationHistory last = history.getLast();
            if (location.date().isBefore(last.date())) {
                throw new IllegalArgumentException("La ubicación debe ser cronológico");
            }
        }
        history.add(location);
    }

    public void changeStatus(Status newStatus) {
        status = newStatus;
    }
}
