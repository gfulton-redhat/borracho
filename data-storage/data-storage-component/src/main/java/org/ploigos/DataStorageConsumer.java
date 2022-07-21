package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataStorageApiName;

public class DataStorageConsumer extends AbstractApiConsumer<DataStorageApiName, DataStorageConfiguration> {

    public DataStorageConsumer(DataStorageEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
