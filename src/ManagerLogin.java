import java.io.*;
import java.util.ArrayList;

public class ManagerLogin {
    static ArrayList<Login> logins = new ArrayList<>();


    public static  void writeFileLogin() throws IOException {
        FileOutputStream fos = new FileOutputStream("login.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(logins);
    }

    public static void readFileLogin() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("login.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        logins = (ArrayList<Login>) ois.readObject();
    }

    public static void removeLogin(String nameLogin) throws IOException, ClassNotFoundException {
        readFileLogin();
        for (int i = 0; i < logins.size(); i++) {
            if (logins.get(i).getUserName().equals(nameLogin)) {
                logins.remove(i);
            }
        }
        writeFileLogin();
    }
}
