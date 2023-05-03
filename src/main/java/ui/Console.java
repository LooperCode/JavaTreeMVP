package ui;

import Presenter.Presenter;
import ui.Command.Receiver;
import ui.Menu.VarMenu.MainMenu;
import ui.Menu.Menu;

import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new MainMenu(new Receiver(this));
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

    public void add(String name, String date, String nameFather, String nameMother) {

        presenter.add(name, date, nameFather, nameMother);

    }

    public void getChoiceSort() {

        menu.execute(scan("цифру: "));
    }

    public void sortByName() {

        presenter.sortByName();
    }

    public void sortByDate() {

        presenter.sortByDate();
    }

    public String getByFamily() {

       return presenter.getByFamily(scan("фамилию: "));
    }

    public void getOnce(){
        presenter.getOnce(scan("ID: "));
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

        printFast(menu.print());
    }

    public void printFast(String string){

        System.out.println(string);
    }

    @Override
    public void print(String text) {
        try {
            System.out.println("-------RESULT-------");
            System.out.println(text);
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start() {
        while (true) {
            printFast("-----MENU-----");
            printFast(menu.print());
            menu.execute(scan("цифру: "));
        }
    }


    }



