package aula10;

public class Test {
    public static void main(final String[] args) throws Exception {
        BinarySearchTree<Integer> numbers = new BinarySearchTree<>();

        numbers.insert(0);
        numbers.insert(3);
        numbers.insert(-3);
        numbers.insert(2);
        numbers.insert(-2);

        for (Integer i : numbers) {
            System.out.println(i);
        }

    }
}
