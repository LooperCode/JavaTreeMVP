package FamilyTree.Service;


import FamilyTree.Person.Persons.Human;
import FamilyTree.Tree.Tree;

public interface Service {
    Tree<Human> getCurrentTree();

    void setCurrentTree(Tree<Human> currentTree);

    void add(String name, int birthdate, String father, String mother);

    Human getByName(String name);

    void saveData();

    void loadData();

    void sortByName();

    void sortByDate();

    void newTree(String family);

    String getByFamily(String family);

    void getOnce(int index);

}
