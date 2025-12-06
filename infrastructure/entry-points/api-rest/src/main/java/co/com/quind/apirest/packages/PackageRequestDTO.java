package co.com.quind.apirest.packages;

public record PackageRequestDTO(String trackingId,
                                String recipientName,
                                String recipientAddress,
                                Double height,
                                Double width,
                                Double depth,
                                Double weight) {
}
