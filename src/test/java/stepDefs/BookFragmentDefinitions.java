package stepDefs;

import desktop.fragments.BookTableFragment;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class BookFragmentDefinitions {

    @Then("verify author name - {string} in block - {string} with book - {string} and click add button")
    public void verifyAuthorAndAddToBasket(String name, String block, String book){
        BookTableFragment bookTableFragment = new BookTableFragment(block, book);
        String nameAuthor = bookTableFragment.getAuthorText();

        assertThat(nameAuthor)
                .as("Expected - {} but found - {}", name, nameAuthor)
                .isEqualTo(name);

        bookTableFragment.clickAddButton();
    }
}
