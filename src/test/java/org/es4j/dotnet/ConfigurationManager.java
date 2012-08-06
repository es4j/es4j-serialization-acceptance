package org.es4j.dotnet;

import java.util.Map;

// Provides access to configuration files for client applications. 
// This class cannot be inherited.
public class ConfigurationManager {

    // Gets the System.Configuration.AppSettingsSection data for the current application's
    // default configuration.
    //
    // Returns:
    //     Returns a System.Collections.Specialized.NameValueCollection object that
    //     contains the contents of the System.Configuration.AppSettingsSection object
    //     for the current application's default configuration.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     Could not retrieve a System.Collections.Specialized.NameValueCollection object
    //     with the application settings data.
    public static NameValueCollection getAppSettings() { //{get; }
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Gets the System.Configuration.ConnectionStringsSection data for the current
    // application's default configuration.
    //
    // Returns:
    //     Returns a System.Configuration.ConnectionStringSettingsCollection object
    //     that contains the contents of the System.Configuration.ConnectionStringsSection
    //     object for the current application's default configuration.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     Could not retrieve a System.Configuration.ConnectionStringSettingsCollection
    //     object.
    public static ConnectionStringSettingsCollection getConnectionStrings() { // { get; }
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Summary:
    //     Retrieves a specified configuration section for the current application's
    //     default configuration.
    //
    // Parameters:
    //   sectionName:
    //     The configuration section path and name.
    //
    // Returns:
    //     The specified System.Configuration.ConfigurationSection object, or null if
    //     the section does not exist.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     A configuration file could not be loaded.
    //public static object GetSection(string sectionName);

    // Summary:
    //     Opens the configuration file for the current application as a System.Configuration.Configuration
    //     object.
    //
    // Parameters:
    //   userLevel:
    //     The System.Configuration.ConfigurationUserLevel for which you are opening
    //     the configuration.
    //
    // Returns:
    //     A System.Configuration.Configuration object.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     A configuration file could not be loaded.
    //public static Configuration OpenExeConfiguration(ConfigurationUserLevel userLevel);

    // Summary:
    //     Opens the specified client configuration file as a System.Configuration.Configuration
    //     object.
    //
    // Parameters:
    //   exePath:
    //     The path of the configuration file. The configuration file resides in the
    //     same directory as the executable file.
    //
    // Returns:
    //     A System.Configuration.Configuration object.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     A configuration file could not be loaded.
    //public static Configuration OpenExeConfiguration(string exePath);

    // Summary:
    //     Opens the machine configuration file on the current computer as a System.Configuration.Configuration
    //     object.
    //
    // Returns:
    //     A System.Configuration.Configuration object.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     A configuration file could not be loaded.
    //public static Configuration OpenMachineConfiguration();

    // Summary:
    //     Opens the specified client configuration file as a System.Configuration.Configuration
    //     object that uses the specified file mapping and user level.
    //
    // Parameters:
    //   fileMap:
    //     An System.Configuration.ExeConfigurationFileMap object that references configuration
    //     file to use instead of the application default configuration file.
    //
    //   userLevel:
    //     The System.Configuration.ConfigurationUserLevel object for which you are
    //     opening the configuration.
    //
    // Returns:
    //     A System.Configuration.Configuration object.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     A configuration file could not be loaded.
    //public static Configuration OpenMappedExeConfiguration(ExeConfigurationFileMap fileMap, ConfigurationUserLevel userLevel);

    // Summary:
    //     Opens the machine configuration file as a System.Configuration.Configuration
    //     object that uses the specified file mapping.
    //
    // Parameters:
    //   fileMap:
    //     An System.Configuration.ExeConfigurationFileMap object that references configuration
    //     file to use instead of the application default configuration file.
    //
    // Returns:
    //     A System.Configuration.Configuration object.
    //
    // Exceptions:
    //   System.Configuration.ConfigurationErrorsException:
    //     A configuration file could not be loaded.
    //public static Configuration OpenMappedMachineConfiguration(ConfigurationFileMap fileMap);

    // Summary:
    //     Refreshes the named section so the next time that it is retrieved it will
    //     be re-read from disk.
    //
    // Parameters:
    //   sectionName:
    //     The configuration section name or the configuration path and section name
    //     of the section to refresh.
    //public static void RefreshSection(string sectionName);
}