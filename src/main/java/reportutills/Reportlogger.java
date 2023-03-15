package reportutills;

import com.aventstack.extentreports.MediaEntityBuilder;
import screenshotutills.Image;

public final class Reportlogger
{
    private Reportlogger (){}

    public static void pass(String message)
    {
        Reportmanager.getreport().pass(message);
        Reportmanager.getreport().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(Image.getbase64image()).build());
    }
    public static void failed(String message)
    {
        Reportmanager.getreport().fail(message);
        Reportmanager.getreport().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(Image.getbase64image()).build());
    }
    public static void info(String message)
    {
        Reportmanager.getreport().info(message);
    }

    public static void assignauthor(String [] authors)
    {
        for(String author : authors)
        Reportmanager.getreport().assignAuthor(author);
    }

    public static void assigncategory(String [] categories)
    {
        for(String category : categories)
        {
            Reportmanager.getreport().assignCategory(category);
        }

    }
}
