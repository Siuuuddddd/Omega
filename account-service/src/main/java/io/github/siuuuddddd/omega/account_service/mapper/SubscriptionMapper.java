package io.github.siuuuddddd.omega.account_service.mapper;

import io.github.siuuuddddd.omega.account_service.dto.subscription.SubscriptionResponse;
import io.github.siuuuddddd.omega.account_service.entity.Plan;
import io.github.siuuuddddd.omega.account_service.entity.Subscription;
import io.github.siuuuddddd.omega.common_lib.dto.PlanDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanDto toPlanResponse(Plan plan);
}
