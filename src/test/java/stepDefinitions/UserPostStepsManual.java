package stepDefinitions;

import io.cucumber.java.en.When;
import models.User;

import java.util.List;
import java.util.Map;

public class UserPostStepsManual {

    @When("I create users manually from this table:")
    public void iCreateUsersManually(io.cucumber.datatable.DataTable dataTable) {
        // 1. Zamieniamy tabelę na listę map (każdy wiersz to mapa)
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        // 2. Musimy ręcznie przelecieć pętlą przez każdy wiersz
        for (Map<String, String> columns : rows) {

            // 3. Ręcznie wyciągamy dane po nazwach kolumn
            String nameFromTable = columns.get("name");
            String emailFromTable = columns.get("email");

            // 4. Ręcznie tworzymy obiekt User
            User manualUser = new User();
            manualUser.setName(nameFromTable);
            manualUser.setEmail(emailFromTable);

            // 5. Dopiero teraz możemy coś z nim zrobić
            System.out.println("Manual mapping: " + manualUser.getName());
        }
    }
}
