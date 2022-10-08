package com.maveric.techhub.subscription.model;

import com.maveric.techhub.subscription.util.ServiceConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubscriptionRequest {

    @NotBlank(message = ServiceConstants.SUBSCRIBER_ID_IS_MANDATORY)
    private String subscriberId;

}
