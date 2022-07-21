package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataEvaluateApiCollection;
import org.ploigos.internal.DataEvaluateApiName;

@org.apache.camel.spi.annotations.Component("data-evaluate")
public class DataEvaluateComponent extends AbstractApiComponent<DataEvaluateApiName, DataEvaluateConfiguration, DataEvaluateApiCollection> {

    public DataEvaluateComponent() {
        super(DataEvaluateEndpoint.class, DataEvaluateApiName.class, DataEvaluateApiCollection.getCollection());
    }

    public DataEvaluateComponent(CamelContext context) {
        super(context, DataEvaluateEndpoint.class, DataEvaluateApiName.class, DataEvaluateApiCollection.getCollection());
    }

    @Override
    protected DataEvaluateApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataEvaluateApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataEvaluateApiName apiName,
                                      DataEvaluateConfiguration endpointConfiguration) {
        DataEvaluateEndpoint endpoint = new DataEvaluateEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataEvaluateConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
