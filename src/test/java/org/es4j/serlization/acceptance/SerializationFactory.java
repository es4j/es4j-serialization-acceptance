package org.es4j.serlization.acceptance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.es4j.serialization.*;
import org.es4j.serialization.api.ISerialize;


public class SerializationFactory {

    private static final byte[] encryptionKey = new byte[] {
        0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x0
    };

    // virtual
    public ISerialize build() {
        /*
        Properties props = new Properties();  
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("app.properties");
        try {
            props.load(input );
        } catch (IOException ex) {
        }
        String serializer = props.getProperty("serializer", null);
        */
            /*        
            props.load(getServletContext().getResourceAsStream("/WEB-INF/filename.properties"));
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("filename.properties"));
            props.load(new FileInputStream("/absolute/path/to/filename.properties"));
            try {
                Enumeration<URL> en = getClass().getClassLoader().getResources("META-INF");
                if (en.hasMoreElements()) {
                    URL metaInf = en.nextElement();
                    File fileMetaInf = new File(metaInf.toURI());

                    File[] files = fileMetaInf.listFiles();
                    //or 
                    String[] filenames = fileMetaInf.list();
                }

            } catch (Exception ex) {
                Logger.getLogger(SerializationFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            */



        String serializer = ConfigurationExtensions.getSetting("serializer");
        switch (serializer) {
        case "Binary":           return new BinarySerializer();
        case "Gzip":             return new GzipSerializer(new BinarySerializer());
        case "Rijndael":         return new RijndaelSerializer(new BinarySerializer(), encryptionKey);
        case "Json":             return new JsonSerializer();
        case "Bson":             return new BsonSerializer();
        case "ServiceStackJson": return new JsonSerializer();
        default:                 throw  new UnsupportedOperationException("The configured serializer is not registered with the SerializationFactory.");
        }
    }
}