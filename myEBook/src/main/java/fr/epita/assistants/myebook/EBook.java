package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class EBook implements Editable, Paginated {
    private String name;
    public List<String> pages;
    private int currentPage;

    public EBook(String name) {
        this.name = name;
        pages = new ArrayList<>();
        pages.add("");
        currentPage = 0;
    }

    public String getName() {
        return name;
    }

    public Book print() {
        return new Book(name, pages);
    }

    public void writeCurrentPage(String pageText) {
        pages.set(currentPage, pageText);
    }

    public void addPage() {
        pages.add(currentPage + 1, "");
    }

    public void deletePage() {
        pages.remove(currentPage);
        if (pages.size() == 0) {
            pages.add("");
        }
    }

    @Override
    public void openToPage(int page) {
        if (0 <= page && page < pages.size()) {
            currentPage = page;
        }
    }

    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public int getPageCount() {
        return pages.size();
    }
}
