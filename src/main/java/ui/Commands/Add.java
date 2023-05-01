package ui.Commands;

import ui.Console;
import ui.Menu.MainMenu;

public class Add implements Command{
    private Console console;

    public Add(Console console) {

        this.console = console;
    }

    public String getDescription(){

        return "Добавить человека в дерево";
    }

    public void execute() {
        String name = console.scan("имя: ");
        int date = console.scanInt("год рождения: ");
        String nameFather = console.scan("имя отца: ");
        String nameMother = console.scan("имя матери: ");
        console.add(name, date, nameFather, nameMother);

    }
}
