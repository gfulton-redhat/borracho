package org.ploigos;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.support.IntrospectionSupport;
import org.junit.jupiter.api.TestInstance;

/**
 * Abstract base class for DataValidate Integration tests generated by Camel API component maven plugin.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractDataValidateTestSupport extends CamelTestSupport {

    private static final String TEST_OPTIONS_PROPERTIES = "/test-options.properties";

    @Override
    protected CamelContext createCamelContext() throws Exception {

        final CamelContext context = super.createCamelContext();

        // read DataValidate component configuration from TEST_OPTIONS_PROPERTIES
        final Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(TEST_OPTIONS_PROPERTIES));
        } catch (Exception e) {
            throw new IOException(String.format("%s could not be loaded: %s", TEST_OPTIONS_PROPERTIES, e.getMessage()),
                e);
        }

        Map<String, Object> options = new HashMap<String, Object>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            options.put(entry.getKey().toString(), entry.getValue());
        }

        final DataValidateConfiguration configuration = new DataValidateConfiguration();
        IntrospectionSupport.setProperties(configuration, options);

        // add DataValidateComponent to Camel context
        final DataValidateComponent component = new DataValidateComponent(context);
        component.setConfiguration(configuration);
        context.addComponent("data-validate", component);

        return context;
    }

    @SuppressWarnings("unchecked")
    protected <T> T requestBodyAndHeaders(String endpointUri, Object body, Map<String, Object> headers)
        throws CamelExecutionException {
        return (T) template().requestBodyAndHeaders(endpointUri, body, headers);
    }

    @SuppressWarnings("unchecked")
    protected <T> T requestBody(String endpoint, Object body) throws CamelExecutionException {
        return (T) template().requestBody(endpoint, body);
    }
}
