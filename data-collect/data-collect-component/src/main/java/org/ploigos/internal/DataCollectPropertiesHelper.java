package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataCollectConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataCollect component.
 */
public final class DataCollectPropertiesHelper extends ApiMethodPropertiesHelper<DataCollectConfiguration> {

    private static DataCollectPropertiesHelper helper;

    private DataCollectPropertiesHelper(CamelContext context) {
        super(context, DataCollectConfiguration.class, DataCollectConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataCollectPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataCollectPropertiesHelper(context);
        }
        return helper;
    }
}
