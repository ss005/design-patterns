package creational.builder.pattern;

/**
 * Allows to create different types of object while avoiding constructor pollution <p>
 * Used in libraries : <p>
 * StringBuilder # append <br>
 * StringBuffer # append <br>
 * Stream # builder <br>
 * ReponseBuilder # build
 */

class Pizza {
    int size = 0;
    boolean cheese;
    boolean peepperoni;
    boolean tomato;
    boolean extraCheese;

    /**
     * instead of writing different combinations of constructor we will write one constructor and use
     * builder pattern
     *
     * @param builder
     */
    public Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.peepperoni = builder.peepperoni;
        this.tomato = builder.tomato;
        this.extraCheese = builder.extraCheese;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", cheese=" + cheese +
                ", peepperoni=" + peepperoni +
                ", tomato=" + tomato +
                ", extraCheese=" + extraCheese +
                '}';
    }
}

class PizzaBuilder {

    public int size;
    boolean cheese = false;
    boolean peepperoni = false;
    boolean tomato = false;
    boolean extraCheese = false;

    public PizzaBuilder(int size) {
        this.size = size;
    }

    public PizzaBuilder addCheese() {
        this.cheese = true;
        return this;
    }

    public PizzaBuilder addPeepperoni() {
        this.peepperoni = true;
        return this;
    }

    public PizzaBuilder addTomato() {
        this.tomato = true;
        return this;
    }

    public PizzaBuilder addExtraCheese() {
        this.extraCheese = true;
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}

class BuilderMain {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder(10).addCheese().addPeepperoni().addExtraCheese().build();
        System.out.println(pizza);
    }
}
