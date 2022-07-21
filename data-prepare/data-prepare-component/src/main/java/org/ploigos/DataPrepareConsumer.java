package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataPrepareApiName;

public class DataPrepareConsumer extends AbstractApiConsumer<DataPrepareApiName, DataPrepareConfiguration> {

    public DataPrepareConsumer(DataPrepareEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
