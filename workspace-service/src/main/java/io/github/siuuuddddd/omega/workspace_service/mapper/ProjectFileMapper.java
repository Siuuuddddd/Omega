package io.github.siuuuddddd.omega.workspace_service.mapper;

import io.github.siuuuddddd.omega.common_lib.dto.FileNode;
import io.github.siuuuddddd.omega.workspace_service.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}
