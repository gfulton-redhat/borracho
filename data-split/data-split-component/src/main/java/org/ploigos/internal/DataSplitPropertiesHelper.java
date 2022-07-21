package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataSplitConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataSplit component.
 */
public final class DataSplitPropertiesHelper extends ApiMethodPropertiesHelper<DataSplitConfiguration> {

    private static DataSplitPropertiesHelper helper;

    private DataSplitPropertiesHelper(CamelContext context) {
        super(context, DataSplitConfiguration.class, DataSplitConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataSplitPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataSplitPropertiesHelper(context);
        }
        return helper;
    }
}
