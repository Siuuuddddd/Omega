package io.github.siuuuddddd.omega.workspace_service.repository;

import io.github.siuuuddddd.omega.workspace_service.entity.ProcessedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedEventRepository extends JpaRepository<ProcessedEvent, String> {
}
