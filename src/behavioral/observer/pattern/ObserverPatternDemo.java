//This example is taken from tutorialspoint.com import java.util.List; import java.util.ArrayList;
package behavioral.observer.pattern;

import java.util.ArrayList;
import java.util.List;
class Subject {
    public List< Observer> observers = new ArrayList<>();
    public int stat;

    public void attach (Observer observer ) {
        observers.add(observer);
    }
    
    public int getStat () {
        return stat;
    }
    public void setStat(int stat ) {
        this.stat = stat;
        notifyAllObservers();
    }

    public void notifyAllObservers () {
        for ( Observer observer : observers ) {
            observer.update();
        }
    }

}


abstract class Observer {
    Subject subject ;
    public void update () {}
}

class BinaryObserver extends Observer {
    
    public BinaryObserver (Subject subject )  {
       this.subject = subject ; 
       this.subject.attach(this);
    }

    public void update () {
        System.out.println("The velue of stat in BinaryObserver is : " + subject.getStat());
   }
}

class OctalObserver extends Observer {
    public OctalObserver ( Subject subject ) {
        this.subject = subject ;
        this.subject.attach(this);
    }

    public void update () {
        System.out.println("The value of stat in OctalObserver class is : " +  subject.getStat());
    }
}

class HexaObserver extends Observer { 
    public HexaObserver (Subject subject ) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update () {
        System.out.println("The value of stat in HexaObserver class is " + subject.getStat());
    }
}

public class ObserverPatternDemo { public static void main (String[] args) {
        Subject subject = new Subject ();
        
        new BinaryObserver (subject);   
        new OctalObserver (subject) ;
        new HexaObserver (subject);
    
        System.out.println("First state change is  5 ");
        subject.setStat(5);
        
        System.out.println("Second state change is 10");  
        subject.setStat(10);    
    }
}

