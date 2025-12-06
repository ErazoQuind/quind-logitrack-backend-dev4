package co.com.quind.postgres.packages.repository;

import co.com.quind.domain.packages.model.PackageDomain;
import co.com.quind.domain.packages.ports.UpdatePackageRepositoryPort;
import co.com.quind.domain.packages.ports.CreatePackageRepositoryPort;
import co.com.quind.domain.packages.ports.DeletePackageByIdRepositoryPort;
import co.com.quind.domain.packages.ports.GetPackageRepositoryPort;
import co.com.quind.postgres.packages.entities.PackageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PackageRepositoryService implements CreatePackageRepositoryPort, UpdatePackageRepositoryPort, GetPackageRepositoryPort , DeletePackageByIdRepositoryPort{
    private final PackageRepository packageRepository;

    @Override
    public PackageDomain createPackage(PackageDomain packageDomain) {
        return packageRepository.save(PackageEntity.fromDomain(packageDomain)).toDomain();
    }

    @Override
    public PackageDomain updatePackage(PackageDomain packageDomain) {
        return packageRepository.save(PackageEntity.fromDomain(packageDomain)).toDomain();
    }

    @Override
    public Optional<PackageDomain> getPackageById(String trackingId) {
        return packageRepository.findById(trackingId).map(PackageEntity::toDomain);
    }

    @Override
    public void deletePackage(String trackingId) {
        packageRepository.deleteById(trackingId);
    }
}
