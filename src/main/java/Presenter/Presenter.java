package Presenter;

import FamilyTree.Service.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void sortByName() {
        service.sortByName();
        view.print("Отсортировано по алфавиту!");
    }

    public void sortByDate() {
        service.sortByDate();
        view.print("Отсортировано по дате!");
    }

    public void currentPrint() {

        view.print(service.toString());
    }

    public void loadData() {

        service.loadData();
    }

    public void saveData() {
        service.saveData();
        view.print("Сохранено!");
    }

    public void add(String name, int date, String nameFather, String nameMother) {
        service.add(name, date, nameFather, nameMother);
        view.print("Добавлено!");
    }

    public void getByFamily(String family) {

        view.print(service.getByFamily(family));

    }

    public void getOnce(int index) {
        service.getOnce(index);
        view.print("Семейство установленно в текущее");
    }


    public void newTree(String family) {
        service.newTree(family);
        view.print("Дерево создано!");
    }
}
