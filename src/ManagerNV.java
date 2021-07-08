import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerNV {
    static Scanner scanner = new Scanner(System.in);
    private String nameFile;
    static ArrayList<NhanVien> nhanViens = new ArrayList<>();

    public ManagerNV(String nameFile) {
        this.nameFile = nameFile;
    }

    public static NhanVien create(String loaiNV) {

        int id = getID();
        String name = getName();
        int age = getAge();
        String gender = getGender();
        String phone = getPhone();
        String email = getEmail();
        String address = getAddress();
        float salary = getSalary();
        boolean status = isStatus();
        if (loaiNV == "NhanVienFullTime") {
            return new NhanVienFullTime(id, name, age, gender, phone, email, address, salary, status);
        } else {
            System.out.println("Nhập vào số giờ làm việc: ");
            int hourWork = Integer.parseInt(scanner.nextLine());
            return new NhanVienpartTime(id, name, age, gender, phone, email, address, salary, status, hourWork);
        }
    }

    public void addNV(String loaiNV) throws IOException, ClassNotFoundException {
        NhanVien nhanVien = create(loaiNV);
        nhanViens.add(nhanVien);
        save();
    }

    public void removeNV(){
        try {
            read();
            System.out.println("Nhập id nhân viên cần xóa : ");
            int id = Integer.parseInt(scanner.nextLine());
            int check = -1;
            for (int i = 0; i < nhanViens.size(); i++) {
                if (nhanViens.get(i).getId() == id) {
                    check = i;
                }
            }
            if (check < 0) {
                System.out.println("id vừa nhập ko tồn tại!!!");
            } else {
                nhanViens.remove(check);
            }
            save();
        }catch (Exception e){
            System.out.println("id phải là số!!!");
        }
    }

    public void findByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhập tên nhân viên cần tìm : ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println(" Tên Không có trong danh sách");
        } else {
            System.out.println(nhanViens.get(check));
        }
    }

    public void showByStatus() throws IOException, ClassNotFoundException {
        read();
        System.out.println("1.Danh sách nhân viên đang làm việc");
        System.out.println("2.Danh sách nhân viên đã nghỉ việc");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose == 1) {
            for (NhanVien nv : nhanViens) {
                if (nv.isStatus() == true) {
                    System.out.println(nv);
                }
            }
        } else {
            for (NhanVien nv : nhanViens) {
                if (nv.isStatus() == false) {
                    System.out.println(nv);
                }
            }
        }
    }

    public void checkStatus() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhập tên nhân viên cần kiểm tra trạng thái: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Tên này ko có trong danh sách nhân viên");
        } else {
            System.out.println("nhân viên " + nhanViens.get(check).getName() + " " + nhanViens.get(check).getStatus());
        }
    }

    public void editStatusByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhập tên nhân viên cần cập nhật trạng thái: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Tên không có trong danh sách");
        } else {
            if (nhanViens.get(check).isStatus() == true) {
                nhanViens.get(check).setStatus(false);
                System.out.println(nhanViens.get(check));
            } else {
                nhanViens.get(check).setStatus(true);
                System.out.println(nhanViens.get(check));
            }
        }
        save();
    }

    public void showByTypeNV() throws IOException, ClassNotFoundException {
        read();
        System.out.println("1. Danh sách nhân viên fullTime");
        System.out.println("2. Danh sách nhân viên partTime");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose == 1) {
            for (NhanVien nv : nhanViens) {
                if (nv instanceof NhanVienFullTime) {
                    System.out.println(nv);
                }
            }
        } else {
            for (NhanVien nv : nhanViens) {
                if (nv instanceof NhanVienpartTime) {
                    System.out.println(nv);
                }
            }

        }
    }

    public void editByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhập tên nhân viên cần cập nhật: ");
        String nameEd = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(nameEd)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Tên không có trong danh sách");
        } else {
            int id = getID();
            String name = getName();
            int age = getAge();
            String gender = getGender();
            String phone = getPhone();
            String email = getEmail();
            String address = getAddress();
            float salary = getSalary();
            boolean status = isStatus();
            nhanViens.get(check).setId(id);
            nhanViens.get(check).setName(name);
            nhanViens.get(check).setAge(age);
            nhanViens.get(check).setGender(gender);
            nhanViens.get(check).setPhone(phone);
            nhanViens.get(check).setEmail(email);
            nhanViens.get(check).setAddress(address);
            nhanViens.get(check).setSalary(salary);
            nhanViens.get(check).setStatus(status);
            if (nhanViens.get(check) instanceof NhanVienpartTime) {
                System.out.println("Nhập vào số giờ làm việc");
                int hourWork = Integer.parseInt(scanner.nextLine());
                ((NhanVienpartTime) nhanViens.get(check)).setHourWork(hourWork);
            }
        }
        save();
    }

    public void save() throws IOException {

        FileOutputStream fos = new FileOutputStream(nameFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(nhanViens);


    }

    public void read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nameFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        nhanViens = (ArrayList<NhanVien>) ois.readObject();

    }

    private static int getID() {
        while (true) {
            try {
                System.out.println("Nhập id");
                int id = Integer.parseInt(scanner.nextLine());
                for (NhanVien nv : nhanViens) {
                    if (nv.getId() == id) {
                        throw new Exception();
                    }
                }
                return id;
            } catch (Exception e) {
                System.out.println("id đã tồn tại!!!");
            }
        }
    }

    private static String getName() {
        String name;
        while (true) {
            System.out.println("Nhập tên ");
            name = scanner.nextLine();
            if (NameRegex.validate(name)) {
                return name;
            }
        }

    }

    private static int getAge() {
        while (true) {
            try {
                System.out.println("Nhập tuổi");
                int age = Integer.parseInt(scanner.nextLine());
                return age;
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }

    }

    private static String getGender() {
        while (true) {
            try {
                System.out.println("Nhập giới tính (Nam/Nu) : ");
                String gender = scanner.nextLine();
                if (GenderRegex.validate(gender)) {
                    return gender;
                }
            } catch (Exception e) {
                System.out.println("giới tính phải là nam / nu !!! mời nhập lại");
            }
        }
    }

    private static String getPhone() {
        System.out.println("Nhập số điện thoại");
        return scanner.nextLine();
    }

    private static String getEmail() {
        while (true) {
            try {
                System.out.println("Nhập email");
                String email = scanner.nextLine();
                for (NhanVien nv : nhanViens) {
                    if (nv.getEmail().equals(email) && email == "") {
                        throw new Exception();
                    }
                }
                return email;
            } catch (Exception e) {
                System.out.println("Email này đã tồn tại!! Mời nhâp lại");
            }
        }
    }

    private static String getAddress() {

        System.out.println("Nhập địa chỉ : ");
        return scanner.nextLine();
    }

    private static float getSalary() {
        while (true) {
            try {
                System.out.println("Nhập lương : ");
                return Float.parseFloat(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng, lương phải là một số");
            }
        }
    }

    private static boolean isStatus() {
        while (true) {
            try {
                System.out.println(" Nhập trạng thái(true / false) ");
                boolean status = false;
                String status1 = scanner.nextLine();
                if (status1.equals("true")) {
                    status = true;
                } else if (status1.equals("false")) {
                    status = false;
                } else {
                    throw new Exception();
                }
                return status;
            } catch (Exception e) {
                System.out.println("sai rồi!! nhập lại true / false");
            }
        }

    }

    public void showNV() throws IOException, ClassNotFoundException {
        read();
        for (NhanVien nv : nhanViens) {
            System.out.println(nv);
        }
    }

    public void showUser() {
        System.out.println(QuanLyLogin.getTemp());
    }
}
