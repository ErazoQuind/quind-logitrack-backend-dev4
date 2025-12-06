package co.com.quind.domain.packages.ports;

import co.com.quind.domain.packages.model.PackageDomain;

public interface CreatePackageRepositoryPort {
    PackageDomain createPackage(PackageDomain packageDomain);
}
