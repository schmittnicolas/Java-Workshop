package fr.epita.assistants.myebook;

import java.util.List;

public class Book implements Paginated, Readable {

    private String name;
    private List<String> pages;
    private int currentPage;
    private int pageCount;

    protected Book(String name, List<String> pages) {
        this.name = name;
        this.pages = pages;
        currentPage = 0;
        pageCount = pages.size();
        if (pageCount == 0){
            pages.add("");
            pageCount += 1;
        }
    }

    public String getName(){
        return name;
    }

    public EBook scan(){
        EBook eBook =  new EBook(name);
        eBook.pages = this.pages;
        return  eBook;
    }

    public void openToPage(int Page) {
        if (0 <= Page && Page < pageCount) {
            currentPage = Page;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String readCurrentPage(){
        return pages.get(currentPage);
    }


}
