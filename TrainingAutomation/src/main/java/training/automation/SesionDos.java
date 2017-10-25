package training.automation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.*;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;

public class SesionDos {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@BeforeClass
	public void beforClass() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@BeforeGroups
	public void beforeGroups() {
		System.out.println("Before Groups");
	}

	@DataProvider(name = "nums")
	public Object[][] defineNums() {
		return new Object[][] { { 2, 4 }, { 8, 5 }, { 3, 9 } };
	}

	@DataProvider(name = "words")
	public Object[][] setWords() {
		return new Object[][] { { "I", "Love", "Automation" }, { "The", "Truly", "Tester" },
				{ "Tests", "With", "Hearth" }, { "QC", "Life", "Rules" } };
	}

	@Test(groups = { "Smoke", "Regression" }, dataProvider = "nums", priority = 1)
	public void multiplication(int n1, int n2) {
		int n = (n1 * n2);
	}

	@Test(groups = { "Smoke", "Regression" }, dataProvider = "words", priority = 2)
	public void concat(String w1, String w2, String w3) {
		String w = (w1 + " " + w2 + " " + w3);
	}

	@Parameters({ "date" })
	@Test(groups = { "Smoke" }, priority = 3)
	public void generateDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateformatted = formatter.parse(date);
			System.out.println("La fecha en formato String es: " + formatter.format(dateformatted));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Parameters({ "ambiente" })
	@Test(groups = { "Smoke" }, priority = 4)
	public void operacion(String ambiente) {
		Random random = new Random();
		int n;
		int n1 = random.nextInt(10) + 1;
		int n2 = random.nextInt(10) + 1;

		switch (ambiente) {
		case "AMBIENTE1":
			n = (n1 * n2);

			break;

		case "AMBIENTE2":
			n = (n1 - n2);
			break;

		default:
			System.out.println("Ingrese un ambiente Valido: \n -AMBIENTE1 \n -AMBIENTE2");
			break;
		}
	}

	@AfterGroups
	public void afterGroups() {
		System.out.println("After Groups");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
