import FamilyTree.Data.DB.DataBase;
import FamilyTree.Data.Operation;
import FamilyTree.Data.OperationData;
import FamilyTree.Service.Service;
import FamilyTree.Service.ServiceHuman;
import ui.Console;
import ui.View;
import Presenter.Presenter;
public class Main {
    public static void main(String[] args) {
        View view = new Console();
        DataBase data = new DataBase();
        Operation operation = new OperationData();
        Service service = new ServiceHuman(data, operation);
        Presenter presenter = new Presenter(view, service);
        presenter.loadData();

        view.start();




    }
}