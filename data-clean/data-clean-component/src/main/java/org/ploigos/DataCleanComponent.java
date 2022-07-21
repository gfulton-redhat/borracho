package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataCleanApiCollection;
import org.ploigos.internal.DataCleanApiName;

@org.apache.camel.spi.annotations.Component("data-clean")
public class DataCleanComponent extends AbstractApiComponent<DataCleanApiName, DataCleanConfiguration, DataCleanApiCollection> {

    public DataCleanComponent() {
        super(DataCleanEndpoint.class, DataCleanApiName.class, DataCleanApiCollection.getCollection());
    }

    public DataCleanComponent(CamelContext context) {
        super(context, DataCleanEndpoint.class, DataCleanApiName.class, DataCleanApiCollection.getCollection());
    }

    @Override
    protected DataCleanApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataCleanApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataCleanApiName apiName,
                                      DataCleanConfiguration endpointConfiguration) {
        DataCleanEndpoint endpoint = new DataCleanEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataCleanConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
