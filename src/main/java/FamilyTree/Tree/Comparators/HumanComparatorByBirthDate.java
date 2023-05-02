package FamilyTree.Tree.Comparators;

import FamilyTree.Person.Persons.Human;

import java.util.Comparator;

public class HumanComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getBirthdate(), o1.getBirthdate());
    }
}
