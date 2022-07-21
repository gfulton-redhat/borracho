package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataCleanApiName;

public class DataCleanConsumer extends AbstractApiConsumer<DataCleanApiName, DataCleanConfiguration> {

    public DataCleanConsumer(DataCleanEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
