package com.smalaca.trainingdefinition.domain.training.events;

import java.util.UUID;

public record GuardiansSwitchedDomainEvent(
        // meta data EventId
        UUID trainingIdOne, UUID guardiansIdOneBefore, UUID guardiansIdOneAfter,
        UUID trainingIdTwo, UUID guardiansIdTwoBefore, UUID guardiansIdTwoAfter) {
}
