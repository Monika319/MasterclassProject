import com.visutools.nav.bislider.BiSlider;
import com.visutools.nav.bislider.BiSliderEvent;
import com.visutools.nav.bislider.BiSliderListener;



/**
 * Created by monika03 on 22.05.15.
 */
public class Listeners {
    SliderListener sliderListener;


    Listeners() {
        sliderListener = new SliderListener();
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