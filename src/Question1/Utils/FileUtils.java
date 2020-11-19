package Question1.Utils;

import Question1.Entities.Product;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileUtils {

    public static void createFile(String name) {
        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String name, Set<Product> productSet) {
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(name, true));
            for (Product p : productSet) {
                myWriter.write(p.getIdentifier() + " " + p.getName());
                myWriter.newLine();
                myWriter.flush();
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Set<Product> readFile(String name) {
        Set<Product> productSet = new HashSet<>();

        try {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] res = data.split(" ");
                productSet.add(new Product(res[0], res[1]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return productSet;
    }
}
