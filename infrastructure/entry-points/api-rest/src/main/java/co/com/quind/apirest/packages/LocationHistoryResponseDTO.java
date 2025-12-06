package co.com.quind.apirest.packages;

import java.time.LocalDateTime;

public record LocationHistoryResponseDTO(String country, String city, LocalDateTime date) {
}
