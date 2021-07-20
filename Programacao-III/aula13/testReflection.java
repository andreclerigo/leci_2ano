package aula13;

import java.lang.reflect.*;
import java.util.*;

public class testReflection {
    public static void main(String[] args) throws Exception {
        Cereal obj = new Cereal("Trigo", 10, 100, 20);
        Class<?> objClass = obj.getClass();
        Method[] methods = objClass.getMethods();
        Field[] fields = objClass.getFields();
        Constructor<?>[] constructors = objClass.getConstructors();
        Parameter[] parameters;

        List<Object> objectList = new ArrayList<>();

        System.out.println("Metodos da Class: ");
        Arrays.stream(methods).forEach(m -> System.out.println(m.getName()));

        System.out.println("\nCampos da Class: ");
        Arrays.stream(fields).forEach(f -> System.out.println(f.getType().getSimpleName() + ": " + f.getName()));

        System.out.println("\nConstrutor da Class: ");
        Arrays.stream(constructors).forEach(x -> System.out.println(x.getName()));

        parameters = constructors[0].getParameters();
        System.out.println("\nParametros do Construtor: ");
        Arrays.stream(parameters).forEach(x -> System.out.println(x.getName() + " : " + x.getType().getSimpleName()));

        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuantos objectos do tipo " + objClass.getName() + " deseja criar?");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Class<?>[] paramTypes = { String.class, Double.TYPE, Double.TYPE, Double.TYPE };
            Constructor<?> cons = objClass.getConstructor(paramTypes);
            Object arr[] = new Object[parameters.length];
            System.out.print(paramTypes[0] + ": ");
            arr[0] = sc.nextLine();

            for (int j = 1; j < parameters.length; j++) {
                System.out.print(paramTypes[j] + ": ");
                arr[j] = Double.parseDouble(sc.nextLine());
            }
            objectList.add(cons.newInstance(arr));
        }
        objectList.stream().forEach(x -> System.out.println(x.toString()));

        System.out.println("Que metodo quer implementar?");
        String op = sc.nextLine();
        Method chosen = null;
        for (Method m : methods) {
            if (m.getName().equals(op)) {
                chosen = m;
            }
        }
        final Method finalChosen = chosen;

        if (chosen == null) {
            System.out.println("Unrecognized method."); 
            System.exit(0);
        }

        objectList.stream().forEach(x -> {
            try {
                System.out.println(finalChosen.invoke(x));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        sc.close();
    } 
}
