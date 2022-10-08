package com.maveric.techhub.subscription.service;

import com.maveric.techhub.subscription.entity.Subscribe;
import com.maveric.techhub.subscription.mapper.ProjectMapper;
import com.maveric.techhub.subscription.model.SubscriptionDTO;
import com.maveric.techhub.subscription.model.SubscriptionRequest;
import com.maveric.techhub.subscription.repository.SubscriptionRepository;
import com.maveric.techhub.subscription.exception.EntityNotFoundException;
import com.maveric.techhub.subscription.model.ServiceResponse;
import com.maveric.techhub.subscription.util.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ProjectMapper projectMapper;

    public ResponseEntity<ServiceResponse> createSubscription(SubscriptionRequest subscriptionRequest) {
        String title = subscriptionRequest.getSubscriberId();
        Optional<Subscribe> optionalIdea = subscriptionRepository.findBySubscriberId(title);
        if (!optionalIdea.isPresent()) {
            Subscribe subscribe = projectMapper.toEntity(subscriptionRequest);
            subscribe.setId(ServiceConstants._UUID());
            subscriptionRepository.save(subscribe);
            SubscriptionDTO subscriptionDTO = projectMapper.toDTO(subscribe);
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(ServiceResponse.builder().response(subscriptionDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_ALREADY_EXISTS, title));
    }

    public ResponseEntity<ServiceResponse> getSubscription(String id) {
        Optional<Subscribe> optionalUser = subscriptionRepository.findById(id);
        if (optionalUser.isPresent()) {
            Subscribe subscribe = optionalUser.get();
            SubscriptionDTO subscriptionDTO = projectMapper.toDTO(subscribe);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(subscriptionDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> updateSubscription(String id, SubscriptionRequest subscriptionRequest) {
        Optional<Subscribe> optionalUserDB = subscriptionRepository.findById(id);
        if (optionalUserDB.isPresent()) {
            Subscribe subscribeDB = optionalUserDB.get();
            Subscribe subscribe = projectMapper.toEntity(subscriptionRequest);
            subscribe.setId(subscribeDB.getId());
            subscriptionRepository.save(subscribe);
            SubscriptionDTO subscriptionDTO = projectMapper.toDTO(subscribe);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(subscriptionDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> deleteSubscription(String id) {
        Optional<Subscribe> optionalUser = subscriptionRepository.findById(id);
        if (optionalUser.isPresent()) {
            Subscribe subscribe = optionalUser.get();
            subscriptionRepository.delete(subscribe);
            ServiceResponse response = ServiceResponse.builder().
                    message(String.format(ServiceConstants.ENTITY_DELETED, id)).build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> getSubscriptions() {
        ServiceResponse response = ServiceResponse.builder().build();
        List<Subscribe> subscribes = subscriptionRepository.findAll();
        if (!subscribes.isEmpty()) {
            List<SubscriptionDTO> subscriptionDTOS = projectMapper.toDTO(subscribes);
            response.setResponse(subscriptionDTOS);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
