package fr.epita.assistants.myebook;

public class EBookReader implements Readable, Paginated, Updatable{
    public EBook eBook;
    private double version;

    public EBookReader(){
        eBook = null;
        version = 1.0;
    }

    void openEbook(EBook ebook){
        eBook = ebook;
    }

    public String readCurrentPage(){
        if (eBook == null)
            return null;
        return eBook.pages.get(eBook.getCurrentPage());
    }

    public void openToPage(int page){
        eBook.openToPage(page);
    }
    public int getCurrentPage(){
        if (eBook == null)
            return -1;
        return eBook.getCurrentPage();
    }

    public int getPageCount(){
        if (eBook == null)
            return -1;
        return eBook.getPageCount();
    }

    @Override
    public double getVersion() {
        return version;
    }

    @Override
    public void update(double version) {
        if (version > this.version){
            this.version = version;
        }
    }
}
