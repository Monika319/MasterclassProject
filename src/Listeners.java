import com.visutools.nav.bislider.BiSlider;
import com.visutools.nav.bislider.BiSliderEvent;
import com.visutools.nav.bislider.BiSliderListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by monika03 on 22.05.15.
 */
public class Listeners {
    SliderListener sliderListener;
    FitListener fitListener;
    FinishListener finishListener;
    static ConfirmListener confirmListener;
    static String nameSurname;
    static String collision;


    Listeners() {

        fitListener = new FitListener();
        sliderListener = new SliderListener();
        finishListener = new FinishListener();
        confirmListener = new ConfirmListener();

    }


}

class FinishListener implements ActionListener {

    FinishListener() {
        super();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new AskForData();

    }
}


class AskForData {
    private JButton confirmButton;
    static JTextField nameField;
    static JTextField lastNameField;
    static JTextField collisionField;
    GetDataListener getDataListener;

    AskForData() {
        initialize();
    }

    void initialize() {
        JFrame askFrame = new JFrame();
        askFrame.setTitle("Personal data");
        askFrame.setPreferredSize(new Dimension(680, 150));
        getDataListener = new GetDataListener();


        confirmButton = new JButton("confirm");
        confirmButton.addActionListener(Listeners.confirmListener);


        JLabel nameLabel = new JLabel("First Name:");
        nameField = new JTextField(30);
        nameField.setName("nameField");
        nameField.addActionListener(getDataListener);
        nameLabel.setLabelFor(nameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(30);
        lastNameField.addActionListener(getDataListener);
        lastNameField.setName("lastNameField");
        lastNameLabel.setLabelFor(lastNameField);


        JLabel collisionLabel = new JLabel("Collision type:");
        collisionField = new JTextField(40);
        collisionField.setName("collisionField");
        collisionField.addActionListener(getDataListener);
        lastNameLabel.setLabelFor(collisionField);


        JPanel panel = new JPanel();
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setAutoCreateGaps(true);
        panelLayout.setAutoCreateContainerGaps(true);
        panelLayout.setHorizontalGroup(
                panelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addComponent(nameField)
                        .addComponent(lastNameLabel)
                        .addComponent(lastNameField)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                        .addComponent(collisionLabel)
                                                        .addComponent(collisionField)
                                        )
                                        .addComponent(confirmButton)

                        )
        );
        panelLayout.setVerticalGroup(
                panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLabel)
                                .addComponent(nameField)
                                .addComponent(lastNameLabel)
                                .addComponent(lastNameField)
                                .addComponent(collisionLabel)
                                .addComponent(collisionField))
                        .addGap(30, 30, 30)
                        .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

        );

        askFrame.setContentPane(panel);
        askFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        askFrame.pack();
        askFrame.setVisible(true);


    }
}

class GetDataListener implements ActionListener {
    GetDataListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField dataField = (JTextField) e.getSource();
        dataField.setEnabled(false);
        if (dataField.getText() != null) {
            if (dataField.getName().equals("nameField")) {
                Listeners.nameSurname = null;
                Listeners.nameSurname = dataField.getText();
            } else if (dataField.getName().equals("collisionField")) {
                Listeners.collision = null;
                Listeners.collision = dataField.getText();
            } else {
                if (Listeners.nameSurname != null)
                    Listeners.nameSurname = Listeners.nameSurname + " " + dataField.getText();
            }

        }
    }


}

class ConfirmListener implements ActionListener {


    // private SliderListener gaussSliderListener;
    ConfirmListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        AskForData.collisionField.setEnabled(true);
        AskForData.lastNameField.setEnabled(true);
        AskForData.nameField.setEnabled(true);
        Exercise exercise = new Exercise();

        java.util.List<User> users;


        exercise.insertUser(Listeners.nameSurname, Listeners.collision, Histo.getTotal(), Histo.getBackgroundFit(), Histo.getSignal(), Histo.getMean(), Histo.getSigma());


        users = exercise.selectUsers();
        System.out.println("Users list: ");
        for (User c : users)
            System.out.println(c);

        exercise.closeConnection();


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