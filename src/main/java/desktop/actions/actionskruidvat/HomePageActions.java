package desktop.actions.actionskruidvat;


import desktop.pages.kruidvat.HomePage;

public class HomePageActions {
    private final HomePage homePage = new HomePage();

    public void clickOnBasket(){
        homePage.clickOnBasket();
    }

    public void acceptAllPopup(){
        homePage.acceptAllPopup();
    }
}
