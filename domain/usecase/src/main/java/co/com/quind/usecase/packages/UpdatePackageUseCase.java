package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.model.PackageFactory;
import co.com.quind.domain.packages.ports.GetPackageRepositoryPort;
import co.com.quind.domain.packages.ports.UpdatePackageRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UpdatePackageUseCase {
    private final UpdatePackageRepositoryPort updatePackageRepository;
    private final GetPackageRepositoryPort getPackageRepository;


    public PackageDomain updatePackage(PackageDomain newPackage) {
        PackageDomain existPackageDomain = getPackageRepository.getPackageById(newPackage.getTrackingId())
                .orElseThrow(() -> new IllegalArgumentException("El paquete con ID de seguimiento " + newPackage.getTrackingId() + " no existe."));

        PackageDomain updatedPackage = updatePackageRepository.updatePackage(PackageFactory.updatePackage(existPackageDomain, newPackage));
        log.info("Package updated with tracking ID: {}", newPackage.getTrackingId());
        return updatedPackage;
    }
}
