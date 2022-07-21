package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataCollectApiName;

public class DataCollectConsumer extends AbstractApiConsumer<DataCollectApiName, DataCollectConfiguration> {

    public DataCollectConsumer(DataCollectEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
