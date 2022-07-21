package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataTransformApiName;

public class DataTransformConsumer extends AbstractApiConsumer<DataTransformApiName, DataTransformConfiguration> {

    public DataTransformConsumer(DataTransformEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
