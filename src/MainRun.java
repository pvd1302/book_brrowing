import entity.Reader;
import entity.book_brrowing_M;
import entity.Book;
import entity.book_brrowing_D;

import java.util.Scanner;

public class MainRun {

    Scanner sc=new Scanner(System.in);
    private static Reader[] Reader =new Reader[100];
    private static Book[] Books =new Book[100];
    private static book_brrowing_M[] QLMUONSACHES =new book_brrowing_M[100];
    private static book_brrowing_D[] bookbrrowingDS =new book_brrowing_D[100];

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        while (true){
            int functionChoice=functionChoice();
            switch (functionChoice){
                case 1:
                    NhapBandoc();
                    break;
                case 2:
                    HienthiBandoc();
                    break;
                case 3:
                    NhapDausach();
                    break;
                case 4:
                    HienthiDausach();
                    break;
                case 5:
                    createQLMuonsach();
                    showQlmuonsach();
                    break;
                case 6:
                    showQlmuonsach();
                    break;
                case 7:
                    sapXepPhieuMuon();
                    break;
                case 8:
                    timKiemTheoTen();
                    break;
                case 9:
                    System.out.println("Cảm ơn bạn đã xử dụng phần mềm của chúng tôi");
                    return;
            }

        }
    }

    private static int functionChoice(){
        Scanner sc=new Scanner(System.in);
        System.out.println("============= Chương trình quản lý thư viện ==============");
        System.out.println("1.Nhập danh sách bạn đọc");
        System.out.println("2.Hiển thị danh sách bạn đọc");
        System.out.println("3.Nhập đầu sách");
        System.out.println("4.Hiển thị danh sách đầu sách");
        System.out.println("5.Lập phiếu mượn cho bạn đọc");
        System.out.println("6.Hiển thị danh sách phiếu mượn");
        System.out.println("7.Sắp xếp danh sách theo tên");
        System.out.println("8.Tìm kiếm theo tên");
        System.out.println("9.Thoát");


        System.out.println("Xin mời nhập lựa chọn của bạn");
        int functionChoice=-1;
        do {
            functionChoice=sc.nextInt();
            if(functionChoice<9&&functionChoice>=1){
                break;
            }

        }while (functionChoice>9||functionChoice<1);
        return functionChoice;
    }

    private static void NhapBandoc(){
        //nhập khách hàng mới

        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số lượng bạn đọc muốn thêm:");
        int slbandoc=sc.nextInt();
        for (int i = 0; i < slbandoc; i++) {
            System.out.println("Nhập thông tin bạn đọc thứ "+(i+1));
            //nhập thông tin cho khách hàng
            Reader bd=new Reader();
            bd.nhapThongtinBandoc();
            //lưu thông tin khách hàng=> thêm vào mảng BANDOC
            LuuBandoc(bd);
        }

    }

    private static void LuuBandoc(Reader reader){
        for (int i = 0; i < Reader.length; i++) {
            if(Reader[i]==null){
                Reader[i]= reader;
                break;
            }
        }
    }

    private static void HienthiBandoc(){
        for (int i = 0; i < Reader.length; i++) {
            if(Reader[i]==null){
                continue;
            }
            System.out.println(Reader[i]);
        }
    }


    private static void NhapDausach(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng đầu sách muốn thêm:");
        int sldausach=sc.nextInt();
        for (int i = 0; i < sldausach; i++) {
            System.out.println("Nhập thông tin đầu sách thứ "+(i+1));
            Book book =new Book();
            book.nhapThongtinSach();
            LuuDausach(book);
        }
    }

    private static void LuuDausach(Book book){
        for (int i = 0; i < Books.length; i++) {
            if(Books[i]==null){
                Books[i]= book;
                break;
            }
        }
    }

    private static void HienthiDausach(){
        for (int i = 0; i < Books.length; i++) {
            if(Books[i]==null){
                continue;
            }
            System.out.println(Books[i]);
        }
    }


    private static void createQLMuonsach(){

        Scanner sc=new Scanner(System.in);
        if(!checkData()){
            System.out.println("Chưa có dữ liệu về người đọc hoặc đầu sách, vui lòng thêm dữ liệu.");
            return;
        }
        System.out.println("Nhập số lượng bạn đọc muốn mượn sách:");
        int slbandoc=sc.nextInt();
        for (int i = 0; i < slbandoc; i++) {
            book_brrowing_M qlms=new book_brrowing_M();
            Reader reader =nhapBandoc(i);

            qlms.setBandoc(reader);

            book_brrowing_D[] bookbrrowingDS = createChitietmuonsach();
            qlms.setChitietmuonsach(bookbrrowingDS);
            //lưu luôn vào danh sách quản lý mượn sách của thư viện.


            saveQLMS(qlms);


        }
    }

    private static void saveQLMS(book_brrowing_M qlms){
        for (int i = 0; i < QLMUONSACHES.length; i++) {
            if(QLMUONSACHES[i]==null){
                QLMUONSACHES[i]=qlms;
                return;
            }
        }
    }



    private static boolean checkData(){
        boolean coDulieunguoidoc=false;
        for (int i = 0; i < Reader.length; i++) {
            if(Reader[i]!=null){
                coDulieunguoidoc=true;
                break;
            }
        }
        boolean coDulieuSach=false;
        for (int i = 0; i < Books.length; i++) {
            if(Books[i]!=null){
                coDulieuSach=true;
                break;
            }
        }
        return coDulieunguoidoc&&coDulieuSach;
    }



    private static book_brrowing_D[] createChitietmuonsach(){
        System.out.println("Nhập số lượng đầu sách bạn đọc muốn mượn:");
        int sldausach;
        do {

            sldausach=new Scanner(System.in).nextInt();
            if(sldausach<5&&sldausach>=1){
                break;
            }
            System.out.println("Không được vượt quá 5 đầu sách");
        }while (true);
        book_brrowing_D[] bookbrrowingDS =new book_brrowing_D[sldausach];
        for (int i = 0; i < sldausach; i++) {
            book_brrowing_D chitietmuon=new book_brrowing_D();

            //xác định được xem bạn đọc muoons mượn sách nào
            //bắt bạn đọc nhập mã sách đầu sách muốn mượn
            Book book =nhapSach(i);
            //lưu đầu sách tìm được vào chi tiết đơn hàng(chi tiết mượn sách)
            chitietmuon.setSach(book);

            System.out.println("Nhập số lượng sách muốn mượn:");
            int quantity;
            do {
                quantity=new Scanner(System.in).nextInt();
                if(quantity>0&&quantity<=3){
                    break;
                }
                System.out.println("Không được mượn quá 3 sách");
            }while (true);

            chitietmuon.setQuantity(quantity);

            System.out.print("Tình trạng hiện thời của sach: ");
            String tinhtrang=new Scanner(System.in).nextLine();
            chitietmuon.setTinhtrang(tinhtrang);

            //lưu chi tiết sách vừa nhập
            for (int j = 0; j < bookbrrowingDS.length; j++) {
                if (bookbrrowingDS[i]==null){
                    bookbrrowingDS[i]=chitietmuon;
                    break;
                }
            }

        }
        return bookbrrowingDS;
    }

    private static Book nhapSach(int index){
        System.out.println("Xin mời nhập mã sách của đầu sách thứ "+(index+1)+"ma bạn đọc này muốn mượn:");
        int masach;
        Book book;
        do {
            masach=new Scanner(System.in).nextInt();
            book =searchSachbyid(masach);
            if(book !=null){
                break;

            }
            System.out.println("Không tồn tại mã sách có id là "+masach+",vui lòng nhập lại");
        }while (true);
        return book;
    }

    private static Reader nhapBandoc(int index){
        System.out.println("Nhập mã bạn đọc thứ"+(index+1)+"muốn mượn sách:");
        int maBandoc;
        Reader reader;
        do{
            maBandoc=new Scanner(System.in).nextInt();


            reader =searchBandocbyid(maBandoc);
            if(reader !=null){
                break;
            }
            System.out.println("Không tồn tại bạn đọc có mã là "+maBandoc+",vui lòng nhập lại");
        }while (true);
        return reader;
    }


    private static Reader searchBandocbyid(int maBandoc){
        for (int i = 0; i < Reader.length; i++) {
            Reader reader = Reader[i];
            if(reader !=null&& reader.getMaBandoc()==maBandoc){
                return reader;
            }

        }
        return null;
    }
    private static Book searchSachbyid(int maSach){
        for (int i = 0; i < Books.length; i++) {
            Book book = Books[i];
            if(book !=null&& book.getMasach()==maSach){
                return book;
            }
        }
        return null;
    }




    private static void sapXepPhieuMuon(){
        boolean coDulieuPhieuMuon=false;
        for (int i = 0; i < QLMUONSACHES.length ; i++) {
            if (QLMUONSACHES[i]!=null){
                coDulieuPhieuMuon=true;
            }
        }
        if (!coDulieuPhieuMuon){
            System.out.println("Chưa có phiếu mượn nào trong hệ thống, vui lòng tạo phiếu mượn trước khi thực hiện.");
            return;
        }

        sapXepDSTheoTen();
        //sắp xepps xong mới show
        showQlmuonsach();
    }

    private static void sapXepDSTheoTen(){
        for (int i = 0; i< QLMUONSACHES.length-1; i++){
            book_brrowing_M qlms1= QLMUONSACHES[i];
            for (int j = i+1; j < QLMUONSACHES.length ; j++) {
                book_brrowing_M qlms2= QLMUONSACHES[j];
                if(qlms2!=null){
                    if (qlms1.getBandoc().getHoten().compareTo(qlms2.getBandoc().getHoten())>0){
                        book_brrowing_M temp = qlms1;
                        QLMUONSACHES[i]= qlms2;
                        QLMUONSACHES[j]= temp;
                    }
                }else {
                    break;
                }

            }
        }
    }




    private static void showQlmuonsach(){
        for (int i = 0; i < QLMUONSACHES.length; i++) {
            book_brrowing_M qlms= QLMUONSACHES[i];
            if (qlms!=null){
                System.out.println("Bạn đọc "+qlms.getBandoc().getHoten()+" đã mượn các đầu sách sau:");
                for (int j = 0; j < qlms.getChitietmuonsach().length; j++) {
                    System.out.println(qlms.getChitietmuonsach()[j]);
                }
                System.out.println("--------------------------------");
            }
        }
    }

    private static void timKiemTheoTen(){
        System.out.println("Nhập tên bạn đọc mượn sách muốn tìm kiếm:");
        String name=new Scanner(System.in).nextLine();


        System.out.println("Danh sách bạn đọc mượn sách được tìm thấy:");

        for (int i = 0; i < QLMUONSACHES.length; i++) {
            book_brrowing_M qlms= QLMUONSACHES[i];


            if (qlms!=null){
                if (QLMUONSACHES[i].getBandoc().getHoten().toLowerCase().contains(name)==true){
                    System.out.println("Bạn đọc "+qlms.getBandoc().getHoten()+" đã mượn các đầu sách sau:");
                    for (int j = 0; j < qlms.getChitietmuonsach().length; j++) {
                        System.out.println(qlms.getChitietmuonsach()[j]);
                    }
                }

                System.out.println("--------------------------------");

//            if(QLMUONSACH[i]!=null){
//                if (QLMUONSACH[i].getBandoc().getHoten().toLowerCase().contains(name)==true){
//                    System.out.println(BANDOC[i]);
//                }
            }
        }
    }

    private static void sapXepDSTheoSLSachMuon() {
        for (int i = 0; i < bookbrrowingDS.length - 1; i++) {
            book_brrowing_D order1 = bookbrrowingDS[i];
            for (int j = i+1; j < bookbrrowingDS.length; j++) {
                book_brrowing_D order2 = bookbrrowingDS[j];
                if(order2!=null){
                    if (order1.getQuantity()<order2.getQuantity()){
                        book_brrowing_D temp = order1;
                        order1= order2;
                        order2= temp;
                    }
                }else {
                    break;
                }
            }
        }
    }

}

