public class Circle {
    private int id;
    //private int angle;
    private double yPos;
    private double xPos;
    private double angle;
    private double startingAngle;
    private double speed;      //predkosc katowa danego kolka wyrazana w stopniach/s a nie rad/s!
    private double offset;
    private static final int radius = 20;

    Circle(int id, double startingAngle){
        this.offset = 0;
        this.speed = 0;     // kołka nie mają sie krecic na poczatku
        this.id = id;
        this.angle = startingAngle;
        this.startingAngle = startingAngle;
        //System.out.println("TEST:    ID: " + this.id + " ANGLE: " + this.angle);
        generatePosOnCircle();

    }
    public int getId() {
        return id;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public double getyPos() {
        return yPos;
    }

    public double getStartingAngle(){
        return  startingAngle;
    }

    public double getxPos() {
        return xPos;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    Circle(int id, double xPos, double yPos){
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "id=" + id +
                ", yPos=" + yPos +
                ", xPos=" + xPos +
                ", angle=" + angle +
                '}';
    }

    public void generatePosOnCircle(){
        double radAngle = Math.toRadians(angle%360);
//        double x = 400;
//        double y = 100;
        double newX = 150 * Math.sin(radAngle);
        double newY = 150 * Math.cos(radAngle);
        //System.out.println("\n newX: " + newX + " newY: " + newY);
        setxPos(400 + newX);
        setyPos(250 + newY);
        //System.out.println("TEST:    ID: " + this.id + " ANGLE: " + this.angle);
    }


}
