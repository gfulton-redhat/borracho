package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataMetadataApiName;
import org.ploigos.internal.DataMetadataPropertiesHelper;

public class DataMetadataProducer extends AbstractApiProducer<DataMetadataApiName, DataMetadataConfiguration> {

    public DataMetadataProducer(DataMetadataEndpoint endpoint) {
        super(endpoint, DataMetadataPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
