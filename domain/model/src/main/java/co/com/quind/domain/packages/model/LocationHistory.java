package co.com.quind.domain.packages.model;

import java.time.LocalDateTime;

public record LocationHistory(String country, String city, LocalDateTime date) {
}
