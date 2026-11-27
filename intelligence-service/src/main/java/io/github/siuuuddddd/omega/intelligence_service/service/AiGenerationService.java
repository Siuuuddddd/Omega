package io.github.siuuuddddd.omega.intelligence_service.service;

import io.github.siuuuddddd.omega.intelligence_service.dto.chat.StreamResponse;
import reactor.core.publisher.Flux;

public interface AiGenerationService {
    Flux<StreamResponse> streamResponse(String message, Long projectId);
}
