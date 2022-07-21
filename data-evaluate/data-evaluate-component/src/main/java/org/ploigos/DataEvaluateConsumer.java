package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataEvaluateApiName;

public class DataEvaluateConsumer extends AbstractApiConsumer<DataEvaluateApiName, DataEvaluateConfiguration> {

    public DataEvaluateConsumer(DataEvaluateEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
