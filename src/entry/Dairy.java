package entry;

import java.util.ArrayList;
import java.util.List;

public class Dairy {
    private String dairyUsername;
    private String dairyPassword;
    private boolean isLocked;
    private int entryCountId = 1;
    private final List<Entry> entries = new ArrayList<Entry>();

    public Dairy(String dairyName, String password) {
        this.dairyUsername = dairyName;
        this.dairyPassword = password;
        this.isLocked = true;
    }

    public boolean isDairyLocked(String password) {
        return isLocked;
    }

    public void unlockDairy(String password) {
        if (this.dairyPassword.equals(password)) {
            isLocked = false;
        }
        else throw new IllegalArgumentException("you entered a wrong password");
    }


    public void lockDairy() {
        isLocked = true;
    }

    public int createEntry(String EntryName, String description) {
        unlockDairy("password");

        Entry entry = new Entry(entryCountId, EntryName, description);
        entries.add(entry);
        entryCountId++;
        return entries.getLast().getEntryId();
    }

    public Entry findEntry(int entryId) {
        for (int count = 0; count < entries.size(); count++) {
            if (entries.get(count).getEntryId() == entryId)
                return entries.get(count);
        }
        throw new IllegalArgumentException("Entry not found.");
    }

    public void deleteEntry(int entryId, String password) {
        unlockDairy("password");
        Entry removedEntry = findEntry(entryId);
        entries.remove(removedEntry);
        entryCountId--;
    }

    public void updateEntry(int id, String newTitle, String newTitleBody) {
        unlockDairy("password");
        Entry updatedEntry = findEntry(id);
        updatedEntry.setTitle(newTitle);
        updatedEntry.setBody(newTitleBody);
    }

    public String getUsername() {
        return dairyUsername;
    }
}
