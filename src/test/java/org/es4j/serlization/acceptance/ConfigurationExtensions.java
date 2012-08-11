package org.es4j.serlization.acceptance;

import org.es4j.dotnet.ConfigurationManager;
import org.es4j.util.CommandLineArguments;


public class ConfigurationExtensions {

    public static String getSetting(/*this*/ String settingName) {
        String setting = CommandLineArguments.instance().getFirstValue("-" + settingName + ":", null);
        setting = (setting != null)? setting : System.getenv(settingName);
        return (setting != null)? setting : ConfigurationManager.getAppSettings().getProperty(settingName, null);
    }
}
