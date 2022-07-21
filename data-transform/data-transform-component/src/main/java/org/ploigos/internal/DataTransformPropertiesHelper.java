package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataTransformConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataTransform component.
 */
public final class DataTransformPropertiesHelper extends ApiMethodPropertiesHelper<DataTransformConfiguration> {

    private static DataTransformPropertiesHelper helper;

    private DataTransformPropertiesHelper(CamelContext context) {
        super(context, DataTransformConfiguration.class, DataTransformConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataTransformPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataTransformPropertiesHelper(context);
        }
        return helper;
    }
}
