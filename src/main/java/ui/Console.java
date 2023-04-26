package ui;

import Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    private String scan(String insert){
        System.out.print("\n");
        System.out.println("Введите "+ insert);
        return scanner.next();
    }

    private int scanInt(String insert){
        System.out.print("\n");
        System.out.println("Введите "+ insert);
        return scanner.nextInt();
    }

    private void helpList(){
        System.out.println("-------MENU-------" + "\n1: Вывести дерево" +"\n2: Загрузка/Сохранение"+
                "\n3: Добавить человека в дерево" + "\n4: Поиск по имени" + "\n5: Создать новое дерево");
    }

    private void choiceToSort (){
        System.out.println("-------MENU-------" +"\n1: Вывести дерево в алфавитном порядке" +
                                                 "\n2: Вывести дерево сортировкой по дате");
        switch (scanInt("цифру: ")){
            case 1:
                presenter.printSortByName();
                break;
            case 2:
                presenter.printSortByDate();
                break;
            default: choiceError();
        }
    }

    private void choiceToDataOperation(){
        System.out.println("-------MENU-------" +"\n1: Загрузить дерево" +"\n2: Сохранить дерево");
        switch (scanInt("цифру: ")){
            case 1:
                presenter.loadData();
                print("Загрузка завершена");
                break;
            case 2:
                presenter.saveData();
                print("Запись завершена");
                break;

            default: choiceError();
        }
    }

    private void add(){
        String name = scan("имя: ");
        int date = scanInt("год рождения: ");
        String nameFather = scan("имя отца: ");
        String nameMother = scan("имя матери: ");
        presenter.add(name, date, nameFather, nameMother);
    }

    private void choiceError ()  {
        print("Некорректные данные");
    }

    @Override
    public void start() {
        while (true) {
            helpList();
            int choice = scanInt("цифру: ");
            switch (choice) {
                    case 1:
                        choiceToSort();
                        break;
                    case 2:
                        choiceToDataOperation();
                        break;
                    case 3:
                        add();
                        break;
                    case 4:
                        presenter.getByName(scan("имя для поиска: "));
                        break;
                    case 5:
                        presenter.newTree();
                        print("Новое дерево создано!");
                        break;

                    default: choiceError();
                }
            }
    }



    @Override
    public void print(String text){
        try {
            System.out.println("-------RESULT-------");
            System.out.println(text);
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
