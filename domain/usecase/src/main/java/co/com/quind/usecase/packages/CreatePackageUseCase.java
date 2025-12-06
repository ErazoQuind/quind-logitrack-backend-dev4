package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.ports.CreatePackageRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreatePackageUseCase {
    private final CreatePackageRepositoryPort createPackageRepository;

    public PackageDomain createPackage(PackageDomain packageDomain) {
        log.info("Package created with tracking ID: {}", packageDomain.getTrackingId());
        return createPackageRepository.createPackage(packageDomain);
    }
}
