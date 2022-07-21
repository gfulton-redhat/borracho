package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataCleanConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataClean component.
 */
public final class DataCleanPropertiesHelper extends ApiMethodPropertiesHelper<DataCleanConfiguration> {

    private static DataCleanPropertiesHelper helper;

    private DataCleanPropertiesHelper(CamelContext context) {
        super(context, DataCleanConfiguration.class, DataCleanConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataCleanPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataCleanPropertiesHelper(context);
        }
        return helper;
    }
}
