public class NhanVienpartTime extends  NhanVien{
    private int hourWork;

    public NhanVienpartTime(int hourWork) {
        this.hourWork = hourWork;
    }

    public NhanVienpartTime(int id, String name, int age, String gender, String phone,
                            String email, String address, float salary, boolean status, int hourWork) {
        super(id, name, age, gender, phone, email, address, salary, status);
        this.hourWork = hourWork;
    }

    public int getHourWork() {
        return hourWork;
    }

    public void setHourWork(int hourWork) {
        this.hourWork = hourWork;
    }

    @Override
    public float getTotalSalary() {
        return this.getSalary()*getHourWork();
    }

    @Override
    public String toString() {
        return "nhân viên partTime : " + super.toString() + ", giờ làm việc : " + hourWork +"h,"
                + " doanh thu: " + getTotalSalary() + "";
    }
}
