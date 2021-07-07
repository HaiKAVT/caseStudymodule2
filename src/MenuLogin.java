import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MenuLogin {
    static String nameFile1;
    static String password1;
    static Scanner scanner = new Scanner(System.in);

    public static void start() throws IOException, ClassNotFoundException {
        File file = new File("login.txt");
        if (!file.exists()) {
            ManagerLogin.users.add(new User("new", "new"));
            ManagerLogin.writeFileLogin();
        }


            System.out.println("1.Đăng Nhập |");
            System.out.println("2.Đăng Ký  |");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 2) {
                ManagerLogin.readFileLogin();
                System.out.println("Nhập tên đăng nhập: ");
                String nameUser = scanner.nextLine();
                int check = -1;
                for (int i = 0; i < ManagerLogin.users.size(); i++) {
                    if (ManagerLogin.users.get(i).getUserName().equals(nameUser)) {
                        check = 1;
                    }
                }
                if (check > 0) {
                    System.out.println("Tài khoản đã tồn tại");
                } else {
                    System.out.println("Nhập mật khẩu:");
                    String passWord = scanner.nextLine();
                    User user = new User(nameUser, passWord);
                    ManagerLogin.users.add(user);
                    ManagerLogin.writeFileLogin();
                    nameFile1 = nameUser;
                    System.out.println("Welcom " + nameUser);
                    password1 = passWord;

                }
            } else {
                while (true) {
                    int check1=-1;
                    ManagerLogin.readFileLogin();
                    System.out.println("Nhập tên đăng nhập: ");
                    String nameUser = scanner.nextLine();
                    System.out.println("Nhập mật khẩu:");
                    String password = scanner.nextLine();
                    for (int i = 0; i < ManagerLogin.users.size(); i++) {
                        if (ManagerLogin.users.get(i).getUserName().equals(nameUser) && ManagerLogin.users.get(i).getPassWord().equals(password)) {
                            System.out.println("Welcom " + nameUser);
                            nameFile1 = nameUser;
                            password1 = password;
                            check1=1;
                            break;
                        }
                    }
                    if(check1>0){break;}
                    System.out.println("sai tên đăng nhập hoặc mật khẩu");
                }
            }
        }
    }

