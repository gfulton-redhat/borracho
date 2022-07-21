package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataExtractConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataExtract component.
 */
public final class DataExtractPropertiesHelper extends ApiMethodPropertiesHelper<DataExtractConfiguration> {

    private static DataExtractPropertiesHelper helper;

    private DataExtractPropertiesHelper(CamelContext context) {
        super(context, DataExtractConfiguration.class, DataExtractConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataExtractPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataExtractPropertiesHelper(context);
        }
        return helper;
    }
}
