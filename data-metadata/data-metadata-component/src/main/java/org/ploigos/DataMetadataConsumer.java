package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataMetadataApiName;

public class DataMetadataConsumer extends AbstractApiConsumer<DataMetadataApiName, DataMetadataConfiguration> {

    public DataMetadataConsumer(DataMetadataEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
