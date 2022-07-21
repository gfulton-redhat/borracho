package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataMetadataApiCollection;
import org.ploigos.internal.DataMetadataApiName;

@org.apache.camel.spi.annotations.Component("data-metadata")
public class DataMetadataComponent extends AbstractApiComponent<DataMetadataApiName, DataMetadataConfiguration, DataMetadataApiCollection> {

    public DataMetadataComponent() {
        super(DataMetadataEndpoint.class, DataMetadataApiName.class, DataMetadataApiCollection.getCollection());
    }

    public DataMetadataComponent(CamelContext context) {
        super(context, DataMetadataEndpoint.class, DataMetadataApiName.class, DataMetadataApiCollection.getCollection());
    }

    @Override
    protected DataMetadataApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataMetadataApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataMetadataApiName apiName,
                                      DataMetadataConfiguration endpointConfiguration) {
        DataMetadataEndpoint endpoint = new DataMetadataEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataMetadataConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
