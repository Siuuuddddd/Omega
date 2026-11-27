package io.github.siuuuddddd.omega.account_service.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
