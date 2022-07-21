package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataQueryApiName;

public class DataQueryConsumer extends AbstractApiConsumer<DataQueryApiName, DataQueryConfiguration> {

    public DataQueryConsumer(DataQueryEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
