package FamilyTree.Service;


import FamilyTree.Data.DB.DataBase;
import FamilyTree.Data.Operation;
import FamilyTree.Person.Human;
import FamilyTree.Tree.Branches;
import FamilyTree.Tree.Comparators.HumanComparatorByBirthDate;
import FamilyTree.Tree.Comparators.HumanComparatorByName;
import FamilyTree.Tree.Tree;

public class ServiceHuman implements Service {
    private Tree<Human> tree;
    private DataBase data;
    private Operation operation;

    public ServiceHuman(DataBase data, Operation operation) {
        this.operation = operation;
        this.tree = new Branches<>();
        this.data = data;
    }

    public Tree<Human> getTree() {
        return tree;
    }

    public void setTree(Tree<Human> tree) {
        this.tree = tree;
    }

    public void newTree(String family) {
        this.tree = new Branches<>();
        tree.setFamily(family);
        data.addData(getTree());
    }

    public String getByFamily(String family) {

        return data.getByFamily(family);
    }


    public String getOnce(int index) {
        try {
            setTree(data.getOnce(index));
            return "Загрузка завершена";
        } catch (NullPointerException e) {
            return "Семейство не найдено. Убедитесь что вы ввели корректные данные!";

        }
    }

    public void add(String name, int birthdate, String father, String mother) {
        Human human = new Human(name, birthdate, getByName(father), getByName(mother));
        tree.add(human);
    }

    public Human getByName(String name) {
        return tree.getByName(name);
    }


    public String getString(String name) {
        try {
            Human human = tree.getByName(name);
            return human.getString();
        } catch (NullPointerException e) {
            {
                return "Не найдено";
            }
        }
    }


    public void saveData() {

        operation.saveData(getTree(), tree.getFamily());
    }

    public void loadData() {

        setTree((Tree<Human>) operation.loadData());
    }

    public void sortByName() {
        try {
            tree.getFamilyBranches().sort(new HumanComparatorByName());
        } catch (NullPointerException ignored) {
        }
    }

    public void sortByDate() {
        try {
            tree.getFamilyBranches().sort(new HumanComparatorByBirthDate());

        } catch (NullPointerException ignored) {
        }
    }

    @Override
    public String toString() {
        try {
            return tree.toString();
        } catch (NullPointerException ignored) {
            return "";
        }

    }
}
