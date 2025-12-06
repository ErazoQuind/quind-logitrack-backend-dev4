package co.com.quind.apirest.packages;

import co.com.quind.domain.packages.model.LocationHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationHistoryResponseMapper {
    LocationHistoryResponseDTO toDto(LocationHistory domain);
    List<LocationHistoryResponseDTO> toDtoList(List<LocationHistory> domainList);
}
