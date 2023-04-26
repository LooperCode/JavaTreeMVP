package FamilyTree.Person;

public interface PersonInterface<E> {
    String getName();
    int getBirthdate();
    E getFather();
    E getMother();

}
