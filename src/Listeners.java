import com.visutools.nav.bislider.BiSlider;
import com.visutools.nav.bislider.BiSliderEvent;
import com.visutools.nav.bislider.BiSliderListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by monika03 on 22.05.15.
 */
public class Listeners {
    public SliderListener sliderListener;
    FitListener fitListener;


    Listeners() {

     //   fitListener=new FitListener();
                sliderListener = new SliderListener();
    }


}
class FitListener implements ActionListener {
    private SliderListener gaussSliderListener;
    FitListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         gaussSliderListener= new SliderListener();
    }
}

class SliderListener implements BiSliderListener {
    double min;
    double max;

    @Override
    public void newColors(BiSliderEvent biSliderEvent) {
        BiSlider slider = (BiSlider) biSliderEvent.getSource();
    }

    @Override
    public void newValues(BiSliderEvent biSliderEvent) {
        BiSlider slider = (BiSlider) biSliderEvent.getSource();
        min = slider.getMinimumColoredValue();
        max = slider.getMaximumColoredValue();
        Histo.setMinGaussRange(min);
        Histo.setMaxGaussRange(max);

        // System.out.println(min+" "+max);
    }

    @Override
    public void prepareJumpValues(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void notifyJumpValues(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void newMinValue(BiSliderEvent biSliderEvent) {

    }

    @Override
    public void newMaxValue(BiSliderEvent biSliderEvent) {

    }

    @Override
    public void newSegments(BiSliderEvent biSliderEvent) {
        BiSlider slider = (BiSlider) biSliderEvent.getSource();
    }

    @Override
    public void newMin(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void newMax(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void newGlobalRange(BiSliderEvent BiSliderEvent_Arg) {

    }



}