package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.ports.GetPackageRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetPackageByIdUseCase {
    private final GetPackageRepositoryPort getPackageRepositoryPort;

    public PackageDomain getPackageById(String trackingId) {
        log.info("Fetching package with tracking ID: {}", trackingId);
        return getPackageRepositoryPort.getPackageById(trackingId).orElseThrow(()-> new IllegalArgumentException("Package not found with tracking ID: " + trackingId));
    }
}
