package io.github.siuuuddddd.omega.intelligence_service.mapper;

import io.github.siuuuddddd.omega.intelligence_service.dto.chat.ChatResponse;
import io.github.siuuuddddd.omega.intelligence_service.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
