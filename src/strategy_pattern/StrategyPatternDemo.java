//This example is taken from tutorialspoint.com
//
interface Strategy {
    public int doOperation (int numm1, int num2);
}

class OperationAdd implements Strategy {
    public int doOperation ( int num1, int num2 ) {
        return num1 + num2 ;
    }
}

class OperationSubstract implements Strategy {
    public int doOperation (int num1, int num2) {
         return num1 - num2 ;
    }
}

class OperationMultiply implements Strategy {
    public int doOperation ( int num1, int num2 ) {
        return num1 * num2 ;
    }
}


class Context {
    Strategy strategy ;
    
    Context (Strategy strategy ) {
        this.strategy = strategy ;
    }

    public int executeStrategy (int num1, int num2 ) {
       return  strategy.doOperation (num1,  num2 );
    }

}


public class StrategyPatternDemo {
    public static void main (String [] args) {
        Context context ;
        context = new Context (new OperationAdd());
        System.out.println("The add operation is the :  " + context.executeStrategy(5, 10));
        
        context = new Context(new OperationSubstract());
        System.out.println("The substract operation is : " + context.executeStrategy(5, 10)) ;
    
        context = new Context (new OperationMultiply());
        System.out.println("The multiply is :  " +  context.executeStrategy (5, 10 ));    

    }
} 



