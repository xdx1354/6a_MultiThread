import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class SliderPanel extends JPanel {

    ArrayList<JSlider> slidersList = new ArrayList<>();
    JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);

    SliderPanel(int n){
        this.setSize(500,300);
        this.setLayout(new FlowLayout());
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 25));
        this.setBackground(new Color(12,23,34));
        for(int i=0; i<n; i++){ //Tworze liste sliderow - jest ich tyle ile generowanych kołek
            JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
            //jSlider.setBounds(20 + (800/n+1)*i,150,(800/n) - 10, 10);
            jSlider.addChangeListener(new SliderAdjusted());
            jSlider.setName(String.valueOf(i));
            slidersList.add(jSlider);
            this.add(jSlider);
        }
    }

    class SliderAdjusted implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e){
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {                // prevents double performing
                System.out.println(source.getValue());
                int sliderID=0;
                for(JSlider slider: slidersList){
                    if(slider==source){
                        break;
                    }
                    sliderID++;
                }
            }

        }
    }


}
