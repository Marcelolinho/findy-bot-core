package com.mpp.integration.handler;

import com.mpp.domain.FindyEndpointSearch;
import org.springframework.messaging.Message;

public class FindyWebMotorsHandler extends AbstractFindyServiceHandler {

    @Override
    public Message<FindyEndpointSearch> handleGateway() {
        return null;
    }
}
