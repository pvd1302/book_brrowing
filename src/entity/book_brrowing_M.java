package entity;

public class book_brrowing_M {
    private Reader reader;
    private Book book;

    private book_brrowing_D ctms;
    private book_brrowing_D[] bookbrrowingDS;


    public book_brrowing_D getChiTietMuonSach(){
        return ctms;
    }

    public Book getSach(){
        return book;
    }

    public Reader getBandoc(){
        return reader;
    }


    public void setBandoc(Reader reader){
        this.reader = reader;
    }

    public book_brrowing_D[] getChitietmuonsach(){
        return bookbrrowingDS;
    }
    public void setChitietmuonsach(book_brrowing_D[] bookbrrowingDS){
        this.bookbrrowingDS = bookbrrowingDS;
    }
}
