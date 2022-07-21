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

import org.ploigos.api.DataCleanHello;
import org.ploigos.internal.DataCleanApiCollection;
import org.ploigos.internal.DataCleanApiName;
import org.ploigos.internal.DataCleanConstants;
import org.ploigos.internal.DataCleanPropertiesHelper;

/**
 * DataClean component which does bla bla.
 *
 * TODO: Update one line description above what the component does.
 */
@UriEndpoint(firstVersion = "0.0.0-SNAPSHOT", scheme = "data-clean", title = "DataClean", syntax="data-clean:name", 
             category = {Category.API})
public class DataCleanEndpoint extends AbstractApiEndpoint<DataCleanApiName, DataCleanConfiguration> {

    @UriPath @Metadata(required = true)
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public DataCleanEndpoint(String uri, DataCleanComponent component,
                         DataCleanApiName apiName, String methodName, DataCleanConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, DataCleanApiCollection.getCollection().getHelper(apiName), endpointConfiguration);
    }

    public Producer createProducer() throws Exception {
        return new DataCleanProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final DataCleanConsumer consumer = new DataCleanConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<DataCleanConfiguration> getPropertiesHelper() {
        return DataCleanPropertiesHelper.getHelper(getCamelContext());
    }

    protected String getThreadProfileName() {
        return DataCleanConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO:
                apiProxy = new DataCleanHello();
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
