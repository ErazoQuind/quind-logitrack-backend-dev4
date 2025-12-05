package co.com.quind.domain.packages.ports;

import co.com.quind.domain.packages.model.PackageDomain;

import java.util.Optional;

public interface GetPackageRepositoryPort {
    Optional<PackageDomain> getPackageById(String trackingId);
}
