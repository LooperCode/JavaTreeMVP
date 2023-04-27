package FamilyTree.Service;


import FamilyTree.Data.Operation;
import FamilyTree.Data.OperationData;
import FamilyTree.Person.Human;
import FamilyTree.Tree.Branches;
import FamilyTree.Tree.Comparators.HumanComparatorByBirthDate;
import FamilyTree.Tree.Comparators.HumanComparatorByName;
import FamilyTree.Tree.Tree;

public class ServiceHuman implements Service {
    private Tree<Human> tree;
    private String family;

    public ServiceHuman() {
        this.tree = new Branches<>();
        this.family = "ExampleTree";
    }

    public Tree<Human> getTree() {
        return tree;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setTree(Tree<Human> tree) {this.tree = tree;}

    public void newTree(String family){
        this.tree = new Branches<>();
        this.family = family;
    }

    public void add(String name, int birthdate){
        Human human = new Human(name, birthdate);
        tree.add(human);
    }

    public void add(String name, int birthdate, Human father, Human mother){
        Human human = new Human(name, birthdate, father, mother);
        tree.add(human);
    }

    public Human getByName(String name){
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
        Operation file = new OperationData();
        file.saveData(getTree(), getFamily());
    }

    public void loadData(String family) {
        setFamily(family);
        Operation file = new OperationData();
        setTree((Tree<Human>) file.loadData(getFamily()));
    }

    public void sortByName(){
        tree.getFamilyBranches().sort(new HumanComparatorByName());
    }

    public void sortByDate(){
        tree.getFamilyBranches().sort(new HumanComparatorByBirthDate());
    }

    @Override
    public String toString() {
        return tree.toString();
    }
}
