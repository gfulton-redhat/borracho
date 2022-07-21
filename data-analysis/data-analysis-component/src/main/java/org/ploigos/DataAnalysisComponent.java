package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataAnalysisApiCollection;
import org.ploigos.internal.DataAnalysisApiName;

@org.apache.camel.spi.annotations.Component("data-analysis")
public class DataAnalysisComponent extends AbstractApiComponent<DataAnalysisApiName, DataAnalysisConfiguration, DataAnalysisApiCollection> {

    public DataAnalysisComponent() {
        super(DataAnalysisEndpoint.class, DataAnalysisApiName.class, DataAnalysisApiCollection.getCollection());
    }

    public DataAnalysisComponent(CamelContext context) {
        super(context, DataAnalysisEndpoint.class, DataAnalysisApiName.class, DataAnalysisApiCollection.getCollection());
    }

    @Override
    protected DataAnalysisApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataAnalysisApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataAnalysisApiName apiName,
                                      DataAnalysisConfiguration endpointConfiguration) {
        DataAnalysisEndpoint endpoint = new DataAnalysisEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataAnalysisConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
