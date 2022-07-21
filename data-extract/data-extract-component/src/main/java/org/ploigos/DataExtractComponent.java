package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataExtractApiCollection;
import org.ploigos.internal.DataExtractApiName;

@org.apache.camel.spi.annotations.Component("data-extract")
public class DataExtractComponent extends AbstractApiComponent<DataExtractApiName, DataExtractConfiguration, DataExtractApiCollection> {

    public DataExtractComponent() {
        super(DataExtractEndpoint.class, DataExtractApiName.class, DataExtractApiCollection.getCollection());
    }

    public DataExtractComponent(CamelContext context) {
        super(context, DataExtractEndpoint.class, DataExtractApiName.class, DataExtractApiCollection.getCollection());
    }

    @Override
    protected DataExtractApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataExtractApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataExtractApiName apiName,
                                      DataExtractConfiguration endpointConfiguration) {
        DataExtractEndpoint endpoint = new DataExtractEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataExtractConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
