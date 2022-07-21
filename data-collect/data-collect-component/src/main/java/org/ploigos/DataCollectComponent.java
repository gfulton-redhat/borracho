package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataCollectApiCollection;
import org.ploigos.internal.DataCollectApiName;

@org.apache.camel.spi.annotations.Component("data-collect")
public class DataCollectComponent extends AbstractApiComponent<DataCollectApiName, DataCollectConfiguration, DataCollectApiCollection> {

    public DataCollectComponent() {
        super(DataCollectEndpoint.class, DataCollectApiName.class, DataCollectApiCollection.getCollection());
    }

    public DataCollectComponent(CamelContext context) {
        super(context, DataCollectEndpoint.class, DataCollectApiName.class, DataCollectApiCollection.getCollection());
    }

    @Override
    protected DataCollectApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataCollectApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataCollectApiName apiName,
                                      DataCollectConfiguration endpointConfiguration) {
        DataCollectEndpoint endpoint = new DataCollectEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataCollectConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
