package co.com.quind.apirest.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {LocationHistoryResponseMapper.class} // Inyecta el mapper del historial
)
public interface PackageResponseMapper {
    @Mapping(target = "recipientName", source = "recipientInfo.name")
    @Mapping(target = "recipientAddress", source = "recipientInfo.address")
    @Mapping(target = "height", source = "dimensions.height")
    @Mapping(target = "width", source = "dimensions.width")
    @Mapping(target = "depth", source = "dimensions.depth")
    //todo: revisar este mapeo de status no me gusta
    @Mapping(target = "status", expression = "java(domain.getStatus().name())")
    @Mapping(target = "locationHistoryResponseDTOList", source = "locationHistories")
    PackageResponseDTO toDto(PackageDomain domain);
}
