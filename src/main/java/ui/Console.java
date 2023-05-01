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

    public String scan(String insert) {
        System.out.print("\n");
        System.out.println("Введите " + insert);
        return scanner.next();
    }

    public int scanInt(String insert) {
        System.out.print("\n");
        System.out.println("Введите " + insert);
        return scanner.nextInt();
    }

    public void add(String name, int date, String nameFather, String nameMother) {

        presenter.add(name, date, nameFather, nameMother);

    }

    public void getChoiceSort() {
        System.out.println("-----MENU-----");
        menu.execute(scan("цифру: "));
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

    public void newTree() {

        presenter.newTree(scan("фамилию: "));
    }

    public void saveData() {

        presenter.saveData();
    }

    public void currentPrint(){

        presenter.currentPrint();
    }

    public void menuPrint(){
        print(menu.print());
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
