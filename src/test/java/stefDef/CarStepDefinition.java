package stefDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CarStepDefinition extends Hooks {
    Hooks hooks = new Hooks();
    Homepage homepage = new Homepage();
    GetCarRegistration getCarRegistration = new GetCarRegistration();
    List<String> carRegistrations;
    Map<String, List<String>> actualVehicleDetails = new HashMap<String, List<String>>();
    Map<String, List<String>> expectedVehicleDetails = new HashMap<String, List<String>>();
    Boolean isVehicleDetailsFound = false;

    @Given("User reads registration details from input file")
    public void userReadsRegistrationDetailsFromInputFile() throws Exception {
        String everything;
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/java/stefDef/car_input.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }
        carRegistrations = getCarRegistration.getCarRegistrations(everything);
    }

    @When("User retrieves vehicle details from cartaxcheck site and verifies details with outputfile")
    public void userRetrievesVehicleDetailsFromCartaxcheckSiteAndVerifiesDetailsWithOutputfile() throws Exception {
        readVehicleDetailsFromOutputFile();
        for(String carRegistration: carRegistrations){
           getVehicleDetailsFromCarTaxCheckSite(carRegistration);
           if(isVehicleDetailsFound) {
               assertVehicleDetails(carRegistration);
           }
        }
    }

    private void assertVehicleDetails(String reg) {
        if(expectedVehicleDetails.get(reg).equals(actualVehicleDetails.get(reg))) {
            System.out.println("Successfully verified vehicle details for "+reg);
        } else {
            System.out.println("Failed to verify vehicle details for " +reg);
        }
        System.out.println("Expected values: " +expectedVehicleDetails.get(reg));
        System.out.println("Actual values" +actualVehicleDetails.get(reg));
    }

    private void getVehicleDetailsFromCarTaxCheckSite(String reg) throws Exception {
        hooks.openBrowser();
        homepage.enterRegistrationno(reg);
        List<String> values = new ArrayList<String>();
        Thread.sleep(2000);
        try {
            if (driver.findElement(By.xpath("//*[@id='m']/div[2]/div[12]/div/div/dl/div/h5/span")).isDisplayed()) {
                System.out.println("Failed to find car details for " + reg);
                System.out.println(driver.findElement(By.xpath("//*[@id='m']/div[2]/div[12]/div/div/dl/div/h5/span")).getText());
                homepage.closeBrowser();
                return;
            }
        } catch (Exception e) {
        }
        Thread.sleep(2000);
        values.add(driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[2]/dd")).getText());
        Thread.sleep(2000);
        values.add(driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[3]/dd")).getText());
        Thread.sleep(2000);
        values.add(driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[4]/dd")).getText());
        Thread.sleep(2000);
        values.add(driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[5]/dd")).getText());
        actualVehicleDetails.put(reg, values);
        isVehicleDetailsFound = true;
        homepage.closeBrowser();
    }
    private void readVehicleDetailsFromOutputFile() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("src/test/java/stefDef/car_output.txt"));
        String line;
        while((line = in.readLine()) != null) {
            List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
            String key = items.get(0);
            List<String> values = new ArrayList<>();
            values.add(items.get(1));
            values.add(items.get(2));
            values.add(items.get(3));
            values.add(items.get(4));
            expectedVehicleDetails.put(key, values);
        }
        in.close();
    }

}