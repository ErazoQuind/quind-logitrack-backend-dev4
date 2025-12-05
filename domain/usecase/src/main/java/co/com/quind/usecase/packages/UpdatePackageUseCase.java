package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.ports.UpdatePackageRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UpdatePackageUseCase {
    private final UpdatePackageRepositoryPort updatePackageRepository;

    public void updatePackage(PackageDomain packageDomain) {
        updatePackageRepository.updatePackage(packageDomain);
        log.info("Package updated with tracking ID: {}", packageDomain.getTrackingId());
    }
}
