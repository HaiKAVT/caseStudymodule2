import java.io.*;
import java.util.ArrayList;

public class ManagerLogin {
    static ArrayList<User> users = new ArrayList<>();


    public static  void writeFileLogin() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/login.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }

    public static void readFileLogin() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/login.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        users = (ArrayList<User>) ois.readObject();
    }

    public static void removeLogin(String nameLogin) throws IOException, ClassNotFoundException {
        readFileLogin();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(nameLogin)) {
                users.remove(i);
            }
        }
        writeFileLogin();
    }
}
