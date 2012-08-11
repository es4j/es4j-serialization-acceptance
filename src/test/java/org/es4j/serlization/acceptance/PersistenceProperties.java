package org.es4j.serlization.acceptance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PersistenceProperties {
    
    private static PersistenceProperties instance = null;
    
    private final String persistence;
    private final String host;
    private final String port;
    private final String database;
    private final String user;
    private final String password;
    private final int    pageSize;

    protected PersistenceProperties(){
        Properties props = new Properties();

        InputStream file ;
        try {
            file = new FileInputStream(new File("persistence.properties"));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        try {        
            props.load(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
            
        persistence = getString (props, "persistence", "MySqlPersistence");
        host        = getString (props, "host",        "localhost");
        port        = getString (props, "port",        "8080");
        database    = getString (props, "database",    "EventStore");
        user        = getString (props, "user",        "");
        password    = getString (props, "password",    "");
        pageSize    = getInteger(props, "pageSize",    10);
        
        try {
            file.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PersistenceProperties instance(){
        if (instance == null) {
            instance = new PersistenceProperties();
        }
        return instance;
    }
    
    protected final String getString(final Properties props, final String key, final String default_) {
        String value = props.getProperty(key);
        return value!=null? value : default_;
    }
    
    protected final int getInteger(final Properties props, final String key, final int default_) {
        String value = props.getProperty(key);
        return (value != null && !"".equals(value))? Integer.parseInt(value) : default_;
    }

    public String getPersistence() {
        return persistence;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getPageSize() {
        return pageSize;
    }
}


/*
         <!-- The value should be "Name" + Persistence, e.g. MongoPersistence, MySqlPersistence, SqlitePersistence, etc. -->
        <add key="persistence" value="MsSqlPersistence" />
        <add key="host"        value="localhost" />
        <add key="port"        value="8080" />
        <add key="database"    value="EventStore" />
        <add key="user"        value="" />
        <add key="password"    value="" />
        <add key="pageSize"    value="10" />
 */
