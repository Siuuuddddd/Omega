package io.github.siuuuddddd.omega.common_lib.dto;

public record PlanDto(
        Long id,
        String name,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Boolean unlimitedAi,
        String price
) {
}