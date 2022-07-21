package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataQueryConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataQuery component.
 */
public final class DataQueryPropertiesHelper extends ApiMethodPropertiesHelper<DataQueryConfiguration> {

    private static DataQueryPropertiesHelper helper;

    private DataQueryPropertiesHelper(CamelContext context) {
        super(context, DataQueryConfiguration.class, DataQueryConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataQueryPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataQueryPropertiesHelper(context);
        }
        return helper;
    }
}
