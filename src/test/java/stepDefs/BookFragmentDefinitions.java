package stepDefs;

import desktop.fragments.BookElement;
import desktop.fragments.BookTableFragment;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class BookFragmentDefinitions {

    @Then("verify that book - {string} in block - {string} have author - {string} and add to basket")
    public void verifyAuthorAndAddToBasket(String nameBook, String block, String author){
        BookTableFragment bookTableFragment = new BookTableFragment(block);
        BookElement book = bookTableFragment.getBookByName(nameBook);

        String nameAuthor = book.getAuthorText();

        assertThat(nameAuthor)
                .as("Expected - %s but found - %s.", author, nameAuthor)
                .isEqualTo(author);

        book.clickAddButton();
    }
}
