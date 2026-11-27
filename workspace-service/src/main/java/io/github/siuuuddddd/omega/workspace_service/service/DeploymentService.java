package io.github.siuuuddddd.omega.workspace_service.service;

import io.github.siuuuddddd.omega.workspace_service.dto.project.DeployResponse;
import org.jspecify.annotations.Nullable;

public interface DeploymentService {
    @Nullable DeployResponse deploy(Long projectId);
}
