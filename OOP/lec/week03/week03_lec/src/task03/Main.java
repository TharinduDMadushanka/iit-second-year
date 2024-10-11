package task03;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.makeSound();

        Cat cat = new Cat();
        cat.makeSound();

        Dog dog = new Dog();
        dog.makeSound();

        /**
         * The instanceof keyword checks whether an object is an instance of a specific class or an interface.
         * The instanceof keyword compares the instance with type. The return value is either true or false.
         */

        System.out.println(cat instanceof Animal);  //true
        System.out.println(cat instanceof Cat); //true
        System.out.println(cat instanceof Object);  //true
//        System.out.println(cat instanceof Dog); // false gives an error

    }
}
