package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;
import java.util.List;

public class HomePage extends Utilities {

    @FindBy(css = "[class='card mt-4 top-card']")
    public List<WebElement> homePageCards;

    public void clickHomeCard(String cardName){
        for (WebElement homeCard: homePageCards) {
            if (homeCard.getText().contains(cardName)){
                clickElement(homeCard);
                return;
            }
        }
        Assert.fail("Could not find card: " + cardName);
    }
}