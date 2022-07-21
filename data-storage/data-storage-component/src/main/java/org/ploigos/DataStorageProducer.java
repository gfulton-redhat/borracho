package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataStorageApiName;
import org.ploigos.internal.DataStoragePropertiesHelper;

public class DataStorageProducer extends AbstractApiProducer<DataStorageApiName, DataStorageConfiguration> {

    public DataStorageProducer(DataStorageEndpoint endpoint) {
        super(endpoint, DataStoragePropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
