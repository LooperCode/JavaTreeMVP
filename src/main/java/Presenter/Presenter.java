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

    public void printSortByName() {
        service.sortByName();
        view.print(service.toString());
    }

    public void printSortByDate() {
        service.sortByDate();
        view.print(service.toString());
    }

    public void loadData(String family) {
        service.loadData(family);
    }

    public void saveData() {
        service.saveData();
    }

    public void add(String name, int date, String nameFather, String nameMother){
        service.add(name, date, service.getByName(nameFather), service.getByName(nameMother));
    }

    public void getByName(String name){
        view.print(service.getString(name));
    }

    public void newTree(String family){
        service.newTree(family);
    }
}
