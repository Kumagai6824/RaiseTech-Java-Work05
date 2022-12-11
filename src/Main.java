import java.util.*;

public class Main {
    public static void main(String[] args) {

        //スーパーの商品リストを作る
        Map<Integer, Products> productsList = new HashMap<>();
        productsList.put(1, new Products("Onion", Category.VEGETABLE, 150));
        productsList.put(2, new Products("Carrot", Category.VEGETABLE, 110));
        productsList.put(3, new Products("Potato", Category.VEGETABLE, 110));
        productsList.put(4, new Products("Beef", Category.MEAT, 400));
        productsList.put(5, new Products("Chicken", Category.MEAT, 300));
        productsList.put(6, new Products("Salmon", Category.MEAT, 400));
        productsList.put(7, new Products("Black Pepper", Category.SPICE, 130));
        productsList.put(8, new Products("Herb", Category.SPICE, 200));
        productsList.put(9, new Products("Curry Spice", Category.SPICE, 300));

        //Display product lists for user
        System.out.println("""
                "Let's go get groceries!" simulator<1.0>
                Choose what you need for dinner...
                """);

        for (int i = 1; i <= productsList.size(); i++) {
            String name = productsList.get(i).getProductName();
            Category category = productsList.get(i).getProductCategory();
            int cost = productsList.get(i).getProductCost();

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
        List<Products> pickedProducts = new ArrayList<>();  //ユーザーが選んだ商品をまとめるリスト

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

            boolean flag;
            do {
                try {
                    System.out.println("\nType one of the numbers from the " + Category.getName() + " category below and press enter.");
                    int categoryKey = scanner.nextInt();
                    if (categoryKey >= rangeMin && categoryKey <= rangeMax) {
                        Products chosenProduct = productsList.get(categoryKey);
                        System.out.println("You chose..." + chosenProduct.getProductName() + "\n");
                        pickedProducts.add(chosenProduct);
                        flag = false;
                    } else {
                        throw new NoSuchKeyException("You can only use <" + rangeMin + "> to <" + rangeMax + ">");
                    }
                } catch (NoSuchKeyException e) {
                    System.out.println(e.getErrMsg());
                    flag = true;
                }
            } while (flag);

        });

        int totalCost = pickedProducts.stream().mapToInt(i -> i.getProductCost()).sum();
        System.out.printf("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                You paid ¥%s at the supermarket!
                Let's go home & cook!!
                ((o(・ρ・)o)) ﾊﾗﾍｯﾀｧ");
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                %n""", totalCost);
    }
}
