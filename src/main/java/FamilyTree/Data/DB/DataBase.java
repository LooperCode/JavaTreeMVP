package FamilyTree.Data.DB;

import FamilyTree.Tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataBase implements Serializable {
    private List<Tree> data;
    private List<Tree> similar;


    public DataBase() {

        this.data = new ArrayList<>();
    }

    public Tree getOnce (int index){
        if (similar.isEmpty()){
            return null;
        }
        if (index - 1 > similar.size()){
            return null;
        }

        return similar.get(index - 1);
    }

    private void clearSimilar(){
        this.similar = new ArrayList<>();
    }

    public void addData(Tree data) {
        this.data.add(data);
    }

    public String getByFamily(String family){
        clearSimilar();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (Tree branches : data){
            if (branches.getFamily().equalsIgnoreCase(family)){
                similar.add(branches);
                sb.append("-------").append(branches.getFamily());
                sb.append(" ID: ").append(count++).append("-------");
                sb.append(branches);
            }
        }
        return sb.toString();
    }



}
