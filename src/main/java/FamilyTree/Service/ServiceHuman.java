package FamilyTree.Service;


import FamilyTree.Data.DB.DataBase;
import FamilyTree.Data.Operation;
import FamilyTree.Person.Human;
import FamilyTree.Tree.Branches;
import FamilyTree.Tree.Comparators.HumanComparatorByBirthDate;
import FamilyTree.Tree.Comparators.HumanComparatorByName;
import FamilyTree.Tree.Tree;

public class ServiceHuman implements Service {
    private Tree<Human> currentTree;
    private DataBase data;
    private Operation operation;

    public ServiceHuman(DataBase data, Operation operation) {
        this.currentTree = new Branches<>();
        this.data = data;
        this.operation = operation;
    }
    //Геттеры
    public Tree<Human> getCurrentTree() {
        return currentTree;
    }

    public DataBase getData() {
        return data;
    }

    public String getByFamily(String family) {  //поиск семьи по фамилии

        return data.getByFamily(family);
    }

    public String getOnce(int index) {  // устанавливает выбранное дерево в текущее
        try {
            setCurrentTree(data.getOnce(index));
            return "Загрузка завершена";
        } catch (NullPointerException e) {
            return "Семейство не найдено. Убедитесь что вы ввели корректные данные!";
        }
    }

    public Human getByName(String name) {   //возвращает Human по имени в текущем дереве

        return currentTree.getByName(name);
    }

    public void setCurrentTree(Tree<Human> currentTree) {
        this.currentTree = currentTree;
    }

    public void setData(Object data) {
        this.data = (DataBase) data;
    }

    public String newTree(String family) {
        setCurrentTree(new Branches<>());
        currentTree.setFamily(family);
        data.addData(getCurrentTree());
        return "Дерево создано!";
    }


    public void add(String name, int birthdate, String father, String mother) {
        Human human = new Human(name, birthdate, getByName(father), getByName(mother));
        currentTree.add(human);
    }


    public String saveData() {

        operation.saveData(getData());
        return "Сохранено!";
    }

    public void loadData() {
        Object obj = operation.loadData();
        if (!(obj == null)) {
            setData(obj);
        }
    }

    public void sortByName() {
        try {
            currentTree.getFamilyBranches().sort(new HumanComparatorByName());
        } catch (NullPointerException ignored) {
        }
    }

    public void sortByDate() {
        try {
            currentTree.getFamilyBranches().sort(new HumanComparatorByBirthDate());

        } catch (NullPointerException ignored) {
        }
    }

    @Override
    public String toString() {
        return currentTree.toString();
    }
}
