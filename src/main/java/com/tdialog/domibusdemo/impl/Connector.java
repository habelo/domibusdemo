package com.tdialog.domibusdemo.impl;

import eu.domibus.plugin.AbstractBackendConnector;
import eu.domibus.plugin.transformer.MessageRetrievalTransformer;
import eu.domibus.plugin.transformer.MessageSubmissionTransformer;

public class Connector extends AbstractBackendConnector {

    public Connector(String name) {
        super(name);
    }

    @Override
    public MessageSubmissionTransformer getMessageSubmissionTransformer() {
        return null;
    }

    @Override
    public MessageRetrievalTransformer getMessageRetrievalTransformer() {
        return new RecieverTransformer();
    }

    @Override
    public void messageSendFailed(String s) {

    }
}
