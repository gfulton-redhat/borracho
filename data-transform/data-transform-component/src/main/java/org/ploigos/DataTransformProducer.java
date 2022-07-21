package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataTransformApiName;
import org.ploigos.internal.DataTransformPropertiesHelper;

public class DataTransformProducer extends AbstractApiProducer<DataTransformApiName, DataTransformConfiguration> {

    public DataTransformProducer(DataTransformEndpoint endpoint) {
        super(endpoint, DataTransformPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
