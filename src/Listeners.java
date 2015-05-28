import com.visutools.nav.bislider.BiSlider;
import com.visutools.nav.bislider.BiSliderEvent;
import com.visutools.nav.bislider.BiSliderListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by monika03 on 22.05.15.
 */
public class Listeners {
    SliderListener sliderListener;
    FitListener fitListener;
    // private static int fitCounter=0;


    Listeners() {

        fitListener = new FitListener();
        sliderListener = new SliderListener();
    }


}

class FitListener implements ActionListener {


    // private SliderListener gaussSliderListener;
    FitListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Histo.FunctionFitter(Histo.minGaussRange, Histo.maxGaussRange, Histo.minPolyRange, Histo.maxPolyRange);
        Exercise exercise = new Exercise();

        java.util.List<User> users;


        exercise.insertUser("Monika Seniut", "Pb-Pb", Histo.total, Histo.background, Histo.signal, Histo.mean, Histo.sigma);
        exercise.insertUser("Piotr Wojtecki", "PbPb-K0", Histo.total, Histo.background, Histo.signal, Histo.mean, Histo.sigma);
        exercise.insertUser("Abdul Dabdul", "PbPb-Lambda", Histo.total, Histo.background, Histo.signal, Histo.mean, Histo.sigma);
        exercise.insertUser("Monika Seniut", "Pb-Pb", Histo.total, Histo.background, Histo.signal, Histo.mean, Histo.sigma);


        users = exercise.selectUsers();
        System.out.println("Users list: ");
        for (User c : users)
            System.out.println(c);

        exercise.closeConnection();
        //  JButton fitButton = (JButton) actionEvent.getSource();
    }
}

class SliderListener implements BiSliderListener {
    double min;
    double max;


    @Override
    public void newColors(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void newValues(BiSliderEvent biSliderEvent) {
        BiSlider slider = (BiSlider) biSliderEvent.getSource();
        String name = slider.getName();
        System.out.println("jaki to slider: " + name);
        min = slider.getMinimumColoredValue();
        max = slider.getMaximumColoredValue();
        if (name.equals("gaussSlider")) {
            Histo.setMinGaussRange(min);
            Histo.setMaxGaussRange(max);
        } else {
            Histo.setMinPolyRange(min);
            Histo.setMaxPolyRange(max);
        }

    }

    @Override
    public void prepareJumpValues(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void notifyJumpValues(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void newMinValue(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void newMaxValue(BiSliderEvent BiSliderEvent_Arg) {

    }

    @Override
    public void newSegments(BiSliderEvent BiSliderEvent_Arg) {

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