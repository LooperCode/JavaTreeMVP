package FamilyTree.Tree;



import FamilyTree.Person.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Branches <E extends Human> implements Tree<E>, Serializable {
    private List<E> familyBranches;

    public Branches(List<E> familyBranche){
        this.familyBranches = familyBranche;
    }

    public Branches(){
        this(new ArrayList<E>());
    }

    public List<E> getFamilyBranches() {
        return familyBranches;
    }

    public E getByName(String name){
        for (E human : familyBranches){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!familyBranches.contains(human)){
            familyBranches.add(human);
                if (human.getFather() != null){
                    human.getFather().addChild(human);
                }
                if (human.getMother() != null){
                    human.getMother().addChild(human);
                }
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (E human : getFamilyBranches()) {
            sb.append(count++).append(": ");
            sb.append(human.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<E>(getFamilyBranches());
    }
}
