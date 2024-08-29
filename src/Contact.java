public class Contact {
    private int id;
    private String  phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthDate;
    private String email;

    private static int idIncrement = 1;

    public Contact(String  phoneNumber, String group, String fullName, String gender, String address, String birthDate, String email) {
        this.id = idIncrement;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
        idIncrement += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Contact.idIncrement = idIncrement;
    }

    public Contact(int id, String phoneNumber, String group, String fullName, String gender, String address, String birthDate, String email) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id + '\'' +
                " Số điện thoại ='" + phoneNumber + '\'' +
                ", Nhóm ='" + group + '\'' +
                ", Họ và tên ='" + fullName + '\'' +
                ", Giới Tính ='" + gender + '\'' +
                ", Địa chỉ ='" + address + '\'' +
                ", Ngày sinh ='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
