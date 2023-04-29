package ui;

import Presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
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

    private void helpList() {
        System.out.println("-------MENU-------" + "\n1: Поиск по фамилии" + "\n2: Вывести дерево" +
                "\n3: Добавить человека в дерево" + "\n4: Сохранить дерево" + "\n5: Создать новое дерево");
    }

    private void choiceToSort() {
        System.out.println("-------MENU-------" + "\n1: Вывести дерево в алфавитном порядке" +
                "\n2: Вывести дерево сортировкой по дате");
        switch (scanInt("цифру: ")) {
            case 1:
                presenter.printSortByName();
                break;
            case 2:
                presenter.printSortByDate();
                break;
            default:
                choiceError();
        }
    }

    private void add() {
        String name = scan("имя: ");
        int date = scanInt("год рождения: ");
        String nameFather = scan("имя отца: ");
        String nameMother = scan("имя матери: ");
        presenter.add(name, date, nameFather, nameMother);
    }

    private void choiceError() {
        print("Некорректные данные");
    }

    @Override
    public void start() {
        presenter.loadData();
        while (true) {
            helpList();
            int choice = scanInt("цифру: ");
            switch (choice) {
                case 1:
                    presenter.getByFamily(scan("фамилию: "));
                    break;
                case 2:
                    choiceToSort();
                    break;
                case 3:
                    add();
                    print("Добавлено!");
                    break;
                case 4:
                    presenter.saveData();
                    print("Сохранено!");
                    break;
                case 5:
                    presenter.newTree(scan("фамилию: "));
                    print("Новое дерево создано!");
                    break;

                default:
                    choiceError();
            }
        }
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

}
