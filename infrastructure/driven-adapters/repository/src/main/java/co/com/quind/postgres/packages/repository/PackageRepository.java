package co.com.quind.postgres.packages.repository;

import co.com.quind.postgres.packages.entities.PackageEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends ListCrudRepository<PackageEntity, String> {
    List<PackageEntity> findByStatus(String status);
}
