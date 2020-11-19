package Question1;
import Question1.Entities.Product;
import Question1.Utils.FileUtils;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        String fileName = "products.txt";

        FileUtils.createFile(fileName);
        Set<Product> productsFile = FileUtils.readFile(fileName);

        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        Set<Product> productSet = new HashSet<>();

        while (flag) {
            System.out.println("Identifier? ");
            String id = sc.next();

            System.out.println("Name? ");
            String name = sc.next();

            System.out.println("More items? [S/N]");
            if(sc.next().equalsIgnoreCase("N")) {
                flag = false;
            }

            Product product = new Product(id, name);
            if(!productsFile.contains(product)) { // ! --> NOT
                productSet.add(product);
            }
        }

        FileUtils.writeFile(fileName, productSet);
    }

}

