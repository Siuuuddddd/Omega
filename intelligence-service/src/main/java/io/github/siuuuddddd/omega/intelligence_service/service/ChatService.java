package io.github.siuuuddddd.omega.intelligence_service.service;


import io.github.siuuuddddd.omega.intelligence_service.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);
}
