package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.ports.CreatePackageRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreatePackageUseCase {
    private final CreatePackageRepositoryPort createPackageRepository;

    public void createPackage(PackageDomain packageDomain) {
        createPackageRepository.createPackage(packageDomain);
        log.info("Package created with tracking ID: {}", packageDomain.getTrackingId());
    }
}
