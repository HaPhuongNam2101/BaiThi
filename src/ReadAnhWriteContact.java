import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAnhWriteContact {
    private File file = new File("database/contact.csv");
    public void WriteContact(List<Contact> contactList) {
        try {
            String data ="";
            for (Contact contact : contactList) {
                data +=  contact.getId() + ","
                        + contact.getPhoneNumber() + ","
                        + contact.getGroup() + ","
                        + contact.getFullName() + ","
                        + contact.getGender() + ","
                        + contact.getAddress() + ","
                        + contact.getBirthDate() + ","
                        + contact.getEmail() + "\n";
            }

            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }
    public List<Contact> readContacts() {
        List<Contact> contactList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    int id = Integer.parseInt(data[0]);
                    String phoneNumber= (data[1]);
                    String group = data[2];
                    String fullName = data[3];
                    String gender = data[4];
                    String address = data[5];
                    String birthDate = data[6];
                    String email = data[7];
                    Contact contact = new Contact(id,phoneNumber, group, fullName, gender, address, birthDate, email);
                    contactList.add(contact);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
        return contactList;
    }
}
