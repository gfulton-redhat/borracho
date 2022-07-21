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

import org.ploigos.api.DataSplitHello;
import org.ploigos.internal.DataSplitApiCollection;
import org.ploigos.internal.DataSplitApiName;
import org.ploigos.internal.DataSplitConstants;
import org.ploigos.internal.DataSplitPropertiesHelper;

/**
 * DataSplit component which does bla bla.
 *
 * TODO: Update one line description above what the component does.
 */
@UriEndpoint(firstVersion = "0.0.0-SNAPSHOT", scheme = "data-split", title = "DataSplit", syntax="data-split:name", 
             category = {Category.API})
public class DataSplitEndpoint extends AbstractApiEndpoint<DataSplitApiName, DataSplitConfiguration> {

    @UriPath @Metadata(required = true)
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public DataSplitEndpoint(String uri, DataSplitComponent component,
                         DataSplitApiName apiName, String methodName, DataSplitConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, DataSplitApiCollection.getCollection().getHelper(apiName), endpointConfiguration);
    }

    public Producer createProducer() throws Exception {
        return new DataSplitProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final DataSplitConsumer consumer = new DataSplitConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<DataSplitConfiguration> getPropertiesHelper() {
        return DataSplitPropertiesHelper.getHelper(getCamelContext());
    }

    protected String getThreadProfileName() {
        return DataSplitConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO:
                apiProxy = new DataSplitHello();
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
