package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataPrepareConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataPrepare component.
 */
public final class DataPreparePropertiesHelper extends ApiMethodPropertiesHelper<DataPrepareConfiguration> {

    private static DataPreparePropertiesHelper helper;

    private DataPreparePropertiesHelper(CamelContext context) {
        super(context, DataPrepareConfiguration.class, DataPrepareConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataPreparePropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataPreparePropertiesHelper(context);
        }
        return helper;
    }
}
