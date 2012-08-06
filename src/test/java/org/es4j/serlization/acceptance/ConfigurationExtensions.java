package org.es4j.serlization.acceptance;

//using System.Configuration;

import java.util.Map;
import java.util.Map.Entry;
import org.es4j.dotnet.ConfigurationManager;

//using System.Linq;

//internal static
public class ConfigurationExtensions {

    public static String getSetting(/*this*/ String settingName) {
        //return getCommandLineArgument("/" + settingName + ":")
	//			?? Environment.GetEnvironmentVariable(settingName)
	//			?? ConfigurationManager.AppSettings[settingName];
        String setting;
        setting = getCommandLineArgument("/" + settingName + ":");
        setting = (setting != null)? setting : System.getenv(settingName);
        setting = (setting != null)? setting : ConfigurationManager.getAppSettings().get(settingName, String.class);
        return setting;
    }

    private static String getCommandLineArgument(String settingName) {
        //return Environment.getCommandLineArgs()
	//			.Where(arg => arg.StartsWith(settingName))
	//			.Select(arg => arg.Replace(settingName, string.Empty))
	//			.FirstOrDefault();

        Map<String, String> variables = System.getenv();
        return variables.containsKey(settingName)? variables.get(settingName) : "";
    }

}