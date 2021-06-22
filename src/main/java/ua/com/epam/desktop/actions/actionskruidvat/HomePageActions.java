package ua.com.epam.desktop.actions.actionskruidvat;


import ua.com.epam.desktop.pages.kruidvat.HomePage;

public class HomePageActions {
    private final HomePage homePage = new HomePage();

    public void clickOnBasket(){
        homePage.clickOnBasket();
    }

    public void acceptAllPopup(){
        homePage.acceptAllPopup();
    }
}
