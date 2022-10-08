package com.maveric.techhub.subscription.util;

import java.util.UUID;

public class ServiceConstants {

    public static final String ID_IS_MANDATORY = "ID is mandatory";
    public static final String TECHNOLOGIES_IS_MANDATORY = "Technologies is mandatory";

    public static final String SUBSCRIBER_ID_IS_MANDATORY = "Subscriber Id is mandatory";

    public static final String DESCRIPTION_IS_MANDATORY = "Description is mandatory";

    public static final String CONTACT_PERSON_IS_MANDATORY = "Contact person is mandatory";

    public static final String ENTITY_ALREADY_EXISTS = "Entity already exists for the given parameter - [%s]";
    public static final String ENTITY_NOT_FOUND = "Entity not found for the given id - %s";

    public static final String ENTITY_DELETED = "Entity deleted for the given id - %s";
    public static String _UUID(){ return UUID.randomUUID().toString(); }
}
