package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("reports/ExtentReports.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String filePath) {
        File reportFile = new File(filePath);
        reportFile.getParentFile().mkdirs();

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFile);
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setReportName("NopCommerce Automation Report");
        reporter.config().setDocumentTitle("Automation Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Project", "NopCommerce Automation");
        extent.setSystemInfo("Tester", "Soumi Ghosh");

        return extent;
    }
}
