package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataSplitApiName;
import org.ploigos.internal.DataSplitPropertiesHelper;

public class DataSplitProducer extends AbstractApiProducer<DataSplitApiName, DataSplitConfiguration> {

    public DataSplitProducer(DataSplitEndpoint endpoint) {
        super(endpoint, DataSplitPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
