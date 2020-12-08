import java.util.List;

import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;

public class EasyContacts {

    private List<Contact> contacts;
    private List<Phone> phoneList;
    private List<Address> addressList;

    public static void main(String[] args) {
        System.out.println("Welcome to easycontacts using java collections");
        String line = "1,Krishnamoorthi,Thangavel,t.krishnamoorthi@gmail.com,,,,18/09/1984,~";
        String[] fieldValue = line.split("\\,");
        System.out.println("Fields:"+ fieldValue.length);
    }
}
