package gun05.Odev;

import org.openqa.selenium.By;

public class Locators {

   public static String ALL_CLICK_LOCATOR="//button[contains(.,\"{0}\")] | //input[@type='button' and contains(text(),\"{0}\")]";

   public static final
   By lusarName=By.xpath("//input[@placeholder='Username']");
   public static final
   By lpassword=By.xpath("//input[@placeholder='Password']");
   public static final
   By lsubmit=By.xpath("(//button[@type='submit'])[1]");


   public static final
By llAdminButton=By.xpath("//span[text()='Admin']");
   public static final
   By lAddButtun=By.xpath("//button[normalize-space()='Add']");
   public static final
   By lUserRole=By.xpath("//div[@class='oxd-select-text-input']");
   public static final
   By lAdmin=By.xpath("//div[@role='option']//span[text()='Admin']");
   public static final
   By lstatus=By.xpath("(//div[@class='oxd-select-text-input'])[2]");
   public static final
   By lEnabled=By.xpath("//div[@role='listbox']//span[text()='Enabled']");
   public static final
   By lTypeForHint=By.xpath("//input[@placeholder='Type for hints...']");
   public static final
   String lEmployeeList="//div[@role='listbox']//*[contains(text(),\"{0}\")]";
   public static final
   By lUSarname=By.xpath("(//input[@autocomplete='off'])[1]");
   public static final
   By lpassword2=By.xpath("(//input[@type='password'])[1]");
   public static final
   By lpaswordConfirm=By.xpath("(//input[@type='password'])[2]");
   public static final
   By lSaveButton=By.xpath("(//button[normalize-space()='Save'])[1]");

   public static final By loutput=By.xpath("//p[@class='oxd-userdropdown-name']");
   public static final By llogout=By.xpath("//a[text()='Logout']");

  public static final
  By lUsarnameSearch=By.xpath("//div[contains(@class,'oxd-grid-4')][1]//input");
  public static
  String lList="//div[contains(text(),\"{0}\")]//ancestor::div[@role=\"row\"]//button[2]";

  public static final
  By lUsarnameChance=By.xpath("//div[@class=\"oxd-form-row\"]//input[contains(@class,'oxd-input oxd-input')]");

}
