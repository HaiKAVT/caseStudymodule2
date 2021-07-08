import java.io.IOException;
import java.util.Scanner;

public class MenuQLNV {
     static Scanner scanner = new Scanner(System.in);
    public static   void menuNV() throws IOException, ClassNotFoundException {
        ManagerNV nv = new ManagerNV("src/file.txt");

        while (true){
            System.out.println("___________________________________________________________________");
            System.out.println("1.Thêm nhân viên                    | 10.Tro lai dang nhap|"        );
            System.out.println("2.Cập nhật nhân viên                | 11.Show tài khoản người dùng|");
            System.out.println("3.EditForStatus                     |11. Thoát"                     );
            System.out.println("4.Find by Name                                                    |");
            System.out.println("5.Check for status                                                |");
            System.out.println("6.Remove nhan vien                                                |");
            System.out.println("7.Show nhan vien theo tung loai                                   |");
            System.out.println("8.Show nhan vien theo trạng thái                                   |");
            System.out.println("9.Show thong tin nhan vien                                        |");
            System.out.println("__________________________________________________________________|");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("1.thêm nhân viên fullTime");
                    System.out.println("2.thêm nhân viên partTime");
                    int choose = Integer.parseInt(scanner.nextLine());

                    if(choose == 1){
                        nv.addNV("NhanVienFullTime");
                    } else {
                        nv.addNV("NhanVienpartTime");
                    }
                    break;
                case 2:
                    nv.editByName();
                    break;
                case 3:
                    nv.editStatusByName();
                    break;
                case 4:
                    nv.findByName();
                    break;
                case 5:
                    nv.checkStatus();
                    break;
                case 6:
                    nv.removeNV();
                    break;
                case 7:
                    nv.showByTypeNV();
                    break;
                case 8:
                    nv.showByStatus();
                    break;
                case 9:
                    nv.showNV();
                    break;
                case 10:
                    QuanLyLogin.menu();
                    break;
                case 11:
                    nv.showUser();
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập sai!!!!");
            }
        }
    }
}
