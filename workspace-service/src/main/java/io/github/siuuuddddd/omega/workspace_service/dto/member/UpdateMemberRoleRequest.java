package io.github.siuuuddddd.omega.workspace_service.dto.member;

import io.github.siuuuddddd.omega.common_lib.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
