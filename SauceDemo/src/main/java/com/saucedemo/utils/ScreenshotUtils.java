package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils
{

    public static String takeScreenshot(WebDriver driver, String fileName)
    {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folder = System.getProperty("user.dir") + File.separator + "screenshots";
        String screenshotPath = folder + File.separator + fileName + "_" + timestamp + ".png";

        try {
           
            File dir = new File(folder);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            Files.copy(srcFile.toPath(), Path.of(screenshotPath), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
