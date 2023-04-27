package FamilyTree.Data;

public interface Operation {
    public void saveData(Object object, String famIndex);
    public Object loadData(String famIndex);
}
