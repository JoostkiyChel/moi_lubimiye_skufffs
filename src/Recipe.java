import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Recipe {
    public static void main(String[] args) {
        String dishName;
        int numberOfIngredients;
        String[] ingredients;
        int[] gramWeights;
        String cookingMethod;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название вашего любимого блюда: ");
        dishName = scanner.nextLine();

        // Ввод количества ингредиентов
        System.out.print("Введите количество ингредиентов: ");
        numberOfIngredients = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Ввод названий ингредиентов
        ingredients = new String[numberOfIngredients];
        for (int i = 0; i < numberOfIngredients; i++) {
            System.out.print("Введите название ингредиента " + (i + 1) + ": ");
            ingredients[i] = scanner.nextLine();
        }

        // Ввод веса ингредиентов в граммах
        gramWeights = new int[numberOfIngredients];
        for (int i = 0; i < numberOfIngredients; i++) {
            System.out.print("Введите вес ингредиента " + ingredients[i] + " в граммах: ");
            gramWeights[i] = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
        }

        // Ввод способа приготовления
        System.out.print("Введите полный способ приготовления: ");
        cookingMethod = scanner.nextLine();

        // Запись в файл
        try {
            FileWriter fileWriter = new FileWriter("recipe.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Название блюда: " + dishName);
            printWriter.println("Ингредиенты:");
            for (int i = 0; i < numberOfIngredients; i++) {
                printWriter.println("- " + ingredients[i] + ": " + gramWeights[i] + " грамм");
            }
            printWriter.println("Способ приготовления: " + cookingMethod);

            printWriter.close();
            System.out.println("Рецепт успешно записан в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
