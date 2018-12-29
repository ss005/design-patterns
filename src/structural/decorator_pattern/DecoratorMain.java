package structural.decorator_pattern;

/**
 * Decorator pattern lets you dynamically change the behaviour of an object at run time
 * by wrapping then in an object of a decorator object. <p>
 * Used in libraries : <p>
 * Java file streams claases : InputStream, OutputStrem, Reader, Writer <br>
 * Collections classes : synchronizedXxx(), unmodifiableXxx()
 */

interface Coffee {
    double getPrice();

    String getDescription();
}

class SimpleCoffee implements Coffee {
    public SimpleCoffee() {

    }

    @Override
    public double getPrice() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

class MilkCoffee implements Coffee {
    private Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 5;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }
}

class SpecialCoffee implements Coffee {
    private Coffee coffee;

    public SpecialCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 10;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Specials...";
    }
}

public class DecoratorMain {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getPrice() + " " + simpleCoffee.getDescription());

        Coffee milkCoffee = new MilkCoffee(simpleCoffee);
        System.out.println(milkCoffee.getPrice() + " " + milkCoffee.getDescription());

        Coffee specialCoffee = new SpecialCoffee(milkCoffee);
        System.out.println(specialCoffee.getPrice() + " " + specialCoffee.getDescription());


        System.out.println("-------------------------------");
        SpecialCoffee specialCoffee1 = new SpecialCoffee(new MilkCoffee(new SimpleCoffee()));
        System.out.println(specialCoffee1.getPrice() + " " + specialCoffee1.getDescription());

    }
}
