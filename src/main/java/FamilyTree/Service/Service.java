package FamilyTree.Service;


import FamilyTree.Data.Operation;
import FamilyTree.Person.Human;
import FamilyTree.Tree.Tree;

public interface Service {
    Tree<Human> getTree();
    void setTree(Tree<Human> tree);
    void add(String name, int birthdate);
    void add(String name, int birthdate, Human father, Human mother);
    Human getByName(String name);
    void saveData();
    void loadData();
    void sortByName();
    void sortByDate();
    void newTree();
    String getString(String name);
}
