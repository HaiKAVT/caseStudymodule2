import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyLogin {
    static Scanner scanner = new Scanner(System.in);
    //    static ArrayList<User> list = new ArrayList<>();
    static User temp;

    public static User getTemp() {
        return temp;
    }

    public static void menu() throws IOException, ClassNotFoundException {
        while (true) {
            try {
                System.out.println("--------Welcome--------");
                System.out.println("|  1. đăng nhập       |");
                System.out.println("|  2. đăng ký         |");
                System.out.println("|  Chọn để tiếp tục:  |");
                System.out.println("_______________________");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        login();
                        break;
                    case 2:
                        signUp();
                        break;
                }
            } catch (Exception ex) {
                System.out.println("nhấn 1 hoặc 2");
            }
        }
    }


    public static void login() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("----------------------");
            System.out.println("Nhập tên đăng nhập: ");
            String userName = scanner.nextLine();
            System.out.println("Nhập mật khẩu : ");
            String password = scanner.nextLine();
            System.out.println("___________________________________________________________________");
            ManagerLogin.readFileLogin();
            for (User lg : ManagerLogin.users) {
                if (lg.getUserName().equalsIgnoreCase(userName) && lg.getPassWord().equals(password)) {
                    System.out.println("------------------------------Welcom " + userName + " -------------------------- ");
                    temp = lg;
                    MenuQLNV.menuNV();
                    return;
                }
            }
            System.err.println("sai mật khẩu / tên đăng nhập");
        }
    }


    public static void signUp() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("-------------------");
            System.out.println("nhập tên đăng ký : ");
            String userName = scanner.nextLine();
            System.out.println("nhập mật khẩu : ");
            String password = scanner.nextLine();
            ManagerLogin.readFileLogin();
            for (User lg : ManagerLogin.users) {
                if (lg.getUserName().equals(userName)) {
                    System.err.println("tên này đã tồn tại!!!");
                    return;
                }
            }

            System.out.println("đăng nhập để vào hệ thống");
            ManagerLogin.users.add(new User(userName, password));
            ManagerLogin.writeFileLogin();
            break;
        }
        login();
    }
}
