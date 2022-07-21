package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataQueryApiName;
import org.ploigos.internal.DataQueryPropertiesHelper;

public class DataQueryProducer extends AbstractApiProducer<DataQueryApiName, DataQueryConfiguration> {

    public DataQueryProducer(DataQueryEndpoint endpoint) {
        super(endpoint, DataQueryPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
