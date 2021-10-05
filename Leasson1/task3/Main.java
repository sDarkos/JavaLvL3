package Leasson1.task3;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> boxApples = new Box<>();
        Box<Apple> boxApplesTwo = new Box<>();
        Box<Orange> boxOranges = new Box<>();

        boxApples.addFruits(apple);
        boxApples.addFruits(apple);
        boxApples.addFruits(apple);
        boxOranges.addFruits(orange);
        boxOranges.addFruits(orange);
        boxApplesTwo.addFruits(apple);
        boxApplesTwo.addFruits(apple);

        System.out.println("Равенство первой коробки яблок и апельсинов: " + boxApples.compare(boxOranges));
        System.out.println("Равенство второй коробки яблок и апельсинов: " + boxApplesTwo.compare(boxOranges));

        System.out.println("_________________________");

        System.out.println("колиичество яблок в первой коробке: " + boxApples.getCount());
        System.out.println("колиичество яблок во второй коробке: " + boxApplesTwo.getCount());

        boxApples.rotate(boxApplesTwo);

        System.out.println("пересыпаем....");

        System.out.println("колиичество яблок в первой коробке: " + boxApples.getCount());
        System.out.println("колиичество яблок во второй коробке: " + boxApplesTwo.getCount());
    }
}
