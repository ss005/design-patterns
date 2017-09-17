//This example is taken from newthinktank.com
//
package facade_pattern;

class WelcomeToBank {
    public WelcomeToBank () {
        System.out.println("Welcome to ABC bank ... ");
        System.out.println("You can take money if you have in account...");
    }
}

class AccountNumberCheck {
    private int accountNumber ;
    public int getAccountNumber () {
        return accountNumber;
    }

    public boolean isAccountActive (int accountNumToCheck) {
        if (getAccountNumber () == accountNumToCheck)
            return true;
        else 
            return false;
         
   }
}

class SecurityCodeCheck {
    private int securityCode = 1234;

    publid int getSecurityCode () {
        return securityCode ;
    } 
    pubkic boolean isCodeCorrect (int secCodeTocheck) {
        if (getSecurityCode() == seccodeToCheck) 
            return true;
        else 
            return false;
    }
}


class FundCheck {
    private  double cashInAccout n= 1000.00;
  
    public double  getCashInAccount () {
        return cashInAccount;
    }
    public 
    
