package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    private static final String FOLDER_PATH = "/Users/andreikulagin/IdeaProjects/aqa_project/src/test/java/tests/screenshots";

    public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTime = dateFormat.format(new Date());
        String fileName = screenshotName + "_" + dateTime + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationPath = new File(FOLDER_PATH + File.separator + fileName);
        FileUtils.copyFile(screenshot, destinationPath);
        System.out.println("Screenshot saved: " + destinationPath.getAbsolutePath());
    }
}