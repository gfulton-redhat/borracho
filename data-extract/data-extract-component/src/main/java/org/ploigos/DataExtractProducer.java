package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataExtractApiName;
import org.ploigos.internal.DataExtractPropertiesHelper;

public class DataExtractProducer extends AbstractApiProducer<DataExtractApiName, DataExtractConfiguration> {

    public DataExtractProducer(DataExtractEndpoint endpoint) {
        super(endpoint, DataExtractPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
