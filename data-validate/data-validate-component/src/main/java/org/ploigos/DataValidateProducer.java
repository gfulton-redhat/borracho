package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataValidateApiName;
import org.ploigos.internal.DataValidatePropertiesHelper;

public class DataValidateProducer extends AbstractApiProducer<DataValidateApiName, DataValidateConfiguration> {

    public DataValidateProducer(DataValidateEndpoint endpoint) {
        super(endpoint, DataValidatePropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
