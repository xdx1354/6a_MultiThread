import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CirclePanel extends JPanel {

    static final int MIN = 0;
    static final int MAX = 360;
    static final int INIT = 0;
    JSlider slider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
    ArrayList <Circle> circleList = new ArrayList<>();

    CirclePanel(int numberOfCircles){
        this.setSize(500,500);
        this.add(slider);
        slider.setBounds(15,200,50,10);

        distributeCircles(numberOfCircles);
        circleList.forEach(System.out::println);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {                // prevents double performing
                    System.out.println(source.getValue());
                    repaint();
                }
            }
        });
    }


    public void drawCircle(Graphics g, int xCenter, int yCenter, int r) {
        g.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }


    @Override
    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.drawOval(400-150,250-150,2*150,2*150);


        int counter = 0;
        for(Circle c:circleList){
            counter++;
            System.out.println("NUMBER: " + counter +  " ANGLE BEFORE:   " + c.getAngle());
            c.generatePosOnCircle();
            drawCircle(comp, (int) c.getxPos(), (int) c.getyPos(),50);
            System.out.println("NUMBER: " + counter +  " ANGLE AFTER:   " + c.getAngle() + "\n");
        }
        //System.out.println(circleList);
    }

    public void update(Graphics g){
        super.paintComponent(g);
    }

    private void distributeCircles ( int n ){
        double angle = 360.0/(n);
        for(int i = 0; i<n; i++){
            double newAngle = angle*i;
            Circle circle = new Circle(i, newAngle);
            circle.generatePosOnCircle();
            System.out.println("ANGLE   " + newAngle + " i:  " + i);
            circleList.add(circle);
        }
    }

    public boolean canCircleMove(int i, int j){

        double distance = Math.sqrt(Math.pow((circleList.get(i).getxPos() - circleList.get(j).getxPos()),2 ) + Math.pow((circleList.get(i).getyPos() - circleList.get(j).getyPos()),2 ));

        if(distance<=100){
            return false;
        }
        return true;
    }
}
