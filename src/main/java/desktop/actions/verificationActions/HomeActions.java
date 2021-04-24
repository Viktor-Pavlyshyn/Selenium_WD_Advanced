package desktop.actions.verificationActions;

import desktop.pages.HomePage;
import lombok.extern.log4j.Log4j2;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class HomeActions {
    private final HomePage homePage = new HomePage();

    public void verifyCurrentUrl(){
        assertThat(homePage.isPageOpen())
                .as("Wrong current Url.")
                .isTrue();
    }
}
