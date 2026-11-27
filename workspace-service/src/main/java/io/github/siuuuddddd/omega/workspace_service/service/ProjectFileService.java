package io.github.siuuuddddd.omega.workspace_service.service;


import io.github.siuuuddddd.omega.common_lib.dto.FileTreeDto;
import io.github.siuuuddddd.omega.workspace_service.dto.project.FileContentResponse;

public interface ProjectFileService {
    FileTreeDto getFileTree(Long projectId);

    String getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
