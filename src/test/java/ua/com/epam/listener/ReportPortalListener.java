package ua.com.epam.listener;

import com.epam.reportportal.message.ReportPortalMessage;

import com.epam.reportportal.testng.ReportPortalTestNGListener;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;

import static ua.com.epam.driver.SingletonDriver.getDriver;

@Log4j
public class ReportPortalListener extends ReportPortalTestNGListener {

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = getDriver();
        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            ReportPortalMessage message = new ReportPortalMessage(srcFile, "test message for ReportPortal");
            log.error(message);
        }
    }
}
