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

import org.ploigos.api.DataEvaluateHello;
import org.ploigos.internal.DataEvaluateApiCollection;
import org.ploigos.internal.DataEvaluateApiName;
import org.ploigos.internal.DataEvaluateConstants;
import org.ploigos.internal.DataEvaluatePropertiesHelper;

/**
 * DataEvaluate component which does bla bla.
 *
 * TODO: Update one line description above what the component does.
 */
@UriEndpoint(firstVersion = "0.0.0-SNAPSHOT", scheme = "data-evaluate", title = "DataEvaluate", syntax="data-evaluate:name", 
             category = {Category.API})
public class DataEvaluateEndpoint extends AbstractApiEndpoint<DataEvaluateApiName, DataEvaluateConfiguration> {

    @UriPath @Metadata(required = true)
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public DataEvaluateEndpoint(String uri, DataEvaluateComponent component,
                         DataEvaluateApiName apiName, String methodName, DataEvaluateConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, DataEvaluateApiCollection.getCollection().getHelper(apiName), endpointConfiguration);
    }

    public Producer createProducer() throws Exception {
        return new DataEvaluateProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final DataEvaluateConsumer consumer = new DataEvaluateConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<DataEvaluateConfiguration> getPropertiesHelper() {
        return DataEvaluatePropertiesHelper.getHelper(getCamelContext());
    }

    protected String getThreadProfileName() {
        return DataEvaluateConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO:
                apiProxy = new DataEvaluateHello();
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
