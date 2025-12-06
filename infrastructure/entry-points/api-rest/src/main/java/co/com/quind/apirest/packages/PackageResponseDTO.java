package co.com.quind.apirest.packages;

import java.util.List;

public record PackageResponseDTO(
        String trackingId,
        String recipientName,
        String recipientAddress,
        Double height,
        Double width,
        Double depth,
        Double weight,
        String status,
        List<LocationHistoryResponseDTO> locationHistoryResponseDTOList
) {

}
