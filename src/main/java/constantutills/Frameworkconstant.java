package constantutills;

import lombok.Getter;

public class Frameworkconstant
{
    private static String configfilepath = System.getProperty("user.dir")+"//src//test//resources//base";
    public static String getConfigfilepath() {
        return configfilepath;
    }

    public static void setConfigfilepath(String configfilepath) {
        Frameworkconstant.configfilepath = configfilepath;
    }


}
