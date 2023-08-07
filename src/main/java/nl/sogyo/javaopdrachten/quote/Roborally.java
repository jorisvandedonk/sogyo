class Robot {
    int positionX;
    int positionY;
    String facing;

    public Robot(int positionX, int positionY, String facing) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.facing = facing;
    }

    public void printState() {
        System.out.println("PositionX: " + positionX + ", PositionY: " + positionY + ", Facing: " + facing);
    }

    public void turnLeft() {
        if (facing == "North") {
            facing = "West";
        } else if (facing == "West") {
            facing = "South";
        } else if (facing == "South") {
            facing = "East";
        } else if (facing == "East") {
            facing = "North";
        } 
        }
        
        public void turnRight() {
        if (facing == "North") {
            facing = "East";
        } else if (facing == "East") {
            facing = "South";
        } else if (facing == "South") {
            facing = "West";
        } else if (facing == "West") {
            facing = "North";
        } 
        }
        
        public void forward() {
        forward(1);
        }
        
        public void forward(int speed) {
            if (facing =="North") {
                positionY += speed;
            } else if (facing == "West") {
                positionX -= speed;
            } else if (facing == "South") {
                positionY -= speed;
            } else if (facing == "East") {
                positionX += speed;
            }
            
            
         
        }
        
           public void backward() {
        backward(1);
        }
        
        public void backward(int speed) {
            if (facing =="North") {
                positionY -= speed;
            } else if (facing == "West") {
                positionX += speed;
            } else if (facing == "South") {
                positionY += speed;
            } else if (facing == "East") {
                positionX -= speed;
            }
            
            
         
        }
    }


public class Roborally {
    public static void main(String[] args) {
        Robot myFirstRobot = new Robot(0, 1, "East");
        Robot mySecondRobot = new Robot(1, 0, "West");

        myFirstRobot.printState();
        myFirstRobot.turnLeft();
        myFirstRobot.printState();
        myFirstRobot.forward();
        myFirstRobot.printState();
    }
}
