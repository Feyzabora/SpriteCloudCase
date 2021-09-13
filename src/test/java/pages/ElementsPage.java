package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;
import java.util.List;

public class ElementsPage extends Utilities {

    @FindBy(css = "[class='btn btn-light ']")
    public List<WebElement> elementTypes;

    @FindBy(css = "[id=\"userName\"]")
    public WebElement nameInput;

    @FindBy(css = "[id=\"userEmail\"]")
    public WebElement emailInput;

    @FindBy(css = "[id=\"currentAddress\"]")
    public WebElement addressInput;

    @FindBy(css = "[id=\"permanentAddress\"]")
    public WebElement permanentAddressInput;

    @FindBy(css = "[id=\"submit\"]")
    public WebElement submitButton;

    @FindBy(css = "[id=\"name\"]")
    public WebElement nameOutput;

    @FindBy(css = "[id=\"email\"]")
    public WebElement emailOutput;

    @FindBy(css = "[id=\"currentAddress\"][class=\"mb-1\"]")
    public WebElement currentAddressOutput;

    @FindBy(css = "[id=\"permanentAddress\"][class=\"mb-1\"]")
    public WebElement permanentAddressOutput;

    @FindBy(css = "span[class='rct-checkbox']")
    public WebElement checkBox;

    public void verifyCheckboxToBe(WebElement checkBox, Boolean state){
        WebElement checkBoxSvg = checkBox.findElement(By.cssSelector("svg"));
        if (state)
            Assert.assertFalse(getElementAttribute(checkBoxSvg, "class").contains("uncheck"));
        else
            Assert.assertTrue(getElementAttribute(checkBoxSvg, "class").contains("uncheck"));

    }

    public void clickSubElement(String type){
        for (WebElement elementType: elementTypes) {
            if (elementType.getText().contains(type)){
                clickElement(elementType);
                return;
            }
        }
        Assert.fail("Could not find element type: " + type);
    }
    public void verifyNameOutput(String nameOutputText){
        if(nameOutput.getText().contains(nameOutputText)){
            System.out.println("Output is verified to be " + nameOutputText);
        }
        else Assert.fail("Could not verify name output.");
    }
    public void verifyEmailOutput(String emailOutputText){
        if(emailOutput.getText().contains(emailOutputText)){
            System.out.println("Output is verified to be " + emailOutputText);
        }
        else Assert.fail("Could not verify email output.");
    }
    public void verifyCurrentAddressOutput(String currentAddressOutputText){
        if(currentAddressOutput.getText().contains(currentAddressOutputText)){
            System.out.println("Output is verified to be " + currentAddressOutputText);
        }
        else Assert.fail("Could not verify current address output.");
    }
    public void verifyPermanentAddressOutput(String permanentAddressOutputText){
        if(permanentAddressOutput.getText().contains(permanentAddressOutputText)){
            System.out.println("Output is verified to be " + permanentAddressOutputText);
        }
        else Assert.fail("Could not verify permanent address output.");
    }
}
