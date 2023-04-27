package FamilyTree.Tree;

import java.util.Iterator;
import java.util.List;

public class BranchesIterator<E> implements Iterator<E> {
    private int index;
    private List<E> familyBranches;

    public BranchesIterator(List<E> familyBranches) {
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
