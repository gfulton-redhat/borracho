package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataQueryApiCollection;
import org.ploigos.internal.DataQueryApiName;

@org.apache.camel.spi.annotations.Component("data-query")
public class DataQueryComponent extends AbstractApiComponent<DataQueryApiName, DataQueryConfiguration, DataQueryApiCollection> {

    public DataQueryComponent() {
        super(DataQueryEndpoint.class, DataQueryApiName.class, DataQueryApiCollection.getCollection());
    }

    public DataQueryComponent(CamelContext context) {
        super(context, DataQueryEndpoint.class, DataQueryApiName.class, DataQueryApiCollection.getCollection());
    }

    @Override
    protected DataQueryApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataQueryApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataQueryApiName apiName,
                                      DataQueryConfiguration endpointConfiguration) {
        DataQueryEndpoint endpoint = new DataQueryEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataQueryConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
