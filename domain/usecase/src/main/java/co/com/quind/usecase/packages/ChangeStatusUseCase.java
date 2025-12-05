package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.ports.UpdatePackageRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ChangeStatusUseCase {
    private final UpdatePackageRepositoryPort updatePackageRepository;

    public void changeStatusPackage(PackageDomain packageDomain) {
        updatePackageRepository.updatePackage(packageDomain);
        log.info("Status Package updated with tracking ID: {}", packageDomain.getTrackingId());
    }
}
