import java.io.IOException;
import java.util.Scanner;

public class MenuQLNV {
     static Scanner scanner = new Scanner(System.in);
    public static   void menuNV() throws IOException, ClassNotFoundException {
        ManagerNV nv = new ManagerNV("src/file.txt");

        while (true) {
            try {
                System.out.println("___________________________________________________________________");
                System.out.println("1.Thêm nhân viên                    | 10.Trở Lại đăng nhập        |");
                System.out.println("2.Cập nhật nhân viên                | 11.Show tài khoản người dùng|");
                System.out.println("3.Chỉnh sửa trạng thái nhân viên    |11. Thoát                    |");
                System.out.println("4.Tìm kiếm nhân viên                                              |");
                System.out.println("5.Kiểm tra trạng thái nhân viên                                   |");
                System.out.println("6.Xóa nhân viên                                                   |");
                System.out.println("7. Hiển thị nhân viên theo loại                                   |");
                System.out.println("8.Hiển thị nhân viên theo trạng thái                              |");
                System.out.println("9.Hiện thị thông tin nhân viên                                    |");
                System.out.println("__________________________________________________________________|");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("1.thêm nhân viên fullTime");
                        System.out.println("2.thêm nhân viên partTime");
                        int choose = Integer.parseInt(scanner.nextLine());

                        if (choose == 1) {
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
            }catch (Exception ex){
                System.out.println("hãy nhập một số để lựa chọn");
            }
        }
    }
}
