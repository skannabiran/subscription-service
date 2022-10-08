package com.maveric.techhub.subscription.controller;
import com.maveric.techhub.subscription.model.SubscriptionRequest;
import com.maveric.techhub.subscription.model.ServiceResponse;
import com.maveric.techhub.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * SubscriptionController is the class to manage for employee subscriptions
 * @author      Kannabiran Shanmugam
 * @version     %I%, %G%
 * @since       1.0
 */
@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    ResponseEntity<ServiceResponse> createSubscription(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.createSubscription(subscriptionRequest);
    }

    @GetMapping("/{id}")
    ResponseEntity<ServiceResponse> getSubscription(@PathVariable(name = "id") String id) {
        return subscriptionService.getSubscription(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<ServiceResponse> updateSubscription(@PathVariable(name = "id") String id,
                                            @RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.updateSubscription(id, subscriptionRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ServiceResponse> deleteSubscription(@PathVariable(name = "id") String id) {
        return subscriptionService.deleteSubscription(id);
    }

    @GetMapping
    ResponseEntity<ServiceResponse> getSubscriptions() {
        return subscriptionService.getSubscriptions();
    }

}