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
        System.out.println("1. đăng nhập");
        System.out.println("2. đăng ký");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                login();
                MenuQLNV.menuNV();
                break;
            case 2:
                signUp();
                break;
        }
    }


    public static void login() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("nhap ten dang nhap: ");
            String userName = scanner.nextLine();
            System.out.println("nhap mat khau : ");
            String password = scanner.nextLine();
            ManagerLogin.readFileLogin();
            for (User lg : ManagerLogin.users) {
                if (lg.getUserName().equalsIgnoreCase(userName) && lg.getPassWord().equals(password)) {
                    System.out.println("Welcom " + userName);
                    temp = lg;
                    return;
                }
            }
            System.err.println("sai mật khẩu / tên đăng nhập");
        }
    }


    public static void signUp() throws IOException, ClassNotFoundException {
        while (true) {

            System.out.println("nhập tên : ");
            String userName = scanner.nextLine();
            System.out.println("nhập mật khẩu: ");
            String password = scanner.nextLine();
            for (User lg : ManagerLogin.users) {
                if (lg.getUserName().equals(userName)) {
                    System.err.println("tên này đã tồn tại!!!");
                    break;
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
