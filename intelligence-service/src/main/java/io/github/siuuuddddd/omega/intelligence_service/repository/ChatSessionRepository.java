package io.github.siuuuddddd.omega.intelligence_service.repository;

import io.github.siuuuddddd.omega.intelligence_service.entity.ChatSession;
import io.github.siuuuddddd.omega.intelligence_service.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
