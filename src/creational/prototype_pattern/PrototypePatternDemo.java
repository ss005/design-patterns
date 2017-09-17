//This example is taken from tutorialspoint.com
//
//Prototype pattern is requied when object creation is very expensive 
//In that case we use already pre-configured object 
import java.util.Hashtable;
abstract class Shape implements Cloneable {
    private String id;
    protected String type;
   
     public void setId (String id) {
        this.id = id;
    } 
    public String getId () {
        return this.id;
    }
    // setType() :  type will be set in the implementing classes in their constructor .
    public String getType () {
        return this.type;
    }

     abstract void draw();

    public Object clone () {
        Object clone = null;
        
        try {
            clone =  super.clone();
       } catch (CloneNotSupportedException ce) {
            System.out.println("your object is not clonable ");
        }

        return clone ;
    } 
}

class Rectangle extends Shape {
    public Rectangle () {
        type = "Rectangle";
    }
    public void draw () {
        System.out.println("Insie Rectangle :: draw() method ");
    }
}
class Square extends Shape {
    public Square () {
        type = "Square";
    }
    public void draw() {
        System.out.println("Inside Square :: draw() method ");
    }
}
class Circle extends Shape {
    public Circle () {
        type = "Circle";
    }
    public void draw () {
        System.out.println("Inside Circle :: draw() method ");
    }
}



class CachedShape {
    private static Hashtable <String, Shape > hashTable = new Hashtable <String , Shape > ();

    public static void loadCache () {
        Circle circle = new Circle ();
        circle.setId ("1");
        hashTable.put(circle.getId(),  circle );

        Square square  = new Square();
        square.setId("2");
        hashTable.put(square.getId(), square );

        Rectangle rectangle = new Rectangle ();
        rectangle.setId ("3");
        hashTable.put(rectangle.getId(), rectangle);

     }
        
    
   public static  Shape getCache (String id) {
        return (Shape) hashTable.get(id).clone();
    }
}
public class PrototypePatternDemo {
    public static void main(String[] args ) {

        CachedShape.loadCache();

        Shape clonedShape1 = CachedShape.getCache("1"); 
        System.out.println(clonedShape1.getType());

        Shape clonedShape2 = CachedShape.getCache("2");
        System.out.println(clonedShape2.getType());

        Shape clonedShape3 = CachedShape.getCache("3");
        System.out.println(clonedShape3.getType());

    }
} 

