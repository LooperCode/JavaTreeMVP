package ui.Menu.VarMenu;

import ui.Command.Command;
import ui.Command.Commands.*;
import ui.Command.Commands.Sort.Sort;
import ui.Command.Receiver;
import ui.Menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {
    private List<Command> list;

    public MainMenu(Receiver receiver) {
        list = new ArrayList<>();
        list.add(new GetByFamily(receiver));
        list.add(new CurrentPrint(receiver));
        list.add(new Sort(receiver));
        list.add(new SaveData(receiver));
        list.add(new Add(receiver));
        list.add(new NewTree(receiver));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(String choice){
        try {
            list.get(Integer.parseInt(choice) - 1).execute();
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            print();
        }
    }
}
