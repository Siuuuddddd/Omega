package io.github.siuuuddddd.omega.workspace_service.mapper;

import io.github.siuuuddddd.omega.common_lib.enums.ProjectRole;
import io.github.siuuuddddd.omega.workspace_service.dto.project.ProjectResponse;
import io.github.siuuuddddd.omega.workspace_service.dto.project.ProjectSummaryResponse;
import io.github.siuuuddddd.omega.workspace_service.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
