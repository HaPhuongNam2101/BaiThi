import java.util.List;
import java.util.Scanner;

public class ContactMenu {
    private static ContactManager contactManager = new ContactManager();

    public ContactMenu() {
        int choice;
        do {
            System.out.println("===== Chương trình quản lý danh bạ ===== ");
            System.out.println("1. Xem danh sách ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhập ");
            System.out.println("4. Xóa ");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Đọc từ file ");
            System.out.println("7. Ghi vào file ");
            System.out.println("0. Thoát ");
            System.out.println("Vui lòng nhập lựa chọn ");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    showAllContacts();
                    break;
                case 2:
                    showAddContacts();
                    break;
                case 3:
                    showUpdateContact();
                    break;
                case 4:
                    showDeleteContact();
                    break;
                case 5:
                    showSearchContact();
                    break;
                case 6:
                    readFromFile();
                    break;
                case 7:
                    writeToFile();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn ");
            }
        } while (choice != 0);
    }


        private static void showAddContacts() {
            System.out.println("===== Thêm mới liên lạc =====");
            System.out.print("Nhập số điện thoại: ");
            String phoneNumber = Input.inputstring();
            System.out.print("Nhập nhóm: ");
            String group = Input.inputstring();
            System.out.print("Nhập tên: ");
            String fullName = Input.inputstring();
            System.out.print("Nhập giới tính: ");
            String gender = Input.inputstring();
            System.out.print("Nhập địa chỉ: ");
            String address = Input.inputstring();
            System.out.print("Nhập ngày sinh: ");
            String birthDate = Input.inputstring();
            System.out.print("Nhập email: ");
            String email = Input.inputstring();

            Contact newContact = new Contact(phoneNumber, group, fullName, gender, address, birthDate, email);
            contactManager.add(newContact);
            System.out.println("Đã thêm liên lạc mới.");
    }
    private static void showAllContacts() {
        System.out.println("===== Danh sách liên lạc =====");
        List<Contact> contacts = contactManager.getAll();
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }
    private static void showUpdateContact() {
        System.out.println("===== Cập nhật liên lạc =====");
        System.out.print("Nhập ID liên lạc muốn cập nhật: ");
        int id = Input.inputnumber();
        int index = contactManager.findIndexById(id);
        if (index == -1) {
            System.out.println("Liên lạc không tồn tại.");
            return;
        }

        System.out.print("Nhập số điện thoại mới: ");
        String phoneNumber = Input.inputstring();
        System.out.print("Nhập nhóm mới: ");
        String group = Input.inputstring();
        System.out.print("Nhập tên mới: ");
        String fullName = Input.inputstring();
        System.out.print("Nhập giới tính mới: ");
        String gender = Input.inputstring();
        System.out.print("Nhập địa chỉ mới: ");
        String address = Input.inputstring();
        System.out.print("Nhập ngày sinh mới: ");
        String birthDate = Input.inputstring();
        System.out.print("Nhập email mới: ");
        String email = Input.inputstring();

        Contact newContact = new Contact(id, phoneNumber, group, fullName, gender, address, birthDate, email);
        contactManager.update(id, newContact);
        System.out.println("Cập nhật liên lạc thành công.");
    }
    private static void showDeleteContact() {
        System.out.println("===== Xóa liên lạc =====");
        System.out.print("Nhập ID liên lạc muốn xóa: ");
        int id = Input.inputnumber();
        int index = contactManager.findIndexById(id);
        if (index == -1) {
            System.out.println("Liên lạc không tồn tại.");
            return;
        }
        contactManager.delete(id);
        System.out.println("Xóa liên lạc thành công.");
    }
    private static void showSearchContact() {
        System.out.println("===== Tìm kiếm liên lạc =====");
        System.out.print("Nhập tên hoặc số điện thoại để tìm kiếm: ");
        String keyword = Input.inputstring();
        List<Contact> contacts = contactManager.getAll();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getFullName().contains(keyword) || String.valueOf(contact.getPhoneNumber()).contains(keyword)) {
                System.out.println(contact.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy liên lạc nào.");
        }
    }
    private static void readFromFile() {
        ReadAnhWriteContact readAnhWriteContact = new ReadAnhWriteContact();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cảnh báo: Đọc từ file sẽ xóa toàn bộ danh bạ hiện tại.");
        System.out.print("Bạn có chắc chắn muốn tiếp tục? (Y/N): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            try {
                List<Contact> contacts = readAnhWriteContact.readContacts();
                contactManager.getAll().clear();
                contactManager.addAll(contacts);
                System.out.println("Danh bạ đã được cập nhật từ file.");
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi khi đọc danh bạ từ file: " + e.getMessage());
            }
        } else {
            System.out.println("Quá trình đọc từ file đã bị hủy.");
        }
    }
    private static void writeToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cảnh báo: Ghi vào file sẽ cập nhật toàn bộ nội dung file.");
        System.out.print("Bạn có chắc chắn muốn tiếp tục? (Y/N): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            List<Contact> contacts = contactManager.getAll();
            ReadAnhWriteContact readAnhWriteContact = new ReadAnhWriteContact();
            try {
                readAnhWriteContact.WriteContact(contacts);
                System.out.println("Danh bạ đã được lưu vào file.");
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi khi lưu danh bạ vào file: " + e.getMessage());
            }
        } else {
            System.out.println("Quá trình lưu vào file đã bị hủy.");
        }
    }
}