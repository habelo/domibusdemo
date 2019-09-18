package com.tdialog.domibusdemo.impl;

import backend.ecodex.org._1_1.SubmitRequest;
import backend.ecodex.org._1_1.SubmitResponse;
import com.tdialog.domibusdemo.Message;
import eu.domibus.plugin.Submission;
import eu.domibus.plugin.transformer.MessageRetrievalTransformer;
import org.w3._2003._05.soap_envelope.ObjectFactory;

public class RecieverTransformer implements MessageRetrievalTransformer<SubmitRequest> {


    @Override
    public SubmitRequest transformFromSubmission(Submission submission, SubmitRequest request) {
        return new SubmitRequest();
    }
}
