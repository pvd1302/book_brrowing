package entity;

public class book_brrowing_D {

    private Book book;

    private int quantity;
    private String tinhtrang;

    public Book getSach() {
        return book;
    }

    public void setSach(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTinhtrang(String tinhtrang){
        this.tinhtrang=tinhtrang;
    }

    @Override
    public String toString() {
        return "Chitietmuonsach{" +
                "sach=" + book +
                ", quantity=" + quantity +
                ", tinhTrang=" + tinhtrang +
                '}';
    }

}
