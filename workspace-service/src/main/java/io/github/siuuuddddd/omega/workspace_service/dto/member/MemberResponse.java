package io.github.siuuuddddd.omega.workspace_service.dto.member;


import io.github.siuuuddddd.omega.common_lib.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
