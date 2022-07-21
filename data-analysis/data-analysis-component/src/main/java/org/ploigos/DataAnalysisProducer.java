package org.ploigos;

import org.apache.camel.support.component.AbstractApiProducer;

import org.ploigos.internal.DataAnalysisApiName;
import org.ploigos.internal.DataAnalysisPropertiesHelper;

public class DataAnalysisProducer extends AbstractApiProducer<DataAnalysisApiName, DataAnalysisConfiguration> {

    public DataAnalysisProducer(DataAnalysisEndpoint endpoint) {
        super(endpoint, DataAnalysisPropertiesHelper.getHelper(endpoint.getCamelContext()));
    }
}
