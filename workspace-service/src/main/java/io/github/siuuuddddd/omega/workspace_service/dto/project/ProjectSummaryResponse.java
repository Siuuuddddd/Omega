package io.github.siuuuddddd.omega.workspace_service.dto.project;


import io.github.siuuuddddd.omega.common_lib.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
