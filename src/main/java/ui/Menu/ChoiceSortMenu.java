package ui.Menu;

import ui.Command.Command;
import ui.Command.Commands.Sort.SortByDate;
import ui.Command.Commands.Sort.SortByName;
import ui.Console;

import java.util.ArrayList;
import java.util.List;

public class ChoiceSortMenu implements Menu {
    private List<Command> list;


    public ChoiceSortMenu(Console console) {
        list = new ArrayList<>();
        list.add(new SortByName(console));
        list.add(new SortByDate(console));

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
