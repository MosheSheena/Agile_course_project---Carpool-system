package Core.Storage;

import Core.Logic.Person;
import com.google.gson.Gson;
import org.bson.Document;

public class UserToDocumentAdapter extends ObjectToDocumentAdapter {
    private User u;

    public UserToDocumentAdapter(User u) {
        super(u);
    }

    @Override
    public Document adaptToDocument() {
        Document personDoc = personToDocumentAdapter(u.getPerson());

        return new Document("username", u.getUserName()).
                append("password", u.getPassword()).
                append("personalDetails", personDoc);
    }

    private Document personToDocumentAdapter(Person p) {
        return new Document("id", p.getId()).
                append("name", p.getName()).
                append("address", p.getAddress()).
                append("age", p.getAge()).
                append("city", p.getCity());
    }
}
