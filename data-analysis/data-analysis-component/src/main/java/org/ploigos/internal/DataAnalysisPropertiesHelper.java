package org.ploigos.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import org.ploigos.DataAnalysisConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for DataAnalysis component.
 */
public final class DataAnalysisPropertiesHelper extends ApiMethodPropertiesHelper<DataAnalysisConfiguration> {

    private static DataAnalysisPropertiesHelper helper;

    private DataAnalysisPropertiesHelper(CamelContext context) {
        super(context, DataAnalysisConfiguration.class, DataAnalysisConstants.PROPERTY_PREFIX);
    }

    public static synchronized DataAnalysisPropertiesHelper getHelper(CamelContext context) {
        if (helper == null) {
            helper = new DataAnalysisPropertiesHelper(context);
        }
        return helper;
    }
}
