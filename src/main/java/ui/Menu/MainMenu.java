package ui.Menu;

import ui.Commands.*;
import ui.Commands.Sort.Sort;
import ui.Console;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {
    private List<Command> list;

    public MainMenu(Console console) {
        list = new ArrayList<>();
        list.add(new GetByFamily(console));
        list.add(new CurrentPrint(console));
        list.add(new Sort(console));
        list.add(new SaveData(console));
        list.add(new Add(console));
        list.add(new NewTree(console));
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

        list.get(Integer.parseInt(choice) - 1).execute();
    }
}
