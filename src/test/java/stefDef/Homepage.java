package stefDef;

import org.junit.Assert;
import org.openqa.selenium.By;

public class Homepage extends Hooks {
    public void enterRegistrationno(String registerno) throws Exception {
        //driver.findElement(By.id("")).sendKeys();
        driver.findElement(By.id("vrm-input")).sendKeys(registerno);
        Thread.sleep(2000);
        driver.findElement(By.className("jsx-1164392954")).click();
    }
    public boolean Registration( String Make, String model, String color,String year) throws Exception {
//        String REGISTRATION1 = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd")).getText();
//        System.out.println("registration number is>>>>>>>" + REGISTRATION1);
//        Assert.assertTrue(REGISTRATION1.equals(REGISTRATION));
Thread.sleep(2000);
        String Make1 = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[2]/dd")).getText();
        System.out.println("Car Make name is >>>>>>>" + Make1);
        Assert.assertTrue(Make1.equals(Make));
        Thread.sleep(2000);
        String model1 = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[3]/dd")).getText();
        System.out.println("Car Model number is>>>>>>>" + model1);
        Assert.assertTrue(model1.equals(model));
        Thread.sleep(2000);
        String color1 = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[4]/dd")).getText();
        System.out.println("Car Color is is>>>>>>>" + color1);
        Assert.assertTrue(color1.equals(color));
        Thread.sleep(2000);
        String year1 = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[5]/dd")).getText();
        System.out.println("Car Year is>>>>>>>" + year1);
        Assert.assertTrue(year1.equals(year));

 //| REGISTRATION | MAKE | MODEL   | COLOR | YEAR |

//        if( Stringreg_id =driver.findElement(By.cssSelector("//div[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd")).isDisplayed()){
//            System.out.println("Element is Visible"+ );
//        }else{
//            System.out.println("Element is InVisible");
//        }
        return true;
    }
}
