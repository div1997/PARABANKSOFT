package configfileutills;

import constantutills.Frameworkconstant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class readconfigfile
{
    private readconfigfile() {}
    private static final Map<String, Object> mapconfig = new HashMap<>();
        private static Properties prop = new Properties();
    private static FileInputStream file = null;
        static
        {
            try {
                file = new FileInputStream(Frameworkconstant.getConfigfilepath());
                prop.load(file);
                for (Object key : prop.keySet())
                {
                        mapconfig.put(String.valueOf(key),
                        String.valueOf(prop.get(key)));

                }

            } catch (FileNotFoundException e)
            {
                System.exit(0);
                throw new RuntimeException("file not found on location");

            } catch (IOException e)
            {
                System.exit(0);
                throw new RuntimeException( "file input is incorrect");
            }

        }
        public static String getvalueofconfigfile (String name)
            {
                if(Objects.isNull(prop.getProperty(name)) || Objects.isNull(name))
                {
                    throw  new RuntimeException("property name"+name+" is null");
                }
                return prop.getProperty(name);
            }

    }







