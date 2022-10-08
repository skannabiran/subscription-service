package com.maveric.techhub.subscription.repository;

import com.maveric.techhub.subscription.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscribe, String> {

    Optional<Subscribe> findById(String Id);

    Optional<Subscribe> findBySubscriberId(String subscriberId);

}