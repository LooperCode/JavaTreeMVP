package FamilyTree.Tree;

import java.util.List;

public interface Tree <E> extends Iterable<E>{
    boolean add(E person);
    List<E> getFamilyBranches();
    E getByName(String name);

}
