package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataValidateConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataValidate component.
 */
public final class DataValidatePropertiesHelper extends ApiMethodPropertiesHelper<DataValidateConfiguration> {

    private static DataValidatePropertiesHelper helper;

    private DataValidatePropertiesHelper(CamelContext context) {
        super(context, DataValidateConfiguration.class, DataValidateConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataValidatePropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataValidatePropertiesHelper(context);
        }
        return helper;
    }
}
