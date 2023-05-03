package ui.Menu.VarMenu;

import ui.Command.Command;
import ui.Command.Commands.Sort.SortByDate;
import ui.Command.Commands.Sort.SortByName;
import ui.Command.Receiver;
import ui.Console;
import ui.Menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class ChoiceSortMenu implements Menu {
    private List<Command> list;


    public ChoiceSortMenu(Receiver receiver) {
        list = new ArrayList<>();
        list.add(new SortByName(receiver));
        list.add(new SortByDate(receiver));

    }
    @Override
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(String choice) {

        list.get(Integer.parseInt(choice) - 1).execute();
    }
}
