package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataStorageConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataStorage component.
 */
public final class DataStoragePropertiesHelper extends ApiMethodPropertiesHelper<DataStorageConfiguration> {

    private static DataStoragePropertiesHelper helper;

    private DataStoragePropertiesHelper(CamelContext context) {
        super(context, DataStorageConfiguration.class, DataStorageConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataStoragePropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataStoragePropertiesHelper(context);
        }
        return helper;
    }
}
