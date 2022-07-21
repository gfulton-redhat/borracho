package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataSplitApiCollection;
import org.ploigos.internal.DataSplitApiName;

@org.apache.camel.spi.annotations.Component("data-split")
public class DataSplitComponent extends AbstractApiComponent<DataSplitApiName, DataSplitConfiguration, DataSplitApiCollection> {

    public DataSplitComponent() {
        super(DataSplitEndpoint.class, DataSplitApiName.class, DataSplitApiCollection.getCollection());
    }

    public DataSplitComponent(CamelContext context) {
        super(context, DataSplitEndpoint.class, DataSplitApiName.class, DataSplitApiCollection.getCollection());
    }

    @Override
    protected DataSplitApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataSplitApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataSplitApiName apiName,
                                      DataSplitConfiguration endpointConfiguration) {
        DataSplitEndpoint endpoint = new DataSplitEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataSplitConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
