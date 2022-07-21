package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataCollectApiName;
import org.ploigos.internal.DataCollectPropertiesHelper;

public class DataCollectProducer extends AbstractApiProducer<DataCollectApiName, DataCollectConfiguration> {

    public DataCollectProducer(DataCollectEndpoint endpoint) {
        super(endpoint, DataCollectPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
