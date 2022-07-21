package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataSplitApiName;

public class DataSplitConsumer extends AbstractApiConsumer<DataSplitApiName, DataSplitConfiguration> {

    public DataSplitConsumer(DataSplitEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
