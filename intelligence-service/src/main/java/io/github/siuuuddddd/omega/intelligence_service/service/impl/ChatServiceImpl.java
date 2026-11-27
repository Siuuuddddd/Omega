package io.github.siuuuddddd.omega.intelligence_service.service.impl;

import io.github.siuuuddddd.omega.common_lib.security.AuthUtil;
import io.github.siuuuddddd.omega.intelligence_service.dto.chat.ChatResponse;
import io.github.siuuuddddd.omega.intelligence_service.entity.ChatMessage;
import io.github.siuuuddddd.omega.intelligence_service.entity.ChatSession;
import io.github.siuuuddddd.omega.intelligence_service.entity.ChatSessionId;
import io.github.siuuuddddd.omega.intelligence_service.mapper.ChatMapper;
import io.github.siuuuddddd.omega.intelligence_service.repository.ChatMessageRepository;
import io.github.siuuuddddd.omega.intelligence_service.repository.ChatSessionRepository;
import io.github.siuuuddddd.omega.intelligence_service.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}
