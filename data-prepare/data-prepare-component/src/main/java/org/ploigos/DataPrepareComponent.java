package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataPrepareApiCollection;
import org.ploigos.internal.DataPrepareApiName;

@org.apache.camel.spi.annotations.Component("data-prepare")
public class DataPrepareComponent extends AbstractApiComponent<DataPrepareApiName, DataPrepareConfiguration, DataPrepareApiCollection> {

    public DataPrepareComponent() {
        super(DataPrepareEndpoint.class, DataPrepareApiName.class, DataPrepareApiCollection.getCollection());
    }

    public DataPrepareComponent(CamelContext context) {
        super(context, DataPrepareEndpoint.class, DataPrepareApiName.class, DataPrepareApiCollection.getCollection());
    }

    @Override
    protected DataPrepareApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataPrepareApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataPrepareApiName apiName,
                                      DataPrepareConfiguration endpointConfiguration) {
        DataPrepareEndpoint endpoint = new DataPrepareEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataPrepareConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
