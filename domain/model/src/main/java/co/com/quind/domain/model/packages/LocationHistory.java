package co.com.quind.domain.model.packages;

import java.time.LocalDateTime;

public record LocationHistory(String country, String city, LocalDateTime date) {
}
