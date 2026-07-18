package entry;

import java.time.LocalDateTime;

public class Entry {
    private  int id = 1;
    private  String entryName;
    private  String body;
    private LocalDateTime dateCreated;

    public  Entry (int id, String name, String entryBody) {
        this.id = id++;
        this.entryName = name;
        this.body = entryBody;
        this.dateCreated = LocalDateTime.now();
    }
    public void setId(int idNumber) {
        this.id = idNumber;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.entryName = title;
    }

    public String getTitle() {
        return  entryName;
    }

    public void setBody(String entryBody) {
        this.body = entryBody;
    }

    public String getBody() {
        return body;
    }

    public int getEntryId() {
        return id;
    }
}
