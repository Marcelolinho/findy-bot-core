package com.mpp.integration.handler;

import com.mpp.domain.FindyEndpointSearch;
import org.springframework.integration.handler.AbstractReplyProducingMessageHandler;
import org.springframework.messaging.Message;

public abstract class AbstractFindyServiceHandler extends AbstractReplyProducingMessageHandler {

    @Override
    protected Message<FindyEndpointSearch> handleRequestMessage(Message<?> requestMessage) {
        return handle(requestMessage);
    }

    private Message<FindyEndpointSearch> handle(Message<?> requestMessage) {



        return getMessageBuilderFactory().withPayload(new FindyEndpointSearch()).build();
    }
}
