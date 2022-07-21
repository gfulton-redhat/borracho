package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataStorageApiCollection;
import org.ploigos.internal.DataStorageApiName;

@org.apache.camel.spi.annotations.Component("data-storage")
public class DataStorageComponent extends AbstractApiComponent<DataStorageApiName, DataStorageConfiguration, DataStorageApiCollection> {

    public DataStorageComponent() {
        super(DataStorageEndpoint.class, DataStorageApiName.class, DataStorageApiCollection.getCollection());
    }

    public DataStorageComponent(CamelContext context) {
        super(context, DataStorageEndpoint.class, DataStorageApiName.class, DataStorageApiCollection.getCollection());
    }

    @Override
    protected DataStorageApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataStorageApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataStorageApiName apiName,
                                      DataStorageConfiguration endpointConfiguration) {
        DataStorageEndpoint endpoint = new DataStorageEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataStorageConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
