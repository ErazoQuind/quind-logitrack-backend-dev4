package co.com.quind.application.config;

import co.com.quind.domain.packages.ports.CreatePackageRepositoryPort;
import co.com.quind.domain.packages.ports.DeletePackageByIdRepositoryPort;
import co.com.quind.domain.packages.ports.GetPackageRepositoryPort;
import co.com.quind.domain.packages.ports.UpdatePackageRepositoryPort;
import co.com.quind.usecase.packages.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {
    @Bean
    public CreatePackageUseCase createPackageUseCase(CreatePackageRepositoryPort createPackageRepository) {
        return new CreatePackageUseCase(createPackageRepository);
    }
    @Bean
    public UpdatePackageUseCase updatePackageUseCase(UpdatePackageRepositoryPort updatePackageRepository, GetPackageRepositoryPort getPackageRepository) {
        return new UpdatePackageUseCase(updatePackageRepository, getPackageRepository);
    }
    @Bean
    public GetPackageByIdUseCase getPackageByIdUseCase(GetPackageRepositoryPort getPackageRepository) {
        return new GetPackageByIdUseCase(getPackageRepository);
    }
    @Bean
    public ChangeStatusUseCase changeStatusUseCase(UpdatePackageRepositoryPort updatePackageRepository, GetPackageRepositoryPort getPackageRepository) {
        return new ChangeStatusUseCase(updatePackageRepository, getPackageRepository);
    }
    @Bean
    public DeletePackageUseCase deletePackageUseCase(DeletePackageByIdRepositoryPort deletePackageByIdRepository) {
        return new DeletePackageUseCase(deletePackageByIdRepository);
    }

}
