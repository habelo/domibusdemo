package com.tdialog.domibusdemo.impl;

import com.tdialog.domibusdemo.Message;
import eu.domibus.plugin.Submission;
import eu.domibus.plugin.transformer.MessageRetrievalTransformer;
import org.w3._2003._05.soap_envelope.ObjectFactory;

public class RecieverTransformer implements MessageRetrievalTransformer<Message> {

    @Override
    public Message transformFromSubmission(Submission submission, Message m) {
        return new Message(submission.getMessageId(), submission.getFromRole(), submission.getToRole());
    }

}
