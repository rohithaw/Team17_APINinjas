package lms.runner;
	
	import org.junit.runner.RunWith;
	import org.testng.annotations.DataProvider;
	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	import io.cucumber.junit.Cucumber;
		
	//@RunWith(Cucumber.class) //Junit execution

		@CucumberOptions(
				monochrome = false,  //console output formatting
				tags = "@ETEPositiveLMS", //tags from feature file
				features = {"src/test/resources/features"}, //location of feature files
				glue= {"lms.stepDefinitions","lms.hooks"}, //location of step definition files
				plugin = {"pretty", //For the Detailed output and generating reports.
							"html:target/Cucumber-Reports/Team17_APINinjas.html" ,
							"json:target/Cucumber-Reports/Team17_APINinjas.json" , 
							"junit:target/Cucumber-Reports/Team17_APINinjas.xml",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
						}
				) 


		public class TestRunner extends AbstractTestNGCucumberTests{
			
			@Override
		    @DataProvider(parallel = false)
		    public Object[][] scenarios() {
				
				return super.scenarios();
		    }
	}
	
