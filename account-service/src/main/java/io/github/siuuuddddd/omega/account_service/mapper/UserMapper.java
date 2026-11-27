package io.github.siuuuddddd.omega.account_service.mapper;

import io.github.siuuuddddd.omega.account_service.dto.auth.SignupRequest;
import io.github.siuuuddddd.omega.account_service.dto.auth.UserProfileResponse;
import io.github.siuuuddddd.omega.account_service.entity.User;
import io.github.siuuuddddd.omega.common_lib.dto.UserDto;
import io.github.siuuuddddd.omega.common_lib.security.JwtUserPrincipal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    @Mapping(source = "userId", target = "id")
    UserProfileResponse toUserProfileResponse(JwtUserPrincipal user);

    UserDto toUserDto(User user);

}
