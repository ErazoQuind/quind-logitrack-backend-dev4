package co.com.quind.apirest.common;

public record ErrorResponse(
        int status,
        String error,
        String message
) {}
