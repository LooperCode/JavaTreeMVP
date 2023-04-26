package FamilyTree.Tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> familyBranches;

    public HumanIterator(List<E> familyBranches) {
        this.familyBranches = familyBranches;
    }

    @Override
    public boolean hasNext() {
        return index < familyBranches.size();
    }

    @Override
    public E next() {
        return familyBranches.get(index++);
    }

    @Override
    public void remove() {

    }

}
