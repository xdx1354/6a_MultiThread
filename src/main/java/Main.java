import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main implements Runnable{

    ArrayList<Thread> threadList = new ArrayList<>();

    private void generateThreadList(int numberOfCircles, SliderPanel sliderPanel, CirclePanel circlePanel){
        for(int i =0; i< numberOfCircles; i++){
            int finalI = i;

            Thread t = new Thread(()->{
                while (Thread.currentThread() == threadList.get(finalI)){
                     // CO GDY SA TYLKO 2 kółka??
                    if(finalI==numberOfCircles-1){
                        if(circlePanel.canCircleMove(finalI,0)){
                            circlePanel.circleList.get(finalI).setAngle((circlePanel.circleList.get(finalI).getAngle() + sliderPanel.slidersList.get(finalI).getValue()/100.0)%360);
                            circlePanel.repaint();
                            System.out.println("current slider: " + sliderPanel.slidersList.get(finalI).getValue());
                        }
                    }
                    else{
                        if(circlePanel.canCircleMove(finalI,finalI+1)){
                            circlePanel.circleList.get(finalI).setAngle((circlePanel.circleList.get(finalI).getAngle() + sliderPanel.slidersList.get(finalI).getValue()/100.0)%360);
                            circlePanel.repaint();
                            System.out.println("current slider: " + sliderPanel.slidersList.get(finalI).getValue());
                        }
                    }






                    try{
                        Thread.sleep(20);
                    }
                    catch (InterruptedException e){
                        System.out.println ( "Exception: " + e.getMessage() );
                    }
                }
            });
            threadList.add(t);
            t.start();
        }
    }


    public static void main(String[] args) {
        int numberOfCircles = 3;
        CirclePanel circlePanel = new CirclePanel(numberOfCircles);

        SliderPanel sliderPanel = new SliderPanel(numberOfCircles);
        circlePanel.setBackground(Color.yellow);
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(circlePanel,BorderLayout.CENTER);
        frame.add(sliderPanel,BorderLayout.SOUTH);
        frame.setVisible(true);
        Main main = new Main();
        main.generateThreadList(numberOfCircles, sliderPanel, circlePanel);


        //  SwingUtilities.invokeLater(new Main());
    }

    @Override
    public void run() {

    }
}