interface CallingDevice {
    public void isNumberValid();
    public void isNumberExists();
    public void isEnoughBalance();
    public void call();
}


class MobilePhone implements CallingDevice {
    public void isNumberValid () {
        //logic to check if number is valid ...suppose the number is valid for now 
        System.out.println("The number is valid");
    }
    public void isNumberExists() { 
        //logic to check if number exists  or not ... Suppose for now number is vlaid 
        System.out.println("The number exists");
    }
    public void isEnoughBalance () {
        //logic to check if there is enough balance to make this call...Suppose for now balance is enough ,,,
        System.out.println("You have enough balance to make this call");
    }

    public void call(){
        isNumberValid();
        isNumberExists();
        isEnoughBalance();
    
        System.out.println("Making your call...");
    }

}

class MobilePhoneFacade {
    protected CallingDevice device ;
    public MobilePhoneFacade(CallingDevice device) {
        this.device = device ;
    }
    public void makeCall() {
        this.device.call();
    }
        
}

public class FacadePatternDemo {
    public static void main (String [] args) {
        MobilePhoneFacade facade = new MobilePhoneFacade(new MobilePhone());  //Client does not need to know all the hidden implementataion (i.e. underlying subsystems)
        facade.makeCall();
    }
}


    
