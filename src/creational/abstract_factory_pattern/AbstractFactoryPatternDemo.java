//This code is taken from tutorialspoint.com
interface Shape {
   void draw();
}

interface Color {
    void fill();
}
//--------------------------------------------------------------------

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Inside Rectangle :: draw() method ");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Inside Square :: draw() method ");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Inside Circle :: draw() method");
    }
}


class Red implements Color {
    public void fill() {
        System.out.println("Inside Color :: fill() method ");
    }
}

class Green implements Color {
    public void fill() {
        System.out.println("Inside Green :: fill() method ");
    }
}

class Blue implements Color {
    public void fill() {
        System.out.println("Inside Blue :: fill() method ");
    }
}
//--------------------------------------------------------------------



abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType );
    public abstract Color getColor(String colorType );
}
   
class ShapeFactory extends AbstractFactory {
    //public static void getShape (){
    public  Shape  getShape (String shapeType  ){
        if (shapeType == null ) {
            return null;
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle ();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("circle")){
            return new Circle ();
        }else {
            return null;
        }
    }
    public Color getColor (String colorType ) {
        return null;
    }
}

class ColorFactory extends AbstractFactory {
    // public static  void getColor () {
    public Color getColor (String colorType ) {
        if (colorType == null ) {
            return null;
        } else if (colorType.equalsIgnoreCase ("red")) {
            return new Red ();
        } else if (colorType.equalsIgnoreCase ("green")) {
            return new Green ();
        } else if (colorType.equalsIgnoreCase("blue")) {
            return new Blue ();
        } else {
            return null;
        }
    }
    public Shape getShape (String shapeType) {
        return null;
    }

}


class FactoryProducer {
   public static  AbstractFactory getFactory(String choice) {
        if (choice == null ) {
            return null;
        }else  if (choice.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        } else {
            return null;
        }
    }
}

//--------------------------------------------------------------------


public class AbstractFactoryPatternDemo {
    public static void main (String [] args ) {
       // AbstractFactory abf = FactoryProducer.getFactory("shape");
       // abf.getShape("circle");
        FactoryProducer.getFactory("shape").getShape("circle").draw();

        AbstractFactory abf2 = FactoryProducer.getFactory("color") ;
        abf2.getColor("green").fill();
    }
}





 
