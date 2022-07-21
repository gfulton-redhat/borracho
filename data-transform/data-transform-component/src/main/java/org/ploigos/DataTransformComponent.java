package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataTransformApiCollection;
import org.ploigos.internal.DataTransformApiName;

@org.apache.camel.spi.annotations.Component("data-transform")
public class DataTransformComponent extends AbstractApiComponent<DataTransformApiName, DataTransformConfiguration, DataTransformApiCollection> {

    public DataTransformComponent() {
        super(DataTransformEndpoint.class, DataTransformApiName.class, DataTransformApiCollection.getCollection());
    }

    public DataTransformComponent(CamelContext context) {
        super(context, DataTransformEndpoint.class, DataTransformApiName.class, DataTransformApiCollection.getCollection());
    }

    @Override
    protected DataTransformApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataTransformApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataTransformApiName apiName,
                                      DataTransformConfiguration endpointConfiguration) {
        DataTransformEndpoint endpoint = new DataTransformEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataTransformConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
