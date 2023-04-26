package FamilyTree.Data;

import java.io.*;

public class OperationData implements Operation {

    @Override
    public Object loadData() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("src/main/java/FamilyTree/Data/person.out"));
            Object tree = objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Ошибка восстановления сериализации. Не найден класс!");
        }
        return null;
    }

    @Override
    public void saveData (Object data){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("src/main/java/FamilyTree/Data/person.out"));
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи сериализации!");
        }

    }
}

