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
    //Геттеры-----------------------------
    public Tree<Human> getCurrentTree() {

        return currentTree;
    }

    public DataBase getData() {

        return data;
    }

    public String getByFamily(String family) {  //поиск семьи по фамилии

        return data.getByFamily(family);
    }

    public Human getByName(String name) {   //возвращает Human по имени в текущем дереве

        return currentTree.getByName(name);
    }

    public void getOnce(int index) {  // предоставляет выбор деревьев из списка

        setCurrentTree(data.getOnce(index));
    }
    //сеттеры---------------------------
    public void setCurrentTree(Tree<Human> currentTree) { // устанавливает выбранное дерево в текущее

        this.currentTree = currentTree;
    }

    public void setData(Object data) { //устанавливает в DataBase восстановленную сериализацию

        this.data = (DataBase) data;
    }

    public void newTree(String family) { //создает новое дерево
        setCurrentTree(new Branches<>());
        currentTree.setFamily(family);
        data.addData(getCurrentTree());

    }


    public void add(String name, int birthdate, String father, String mother) {
        Human human = new Human(name, birthdate, getByName(father), getByName(mother));
        currentTree.add(human);
    }


    public void saveData() {

        operation.saveData(getData());

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
