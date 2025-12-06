package co.com.quind.apirest.packages;

import co.com.quind.domain.packages.model.Dimensions;
import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.model.RecipientInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PackageRequestMapper {
    @Mapping(target = "recipientInfo", expression = "java(mapRecipientInfo(dto.recipientName(), dto.recipientAddress()))")
    @Mapping(target = "dimensions", expression = "java(mapDimensions(dto.height(), dto.width(), dto.depth()))")
    @Mapping(target = "status", expression = "java(co.com.quind.domain.packages.model.Status.CREATED)") // Estado inicial de negocio
    @Mapping(target = "locationHistories", expression = "java(new java.util.ArrayList<>())") // Lista vacía
    PackageDomain toDomain(PackageRequestDTO dto);

    default RecipientInfo mapRecipientInfo(String name, String address) {
        return new RecipientInfo(name, address);
    }

    default Dimensions mapDimensions(Double height, Double width, Double depth) {
        return new Dimensions(height, width, depth);
    }
}
