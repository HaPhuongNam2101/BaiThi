import java.util.ArrayList;
import java.util.List;

public class ContactManager implements IManager<Contact> {
        List<Contact> contacts;
        ReadAnhWriteContact readAnhWriteContact = new ReadAnhWriteContact();
        public ContactManager() {
            this.contacts = this.readAnhWriteContact.readContacts();
        }

    @Override
    public void add(Contact contact) {
            contacts.add(contact);
            readAnhWriteContact.WriteContact(contacts);

    }

    @Override
    public void update(int id, Contact contact) {
            int index = findIndexById(id);
            contacts.set(index, contact);
            readAnhWriteContact.WriteContact(contacts);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        contacts.remove(index);
        readAnhWriteContact.WriteContact(contacts);
    }

    @Override
    public List<Contact> getAll() {
        this.contacts = this.readAnhWriteContact.readContacts();
        return this.contacts;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < this.contacts.size(); i++) {
            if (contacts.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public void addAll(List<Contact> contacts) {
    }
}
