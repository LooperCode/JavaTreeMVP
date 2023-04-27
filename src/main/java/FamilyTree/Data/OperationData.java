package FamilyTree.Data;

import FamilyTree.Data.Transliteration.Transliter;

import java.io.*;

public class OperationData implements Operation {

    private String toLat(String text){
        return Transliter.cyr2lat(text);
    }


    @Override
    public Object loadData(String famIndex) {
        famIndex = toLat(famIndex.toUpperCase());
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("src/main/java/FamilyTree/Data/BD/" + famIndex + ".out"));
            Object tree = objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
        catch (ClassNotFoundException | IOException e) {
            System.out.println("Ошибка восстановления сериализации. Не найден класс!");
        }
        return null;
    }

    @Override
    public void saveData (Object data, String famIndex){
        famIndex = toLat(famIndex.toUpperCase());
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("src/main/java/FamilyTree/Data/BD/" + famIndex + ".out"));
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи сериализации!");
        }

    }
}

