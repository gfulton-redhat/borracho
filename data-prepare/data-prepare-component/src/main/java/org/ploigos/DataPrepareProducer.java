package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataPrepareApiName;
import org.ploigos.internal.DataPreparePropertiesHelper;

public class DataPrepareProducer extends AbstractApiProducer<DataPrepareApiName, DataPrepareConfiguration> {

    public DataPrepareProducer(DataPrepareEndpoint endpoint) {
        super(endpoint, DataPreparePropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
