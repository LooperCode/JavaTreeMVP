package ui.Command;

import ui.Console;
import ui.Menu.VarMenu.ChoiceSortMenu;
import ui.Menu.VarMenu.MainMenu;

public class Receiver {
    Console console;

    public Receiver(Console console) {
        this.console = console;
    }

    public void add() {
        try {
            String name = console.scan("имя: ");
            String date = console.scan("год рождения: ");
            String nameFather = console.scan("имя отца: ");
            String nameMother = console.scan("имя матери: ");
            console.add(name, date, nameFather, nameMother);
        } catch (NumberFormatException nfe) {
            console.print("Некорректный ввод данных");
            add();
        } catch (NullPointerException nef){
            console.print("Текущее дерево не установлено. ");
        }
    }

    public void currentPrint() {
        try {
            console.currentPrint();

        } catch (NullPointerException e) {
            console.print("Текущее дерево не установлено. ");
        }
    }

    public void getByFamily() {
        if (console.getByFamily().isEmpty()) {
            console.print("Семейства не найдены");
        } else {
            try {
                console.getOnce();
            } catch (NumberFormatException nfe) {
                console.print("Некорректный ввод данных");
            }
        }
    }

    public void newTree() {

        console.newTree();
    }

    public void saveData() {

        console.saveData();
    }

    public void getChoiceSort() {
        console.setMenu(new ChoiceSortMenu(this));
        console.printFast("-----MENU-----");
        console.menuPrint();
        console.getChoiceSort();
    }

    public void sortByName() {
        try {
            console.sortByName();
            console.setMenu(new MainMenu(this));
        } catch (NullPointerException e) {
            console.print("Текущее дерево не установлено. ");
            console.setMenu(new MainMenu(this));
        }
    }

    public void sortByDate() {
        try {
            console.sortByDate();
            console.setMenu(new MainMenu(this));
        } catch (NullPointerException e) {
            console.print("Текущее дерево не установлено. ");
            console.setMenu(new MainMenu(this));
        }
    }
}