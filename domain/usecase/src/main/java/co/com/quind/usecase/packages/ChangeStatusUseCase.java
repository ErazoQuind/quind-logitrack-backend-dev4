package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.model.Status;
import co.com.quind.domain.packages.ports.GetPackageRepositoryPort;
import co.com.quind.domain.packages.ports.UpdatePackageRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ChangeStatusUseCase {
    private final UpdatePackageRepositoryPort updatePackageRepository;
    private final GetPackageRepositoryPort getPackageRepository;

    //todo: Realizar transiciones de estado con patron state
    public PackageDomain changeStatusPackage(String trackingId, Status newStatus) {
        PackageDomain packageDomain = getPackageRepository.getPackageById(trackingId)
                .orElseThrow(() -> new IllegalArgumentException("El paquete con ID de seguimiento " + trackingId + " no existe."));
        PackageDomain packageUpdated = updatePackageRepository.updatePackage(packageDomain.changeStatus(newStatus));
        log.info("Status Package updated with tracking ID: {}", packageDomain.getTrackingId());
        return packageUpdated;
    }
}
