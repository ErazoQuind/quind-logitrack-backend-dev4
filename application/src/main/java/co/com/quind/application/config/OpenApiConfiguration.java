package co.com.quind.application.config;

import java.util.Map;

import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

@Configuration
@SecurityScheme(
        name = "jwt",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER,
        bearerFormat = "JWT")
public class OpenApiConfiguration {
    public static final String SWAGGER_TITLE_MESSAGE = "quind-logitrack-backend-dev4 API";
    public static final String SWAGGER_DESCRIPTION_API_MESSAGE =
            "quind-logitrack-backend-dev4 API: API, la cual tiene como objetivo centralizar en un solo lugar el envío de notificaciones por diferentes medios";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "https://springdoc.org";
    public static final String SWAGGER_TERM_OF_SERVICE_MESSAGE = "https://swagger.io/terms/";

    @Bean
    public OpenAPI openApiConfig() {
        Schema<?> successObjectSchema = new Schema<Map<String, String>>()
                .addProperty("message", new StringSchema().example("Successful personalized message"))
                .addProperty("status", new StringSchema().example("200"));

        Schema<?> errorObjectSchema = new Schema<Map<String, Object>>()
                .addProperty("exceptionName", new StringSchema().example("name of the exception that occurred"))
                .addProperty("userMessage", new StringSchema().example("Message which will be shown to the user"))
                .addProperty(
                        "technicalMessage",
                        new StringSchema().example("Message with more detail of the error that occurred"));

        Parameter parameter = new Parameter()
                .in("header")
                .name("trace-id")
                .description("ID de seguimiento de 32 caracteres hexadecimales según W3C Trace Context")
                .required(true)
                .schema(new io.swagger.v3.oas.models.media.StringSchema());

        return new OpenAPI()
                .info(new Info()
                        .title(SWAGGER_TITLE_MESSAGE)
                        .description(SWAGGER_DESCRIPTION_API_MESSAGE)
                        .version(SWAGGER_VERSION_MESSAGE)
                        .license(
                                new License().name(SWAGGER_LICENSE_NAME_MESSAGE).url(SWAGGER_LICENSE_URL_MESSAGE))
                        .termsOfService(SWAGGER_TERM_OF_SERVICE_MESSAGE))
                .components(new Components()
                        .addSchemas("Success", successObjectSchema)
                        .addSchemas("Error", errorObjectSchema)
                        .addParameters("trace-id", parameter));
    }

    @Bean
    public OperationCustomizer globalHeaderCustomizer() {
        return (operation, handlerMethod) -> {
            // Añade el parámetro trace-id a todas las operaciones
            operation.addParametersItem(new Parameter().$ref("#/components/parameters/trace-id"));
            return operation;
        };
    }
}
