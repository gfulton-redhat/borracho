package org.ploigos;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import org.ploigos.internal.DataAnalysisApiName;

public class DataAnalysisConsumer extends AbstractApiConsumer<DataAnalysisApiName, DataAnalysisConfiguration> {

    public DataAnalysisConsumer(DataAnalysisEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
