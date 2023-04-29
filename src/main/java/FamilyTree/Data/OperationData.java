package FamilyTree.Data;

import java.io.*;

public class OperationData implements Operation {



    @Override
    public Object loadData() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("src/main/java/FamilyTree/Data/DB/base.db"));
            Object tree = objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (FileNotFoundException e){
            System.out.println("-------LOAD-------" + "\nФайл не найден");
        }
        catch (ClassNotFoundException | IOException e) {
            System.out.println("-------LOAD-------" + "Ошибка восстановления сериализации. Не найден класс!");
        }
        return null;
    }

    @Override
    public void saveData (Object data, String famIndex){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("src/main/java/FamilyTree/Data/DB/base.db"));
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи сериализации!");
        }

    }
}

