package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataCleanApiName;
import org.ploigos.internal.DataCleanPropertiesHelper;

public class DataCleanProducer extends AbstractApiProducer<DataCleanApiName, DataCleanConfiguration> {

    public DataCleanProducer(DataCleanEndpoint endpoint) {
        super(endpoint, DataCleanPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
