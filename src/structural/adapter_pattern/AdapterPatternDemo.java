package structural.adapter_pattern;

interface ITarget {
    public void request ();
}

class ConcreteTarget implements ITarget {
    public ConcreteTarget () {
        //instance initialization code...
    }

    public void request() {
        System.out.println("This is US, you will get 120 volts, and 50 Hz frequency..." );
    }
}

interface IAdaptee {
    public void specificRequest() ;
} 

class ConcreteAdaptee implements IAdaptee {
    public ConcreteAdaptee() {
        //initialization code ...
    }

    public void specificRequest() {
        System.out.println("This is some specific country, you will get 240 volts, 60 Hz frequency,,, ");
    }
}


//Now Client is cpmpatible with ITarget interface and can call request method, but he need 240 volts and 60 Hz frequency,,,
//For this, we have to create Adapter class ... 
class Adapter implements ITarget {
    //composes adaptee 
    private IAdaptee adaptee ;

    public Adapter (IAdaptee adaptee ) {
        this.adaptee = adaptee ;
    }

    public void request () {
        this.adaptee.specificRequest();
    }
}



//Now the client code ...

public class AdapterPatternDemo {
    public static void main (String [] args) {
        ITarget target  = new ConcreteTarget();
        target.request();

        ITarget target2 = new Adapter(new ConcreteAdaptee());    
        target2.request();
    }
}



