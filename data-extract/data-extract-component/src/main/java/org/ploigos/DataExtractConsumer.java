package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataExtractApiName;

public class DataExtractConsumer extends AbstractApiConsumer<DataExtractApiName, DataExtractConfiguration> {

    public DataExtractConsumer(DataExtractEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
