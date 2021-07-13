public class NhanVienFullTime  extends NhanVien{
    public NhanVienFullTime() {
    }

    public NhanVienFullTime(int id, String name, int age, String gender, String phone,
                            String email, String address, float salary, boolean status) {
        super(id, name, age, gender, phone, email, address, salary, status);
    }

    @Override
    public float getTotalSalary() {
        return this.getSalary()*10;
    }

    @Override
    public String toString() {
        return "nhân viên fulltime : " +  super.toString() +" ,doanh thu: " +  getTotalSalary() +"";
    }
}
