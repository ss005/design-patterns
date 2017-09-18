//------------------ Components start here -----------------------
abstract class Beverage {
    String description = "Unknown Beverage" ;
    public String getDescription() {  // getDescritption is already implemented, no need to re-implement it...
        return description; 
    }
    public abstract double getCost() ;
}

class Espresso extends Beverage {
    public Espresso () {
        description = "Espresso" ;
    }
    public double getCost () {
        return 1.0;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend () {
        description = "HouseBlend";
    }
    public double getCost () {
        return 2.0 ;
    }
}
// ------------------------- Components end here -------------------

//-------------------------- Decorators start here -----------------
abstract class CondimentDecorator extends Beverage { // NOTE : IS-A relationship
    Beverage beverage ;  //NOTE : HAS-A relationship
    public abstract String getDescription () ;   // We need to implement the getDesciption in decorators, as we want to show : componenet + decorator as a description ...
}

class Mocha extends CondimentDecorator { 
    public Mocha (Beverage b) {
        beverage = b;
       description = "Mocha" ;
    }
    public String getDescription () {
        return this.beverage.getDescription() + " " + this.description ;
    }
    public double getCost() {
        return this.beverage.getCost() + 0.5 ;
    }
}
class Soy extends CondimentDecorator {
    public Soy(Beverage b) {
        this.beverage = b;
        this.description = "Soy" ;
    }
    public String getDescription () {
        return this.beverage.getDescription() + " " + this.description ;
    }
    public double getCost () {
        return this.beverage.getCost() + 0.25 ;
    }
}

//--------------------------- Decorators end here --------------------

//Client class 
public class DecoratorPatternDemo {
    public static void main ( String [] args ) {
        
        //Simple beverage 
        Beverage beverage = new Espresso ();
        System.out.println(beverage.getDescription () + ", Cost : $" + beverage.getCost() );

       //Beverage with decorator 
        CondimentDecorator decorator = new Mocha ( new Espresso());
        System.out.println(decorator.getDescription () + ", Cost : $" + decorator.getCost() );

        //Beverage with some another decorator 
        CondimentDecorator decorator2 = new Soy (new Mocha (new HouseBlend()));
        System.out.println(decorator2.getDescription () + ", Cost : $" + decorator2.getCost() );
    }
}


