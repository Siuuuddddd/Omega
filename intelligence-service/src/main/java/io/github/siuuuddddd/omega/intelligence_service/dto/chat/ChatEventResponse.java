package io.github.siuuuddddd.omega.intelligence_service.dto.chat;


import io.github.siuuuddddd.omega.common_lib.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
