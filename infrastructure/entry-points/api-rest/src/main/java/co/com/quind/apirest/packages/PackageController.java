package co.com.quind.apirest.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.model.Status;
import co.com.quind.usecase.packages.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/packages")
@RequiredArgsConstructor
public class PackageController {
    private final CreatePackageUseCase createPackageUseCase;
    private final ChangeStatusUseCase changeStatusUseCase;
    private final UpdatePackageUseCase updatePackageUseCase;
    private final DeletePackageUseCase deletePackageUseCase;
    private final GetPackageByIdUseCase getPackageByIdUseCase;
    private final PackageRequestMapper packageRequestMapper;
    private final PackageResponseMapper packageResponseMapper;

    @PostMapping
    public ResponseEntity<PackageResponseDTO> createPackage(@RequestBody PackageRequestDTO packageRequestDTO) {
        log.info("Received request to create package with tracking ID: {}", packageRequestDTO.trackingId());
        PackageResponseDTO responseDTO = packageResponseMapper.toDto(createPackageUseCase.createPackage(packageRequestMapper.toDomain(packageRequestDTO)));
        log.info("Package created successfully with tracking ID: {}", responseDTO.trackingId());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<PackageResponseDTO> getPackageById(@PathVariable String trackingId) {
        log.info("Received request to get package with tracking ID: {}", trackingId);

        var domainPackage = getPackageByIdUseCase.getPackageById(trackingId);

        PackageResponseDTO responseDTO = packageResponseMapper.toDto(domainPackage);

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping
    public ResponseEntity<PackageResponseDTO> updatePackage(
            @Valid @RequestBody PackageRequestDTO packageRequestDTO) {
        log.info("Received request to update package with tracking ID: {}", packageRequestDTO.trackingId());

        PackageDomain domainPackage = packageRequestMapper.toDomain(packageRequestDTO);

        PackageDomain updatedPackage = updatePackageUseCase.updatePackage(domainPackage);

        PackageResponseDTO responseDTO = packageResponseMapper.toDto(updatedPackage);

        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/{trackingId}/status")
    public ResponseEntity<PackageResponseDTO> changePackageStatus(
            @PathVariable String trackingId,
            @RequestParam Status newStatus) {
        log.info("Received request to change status for package {} to {}", trackingId, newStatus);

        PackageDomain updatedPackage = changeStatusUseCase.changeStatusPackage(trackingId, newStatus);

        PackageResponseDTO responseDTO = packageResponseMapper.toDto(updatedPackage);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{trackingId}")
    public ResponseEntity<Void> deletePackage(@PathVariable String trackingId) {
        log.info("Received request to delete package with tracking ID: {}", trackingId);
        deletePackageUseCase.deletePackage(trackingId);
        return ResponseEntity.noContent().build();
    }
}
