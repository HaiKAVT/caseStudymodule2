import java.io.Serializable;

public class NhanVien implements Serializable {
    private  int id;
    private String name;
    private  int age;
    private  String gender;
    private String phone;
    private  String email;
    private  String address;
    private float salary;
    private  float totalSalary;
    private  boolean status;

    public NhanVien() {
    }

    public NhanVien(int id, String name, int age, String gender, String phone, String email,
                    String address, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public boolean isStatus() {
        return status;
    }
public String getStatus(){
        String status=null;
        if(this.status==true){
            status="đang làm việc ";
        }else {
            status="đã nghỉ việc";
        }
        return status;
}
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", status=" + getStatus() ;
    }
}
