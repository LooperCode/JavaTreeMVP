package ui;

import Presenter.Presenter;
import ui.Menu.ChoiceSortMenu;
import ui.Menu.MainMenu;
import ui.Menu.Menu;

import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {

        this.presenter = presenter;
    }

    public void setMenu(Menu menu) {

        this.menu = menu;
    }

    private String scan(String insert) {
        System.out.print("\n");
        System.out.println("Введите " + insert);
        return scanner.next();
    }

    private int scanInt(String insert) {
        System.out.print("\n");
        System.out.println("Введите " + insert);
        return scanner.nextInt();
    }

    public void add() {
        String name = scan("имя: ");
        int date = scanInt("год рождения: ");
        String nameFather = scan("имя отца: ");
        String nameMother = scan("имя матери: ");
        presenter.add(name, date, nameFather, nameMother);

    }

    public void getChoiceSort() {
        setMenu(new ChoiceSortMenu(this));
        System.out.println("-----MENU-----");
        System.out.println(menu.print());
        menu.execute(scan("цифру: "));
        setMenu(new MainMenu(this));
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByDate() {
        presenter.sortByDate();
    }

    public void getByFamily() {
        presenter.getByFamily(scan("фамилию: "));
        presenter.getOnce(scanInt("ID: "));
    }

    public void getOnce() {
        presenter.getOnce(scanInt("цифру: "));
    }

    public void newTree() {
        presenter.newTree(scan("фамилию: "));
    }

    public void saveData() {
        presenter.saveData();
    }

    public void currentPrint(){
        presenter.currentPrint();
    }
    @Override
    public void start() {
        while (true) {
            System.out.println("-----MENU-----");
            System.out.println(menu.print());
            menu.execute(scan("цифру: "));
        }
    }
    @Override
    public void print(String text) {
        try {
            System.out.println("-------RESULT-------");
            System.out.println(text);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
