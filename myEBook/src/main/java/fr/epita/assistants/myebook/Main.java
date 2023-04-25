package fr.epita.assistants.myebook;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args){
        EBook eBook = new EBook("Harry Potter");
        eBook.writeCurrentPage("This story is about a young wizard..");
        Book printedBook = eBook.print();
        assertEquals("This story is about a young wizard..", printedBook.readCurrentPage());
        EBookReader eBookReader = new EBookReader();
        eBookReader.openEbook(printedBook.scan());
        assertEquals("This story is about a young wizard..", eBookReader.readCurrentPage());
    }
}
