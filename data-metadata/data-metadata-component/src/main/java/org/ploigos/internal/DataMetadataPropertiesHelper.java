package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataMetadataConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataMetadata component.
 */
public final class DataMetadataPropertiesHelper extends ApiMethodPropertiesHelper<DataMetadataConfiguration> {

    private static DataMetadataPropertiesHelper helper;

    private DataMetadataPropertiesHelper(CamelContext context) {
        super(context, DataMetadataConfiguration.class, DataMetadataConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataMetadataPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataMetadataPropertiesHelper(context);
        }
        return helper;
    }
}
