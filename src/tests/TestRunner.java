package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

//This class can be used to run all unit tests together
public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestSuite.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
   }
}  	