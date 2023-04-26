import FamilyTree.Service.Service;
import FamilyTree.Service.ServiceHuman;
import ui.Console;
import ui.View;
import Presenter.Presenter;
public class Main {
    public static void main(String[] args) {
        View view = new Console();
        Service service = new ServiceHuman();
        Presenter presenter = new Presenter(view, service);

        view.start();




    }
}