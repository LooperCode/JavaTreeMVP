package FamilyTree.Service;


import FamilyTree.Person.Human;
import FamilyTree.Tree.Tree;

public interface Service {
    Tree<Human> getTree();

    void setTree(Tree<Human> tree);

    void add(String name, int birthdate, String father, String mother);

    Human getByName(String name);

    void saveData();

    void loadData();

    void sortByName();

    void sortByDate();

    void newTree(String family);

    String getString(String name);

    String getByFamily(String family);

    String getOnce(int index);

}
