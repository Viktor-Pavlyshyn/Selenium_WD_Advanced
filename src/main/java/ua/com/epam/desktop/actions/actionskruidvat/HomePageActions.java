package ua.com.epam.desktop.actions.actionskruidvat;

import lombok.extern.log4j.Log4j;
import ua.com.epam.desktop.pages.kruidvat.HomePage;

@Log4j
public class HomePageActions {
    private final HomePage homePage = new HomePage();

    public void clickOnBasket(){
        log.info("Click on basket");
        homePage.clickOnBasket();
    }

    public void acceptAllPopup(){
        log.info("Accept all popup");
        homePage.acceptAllPopup();
    }
}
