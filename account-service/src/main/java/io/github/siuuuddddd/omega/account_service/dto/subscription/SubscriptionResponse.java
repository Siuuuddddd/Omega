package io.github.siuuuddddd.omega.account_service.dto.subscription;

import io.github.siuuuddddd.omega.common_lib.dto.PlanDto;

import java.time.Instant;

public record SubscriptionResponse(
        PlanDto plan,
        String status,
        Instant currentPeriodEnd,
        Long tokensUsedThisCycle
) {
}
