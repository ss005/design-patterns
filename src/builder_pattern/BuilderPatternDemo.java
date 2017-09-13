interface RobotPlan { public void setRobotHead (String robotHead);
    public void setRobotTorso(String robotTorso);
    public void setRobotArms (String robotArms );
    public void setRobotLegs(String robotLegs);
}

class Robot implements RobotPlan {
    private String robotHead;
    private String robotTorso;
    private String robotArms;
    private String robotLegs;

    public void setRobotHead (String robotHead) {
        this.robotHead = robotHead;
    }
    public String getRobotHead() {
        return this.robotHead;
    }

    public void setRobotTorso(String robotTorso) {
        this.robotTorso = robotTorso;
    }
    public String getRobotTorso() {
        return this.robotTorso;
    }

    public void setRobotArms(String robotArms) {
        this.robotArms = robotArms ;
    }
    public String getRobotArms() {
        return this.robotArms ;
    }

    public void setRobotLegs (String robotLegs ) {
        this.robotLegs = robotLegs;
    }
    public String getRobotLegs() {
        return this.robotLegs;
    }

}


interface RobotBuilder {
    public void buildRobotHead();
    public void buildRobotTorso();
    public void buildRobotArms();
    public void buildRobotLegs();
    public Robot getRobot();
}

class OldRobotBuilder implements RobotBuilder {
    private Robot robot ;
    public OldRobotBuilder() {
        this.robot = new Robot(); 
    }

    public void  buildRobotHead() {
        robot.setRobotHead("Tin Head");
    }
    public void buildRobotTorso() {
        robot.setRobotTorso("Tin Torso");
    }
    public void buildRobotArms () {
        robot.setRobotArms("Tin Arms");
    }
    public void buildRobotLegs() {
        robot.setRobotLegs ("Tin Legs");
    }


    public Robot getRobot() {
        return this.robot;
    }
}

class RobotEngineer {
    private RobotBuilder robotBuilder;
    
    public RobotEngineer(RobotBuilder robotBuilder) {
        this.robotBuilder = robotBuilder;
    }

    public void makeRobot () {
        robotBuilder.buildRobotHead();
        robotBuilder.buildRobotTorso();
        robotBuilder.buildRobotArms();
        robotBuilder.buildRobotLegs();
    }

    public Robot getRobot() {
        return this.robotBuilder.getRobot();
    }
}


public class BuilderPatternDemo {
    public static void main (String [] args ) {
        RobotBuilder oldStyleRobot = new OldRobotBuilder ();        
        RobotEngineer robotEngineer = new RobotEngineer(oldStyleRobot);
        
        robotEngineer.makeRobot();
       Robot firstRobot =  robotEngineer.getRobot();
        
        System.out.println("Robot Built...");
        System.out.println("Robot Head Type : " + firstRobot.getRobotHead());
        System.out.println("Robot Torso Type : " + firstRobot.getRobotTorso());
        System.out.println("Robot Arms Tyep : " + firstRobot.getRobotArms());
        System.out.println("Robot Legs Type : " + firstRobot.getRobotLegs());
    }
}





