package org.ploigos;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import org.ploigos.internal.DataValidateApiCollection;
import org.ploigos.internal.DataValidateApiName;

@org.apache.camel.spi.annotations.Component("data-validate")
public class DataValidateComponent extends AbstractApiComponent<DataValidateApiName, DataValidateConfiguration, DataValidateApiCollection> {

    public DataValidateComponent() {
        super(DataValidateEndpoint.class, DataValidateApiName.class, DataValidateApiCollection.getCollection());
    }

    public DataValidateComponent(CamelContext context) {
        super(context, DataValidateEndpoint.class, DataValidateApiName.class, DataValidateApiCollection.getCollection());
    }

    @Override
    protected DataValidateApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return getCamelContext().getTypeConverter().convertTo(DataValidateApiName.class, apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, DataValidateApiName apiName,
                                      DataValidateConfiguration endpointConfiguration) {
        DataValidateEndpoint endpoint = new DataValidateEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(DataValidateConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
