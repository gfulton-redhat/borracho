package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataEvaluateApiName;
import org.ploigos.internal.DataEvaluatePropertiesHelper;

public class DataEvaluateProducer extends AbstractApiProducer<DataEvaluateApiName, DataEvaluateConfiguration> {

    public DataEvaluateProducer(DataEvaluateEndpoint endpoint) {
        super(endpoint, DataEvaluatePropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
