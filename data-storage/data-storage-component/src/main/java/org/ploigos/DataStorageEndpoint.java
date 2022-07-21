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

import org.ploigos.api.DataStorageHello;
import org.ploigos.internal.DataStorageApiCollection;
import org.ploigos.internal.DataStorageApiName;
import org.ploigos.internal.DataStorageConstants;
import org.ploigos.internal.DataStoragePropertiesHelper;

/**
 * DataStorage component which does bla bla.
 *
 * TODO: Update one line description above what the component does.
 */
@UriEndpoint(firstVersion = "0.0.0-SNAPSHOT", scheme = "data-storage", title = "DataStorage", syntax="data-storage:name", 
             category = {Category.API})
public class DataStorageEndpoint extends AbstractApiEndpoint<DataStorageApiName, DataStorageConfiguration> {

    @UriPath @Metadata(required = true)
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public DataStorageEndpoint(String uri, DataStorageComponent component,
                         DataStorageApiName apiName, String methodName, DataStorageConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, DataStorageApiCollection.getCollection().getHelper(apiName), endpointConfiguration);
    }

    public Producer createProducer() throws Exception {
        return new DataStorageProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final DataStorageConsumer consumer = new DataStorageConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<DataStorageConfiguration> getPropertiesHelper() {
        return DataStoragePropertiesHelper.getHelper(getCamelContext());
    }

    protected String getThreadProfileName() {
        return DataStorageConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO:
                apiProxy = new DataStorageHello();
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
