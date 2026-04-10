package stepDefinitions;

import io.cucumber.java.DataTableType;
import models.User;
import java.util.Map;

public class DataTableConfig {

    @DataTableType
    public User userEntry(Map<String, String> entry) {
        return new User(
                entry.get("name"),
                entry.get("username"),
                entry.get("email"));
    }
}