package org.ploigos;

import java.util.Map;

import org.apache.camel.Category;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriPath;
import org.apache.camel.support.component.AbstractApiEndpoint;
import org.apache.camel.support.component.ApiMethod;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.api.DataValidateHello;
import org.ploigos.internal.DataValidateApiCollection;
import org.ploigos.internal.DataValidateApiName;
import org.ploigos.internal.DataValidateConstants;
import org.ploigos.internal.DataValidatePropertiesHelper;

/**
 * DataValidate component which does bla bla.
 *
 * TODO: Update one line description above what the component does.
 */
@UriEndpoint(firstVersion = "0.0.0-SNAPSHOT", scheme = "data-validate", title = "DataValidate", syntax="data-validate:name", 
             category = {Category.API})
public class DataValidateEndpoint extends AbstractApiEndpoint<DataValidateApiName, DataValidateConfiguration> {

    @UriPath @Metadata(required = true)
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public DataValidateEndpoint(String uri, DataValidateComponent component,
                         DataValidateApiName apiName, String methodName, DataValidateConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, DataValidateApiCollection.getCollection().getHelper(apiName), endpointConfiguration);
    }

    public Producer createProducer() throws Exception {
        return new DataValidateProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final DataValidateConsumer consumer = new DataValidateConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<DataValidateConfiguration> getPropertiesHelper() {
        return DataValidatePropertiesHelper.getHelper(getCamelContext());
    }

    protected String getThreadProfileName() {
        return DataValidateConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO:
                apiProxy = new DataValidateHello();
                break;
            default:
                throw new IllegalArgumentException("Invalid API name " + apiName);
        }
    }

    @Override
    public Object getApiProxy(ApiMethod method, Map<String, Object> args) {
        return apiProxy;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
