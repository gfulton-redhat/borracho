package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataValidateApiName;

public class DataValidateConsumer extends AbstractApiConsumer<DataValidateApiName, DataValidateConfiguration> {

    public DataValidateConsumer(DataValidateEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
