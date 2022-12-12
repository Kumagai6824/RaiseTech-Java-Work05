import java.util.*;

public class Main {
    public static void main(String[] args) {

        //スーパーの商品リストを作る
        Map<Integer, Product> keysToProducts = new HashMap<>();
        keysToProducts.put(1, new Product("Onion", Category.VEGETABLE, 150));
        keysToProducts.put(2, new Product("Carrot", Category.VEGETABLE, 110));
        keysToProducts.put(3, new Product("Potato", Category.VEGETABLE, 110));
        keysToProducts.put(4, new Product("Beef", Category.MEAT, 400));
        keysToProducts.put(5, new Product("Chicken", Category.MEAT, 300));
        keysToProducts.put(6, new Product("Salmon", Category.MEAT, 400));
        keysToProducts.put(7, new Product("Black Pepper", Category.SPICE, 130));
        keysToProducts.put(8, new Product("Herb", Category.SPICE, 200));
        keysToProducts.put(9, new Product("Curry Spice", Category.SPICE, 300));

        //Display product lists for user
        System.out.println("""
                "Let's go get groceries!" simulator<1.0>
                Choose what you need for dinner...
                """);

        for (int i = 1; i <= keysToProducts.size(); i++) {
            String name = keysToProducts.get(i).getName();
            Category category = keysToProducts.get(i).getCategory();
            int cost = keysToProducts.get(i).getCost();

            if (i % 3 == 1) {
                System.out.printf("""
                        --------------------
                            [%1s]
                        --------------------
                        <%2s > %3s : ¥%4s%n""", category.getName(), i, name, cost);
            } else {
                System.out.printf("""
                        < %1s > %2s : ¥%3s%n""", i, name, cost);
            }

        }

        Scanner scanner = new Scanner(System.in);  //入力システム
        List<Product> pickedProducts = new ArrayList<>();  //ユーザーが選んだ商品をまとめるリスト

        Arrays.stream(Category.values()).toList().forEach(Category -> {
            int rangeMin = 0;
            int rangeMax = 0;
            switch (Category) {
                case VEGETABLE:
                    rangeMin = 1;
                    rangeMax = 3;
                    break;
                case MEAT:
                    rangeMin = 4;
                    rangeMax = 6;
                    break;
                case SPICE:
                    rangeMin = 7;
                    rangeMax = 9;
            }

            boolean flag = true;
            do {
                try {
                    System.out.println("\nType one of the numbers from the " + Category.getName() + " category below and press enter.");
                    int categoryKey = scanner.nextInt();
                    if (categoryKey >= rangeMin && categoryKey <= rangeMax) {
                        Product chosenProduct = keysToProducts.get(categoryKey);
                        System.out.println("You chose..." + chosenProduct.getName() + "\n");
                        pickedProducts.add(chosenProduct);
                        flag = false;
                    } else {
                        throw new NoSuchKeyException("You can only use <" + rangeMin + "> to <" + rangeMax + ">");
                    }
                } catch (NoSuchKeyException e) {
                    System.out.println(e.getErrMsg());
                }
            } while (flag);

        });

        int totalCost = pickedProducts.stream().mapToInt(i -> i.getCost()).sum();
        System.out.printf("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                You paid ¥%s at the supermarket!
                Let's go home & cook!!
                ((o(・ρ・)o)) ﾊﾗﾍｯﾀｧ");
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                %n""", totalCost);
    }
}
