package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentrepoerterNG {
	
	static ExtentReports extent;
	public static ExtentReports getreporterObject() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation");
		reporter.config().setDocumentTitle("TestResults");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		//Giving Tester Name 
		extent.setSystemInfo("Tester","santosh");
		return extent;
	}

}
