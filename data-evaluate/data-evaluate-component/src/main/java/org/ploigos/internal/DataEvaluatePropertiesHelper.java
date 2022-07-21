package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataEvaluateConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataEvaluate component.
 */
public final class DataEvaluatePropertiesHelper extends ApiMethodPropertiesHelper<DataEvaluateConfiguration> {

    private static DataEvaluatePropertiesHelper helper;

    private DataEvaluatePropertiesHelper(CamelContext context) {
        super(context, DataEvaluateConfiguration.class, DataEvaluateConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataEvaluatePropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataEvaluatePropertiesHelper(context);
        }
        return helper;
    }
}
