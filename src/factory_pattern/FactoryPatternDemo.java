// Below example is taken from tutorialspoint.com
//
interface Shape {
    void draw();
}

interface Color {
    void fill();
}
//----------------------------------------------------------------

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Inside Rectangle :: draw() method");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Inside Square :: draw() method");
    }
}

class Circle implements Shape {
    public void draw () {
        System.out.println("Inside Circle :: draw() method");
   }
}



class Red implements Color {
    public void fill () {
        System.out.println("Inside Red :: fill() method");
    }
}

class Green implements Color {
    public void fill() {
        System.out.println("Inside Circle :: fill() method");
    }
}

class Blue implements Color {
    public void fill() {
        System.out.println("Inside Circle :: fill() method");
    }
}

//----------------------------------------------------------------


class ShapeFactory {
    public static Shape getShape(String shapeType) {
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
}

class ColorFactory {
    public static Color getColor(String colorType ) {
        if (colorType == null ) {
            return null;
        } else if (colorType.equalsIgnoreCase ("red")) {
            return new Red ();
        } else if (colorType.equalsIgnoreCase ("green")) {
            return new Green ();
        } else if (colorType.equalsIgnoreType("blue")) {
            return new Blue ();
        } else {
            return null;
        }
    }
}

//----------------------------------------------------------------


public class FactoryPatternDemo {
    public static void main (String [] args ) {
       Shape shape =  ShapeFactory.getShape("circle");;
       Color color =  ColorFactory.getColor("Red");; shape.draw();
        color.fill();
    }
}    



