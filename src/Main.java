import com.company.Myapplication;
import com.company.repositories.EmployeeRep;
import com.company.data.PostgresDataBase;
import com.company.data.interfaces.DataBase;
import com.company.repositories.interfaces.InterfaceOfRepository;

public class Main {
    public static void main(String[] args) {
        DataBase db = new PostgresDataBase();
        InterfaceOfRepository repo = new EmployeeRep(db);
        Myapplication app = new Myapplication(repo);
        app.start();
    }
}