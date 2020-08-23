
import domain.Register;
import domain.Store;
import ui.UserInterface;


public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Register register = store.getRegister();
        new UserInterface(register);
    }
}
