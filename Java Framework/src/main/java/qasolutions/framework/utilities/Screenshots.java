package qasolutions.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
    public static String takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);	
		String fileName = getFilePath();
		
		try {
			FileUtils.copyFile(file, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileName;
	}

	private static String getTimestamp() {
		return new SimpleDateFormat("HHmmssSSS").format(new Date());
	}
	
	private static String getFilePath() {
		return "/target/Screenshots/screenshot_" + getTimestamp() + ".png";
	}
}
