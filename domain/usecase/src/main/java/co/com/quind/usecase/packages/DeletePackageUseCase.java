package co.com.quind.usecase.packages;

import co.com.quind.domain.packages.ports.DeletePackageByIdRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DeletePackageUseCase {
    private final DeletePackageByIdRepositoryPort deletePackageByIdRepositoryPort;

    public void deletePackage(String trackingId) {
        deletePackageByIdRepositoryPort.deletePackage(trackingId);
        log.info("Package deleted with tracking ID: {}", trackingId);
    }
}
