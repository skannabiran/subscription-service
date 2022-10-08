package com.maveric.techhub.subscription.mapper;

import com.maveric.techhub.subscription.entity.Subscribe;
import com.maveric.techhub.subscription.model.SubscriptionDTO;
import com.maveric.techhub.subscription.model.SubscriptionRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Subscribe toEntity(SubscriptionRequest request);
    SubscriptionDTO toDTO(Subscribe subscribe);

    List<SubscriptionDTO> toDTO(List<Subscribe> subscribes);

}
