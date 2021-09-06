package utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public abstract class Utilities extends Driver {

    public Utilities(){PageFactory.initElements(driver, this);}

    public void clickElement(WebElement element){waitUntilClickable(centerElement(element),System.currentTimeMillis()).click();}

    public void fillInput(WebElement inputBox, String inputText){centerElement(waitUntilVisible(inputBox,System.currentTimeMillis())).sendKeys(inputText);}

    public String getElementAttribute(WebElement element, String attributeName){return element.getAttribute(attributeName);}

    public WebElement centerElement(WebElement element){
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
        return element;
    }

    public WebElement waitUntilVisible(WebElement element, long initialTime){
        if (System.currentTimeMillis()-initialTime>15000)
            return null;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        }
        catch (StaleElementReferenceException | TimeoutException exception){
            exception.printStackTrace();
            return waitUntilVisible(element, initialTime);
        }
    }

    public WebElement waitUntilClickable(WebElement element, long initialTime){
        if (System.currentTimeMillis()-initialTime>30000)
            return null;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element;
        }
        catch (StaleElementReferenceException | TimeoutException exception){
            exception.printStackTrace();
            return waitUntilVisible(element, initialTime);
        }
    }

}