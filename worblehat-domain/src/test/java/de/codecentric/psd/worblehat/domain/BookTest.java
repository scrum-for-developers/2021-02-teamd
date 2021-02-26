package de.codecentric.psd.worblehat.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

  Book BOOK;

  @BeforeEach
  public void setup() {
    BOOK = new Book("Titel", "Author", "2", "1", 1234);
  }

  @Test
  public void shouldReturnFalseWhenAuthorisDifferent() {
    Book anotherCopy =
        new Book(
            BOOK.getTitle(),
            BOOK.getAuthor(),
            BOOK.getEdition(),
            BOOK.getIsbn(),
            BOOK.getYearOfPublication());
    anotherCopy.setAuthor("Bene");
    assertThat(BOOK.isSameCopy(anotherCopy), is(false));
  }

  @Test
  public void shouldReturnFalseWhenTitleisDifferent() {
    Book anotherCopy =
        new Book(
            BOOK.getTitle(),
            BOOK.getAuthor(),
            BOOK.getEdition(),
            BOOK.getIsbn(),
            BOOK.getYearOfPublication());
    anotherCopy.setTitle("Lord of the Rings");
    assertThat(BOOK.isSameCopy(anotherCopy), is(false));
  }

  @Test
  public void shouldReturnTrueWhenAllButTitleAndAuthorAreDifferent() {
    Book anotherCopy =
        new Book(
            BOOK.getTitle(),
            BOOK.getAuthor(),
            BOOK.getEdition(),
            BOOK.getIsbn(),
            BOOK.getYearOfPublication());
    anotherCopy.setIsbn("123456789X");
    anotherCopy.setYearOfPublication(2010);
    assertThat(BOOK.isSameCopy(anotherCopy), is(true));
  }

  @Test
  public void shouldBeBorrowable() {
    BOOK.borrowNowByBorrower("a@bc.de");
    assertThat(BOOK.getBorrowing().getBorrowerEmailAddress(), is("a@bc.de"));
  }

  @Test
  public void shouldIgnoreNewBorrowWhenBorrowed() {
    BOOK.borrowNowByBorrower("a@bc.de");
    BOOK.borrowNowByBorrower("a@bc.ru");
    assertThat(BOOK.getBorrowing().getBorrowerEmailAddress(), is("a@bc.de"));
  }
}
