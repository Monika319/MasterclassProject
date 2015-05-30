import com.visutools.nav.bislider.BiSlider;
import hep.aida.IFitResult;
import hep.aida.IFunction;
import jhplot.*;
import org.apache.commons.math3.special.Erf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Histo extends JFrame implements ActionListener {


    public static void main(String args[]) {
        new Histo();

    }

    private Box.Filler filler1;
    private JComboBox K0ComboBox;
    private JComboBox lambdaComboBox;
    private JComboBox antyLambdaComboBox;
    private JLabel K0Label;
    private JLabel lambdaLabel;
    private JLabel antyLambdaLabel;
    private JLabel bkgLabel;
    private JLabel sigLabel;
    private JLayeredPane jLayeredPane1;
    private JLayeredPane jLayeredPane2;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JLayeredPane jLayeredPane3;
    private JMenuBar jMenuBar;
    private JMenuItem dataset1;
    private JMenuItem dataset2;
    private JMenuItem exit;
    private JPanel loadHistoPanel;
    private JPanel fitPanel;
    private JPanel sendResultsToDatabasePanel;
    private BiSlider gaussSlider;
    private BiSlider polynomialSlider;
    //    private FileReader fr;
    private String filename;
    private static HPlot c1;
    private static HFitter polynomialfitter;
    private static HFitter functionFitter;
    private static F1D fFitGaus;
    private static F1D fFitPolynomial;
    private static int TotalFit;
    private static int signalFit;
    private static int BckFit;
    private static double[] Pars;
    static H1D h1;
    public static double minGaussRange;
    public static double maxGaussRange;
    public static double minPolyRange;
    public static double maxPolyRange;
    public Listeners listeners;
    public static DecimalFormat decimalFormat;
    private JButton fitButton;
    private JButton finishButton;
    public static String[] parsData;
    public static String dataForDatabase;
    private static String backgroundFit, signal, mean, sigma;
    private static String total;


    public Histo() {

        initComponents();


        c1 = new HPlot("Canvas", 600, 400);

        c1.setLegendFont(new Font("Lucida Sans", 1, 18));
        // this.c1.getAntiAlias();
        this.c1.setGTitle("Invariant Mass Distribution");
        // this.c1.setAutoRange();
        this.c1.setNameX("Invariant Mass[GeV]");
        this.c1.setNameY("Counts");
        this.c1.setName("Invariant Mass spectra");
        jLayeredPane3.add(c1.getCanvasPanel());
        // jTabbedPane5.addTab("Invariant Mass", c1.getCanvasPanel());

        read();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jLayeredPane1 = new JLayeredPane();
        jLayeredPane2 = new JLayeredPane();
        loadHistoPanel = new JPanel();
        K0ComboBox = new JComboBox();
        lambdaComboBox = new JComboBox();
        filler1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(0, 32767));
        K0Label = new JLabel();
        lambdaLabel = new JLabel();
        antyLambdaLabel = new JLabel();
        bkgLabel = new JLabel("Bkg range:");
        sigLabel = new JLabel("Sig range:");
        antyLambdaComboBox = new JComboBox();
        fitPanel = new JPanel();
        sendResultsToDatabasePanel = new JPanel();
        jLayeredPane3 = new JLayeredPane();
        jMenuBar = new JMenuBar();
        fileMenu = new JMenu();
        dataset1 = new JMenuItem();
        exit = new JMenuItem();
        dataset2 = new JMenuItem();
        editMenu = new JMenu();
        gaussSlider = new BiSlider();
        polynomialSlider = new BiSlider();
        gaussSlider.setName("gaussSlider");
        polynomialSlider.setName("bcgSlider");
        listeners = new Listeners();
        decimalFormat = new DecimalFormat("#.###");
        fitButton = new JButton("Fit signal+background");
        finishButton = new JButton("Final measurement");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 277, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 363, Short.MAX_VALUE)
        );

        loadHistoPanel.setBorder(BorderFactory.createTitledBorder("V0 histograms"));


        K0Label.setText("K0");
        K0Label.setToolTipText("");

        lambdaLabel.setText("Lambda");
        antyLambdaLabel.setText("AntiLambda");


        K0ComboBox.addItem("pp");
        K0ComboBox.addItem("PbPb");
        K0ComboBox.addItem("PbPb-0-10%");
        K0ComboBox.addItem("PbPb-10-20%");
        K0ComboBox.addItem("PbPb-20-30%");
        K0ComboBox.addItem("PbPb-30-40%");
        K0ComboBox.addItem("PbPb-40-50%");
        K0ComboBox.addItem("PbPb-50-60%");
        K0ComboBox.addItem("PbPb-60-70%");
        K0ComboBox.addItem("PbPb-70-80%");
        K0ComboBox.addItem("PbPb-80-90%");
        K0ComboBox.addItem("PbPb-90-100%");
        lambdaComboBox.addItem("pp");
        lambdaComboBox.addItem("PbPb");
        lambdaComboBox.addItem("PbPb-0-10%");
        lambdaComboBox.addItem("PbPb-10-20%");
        lambdaComboBox.addItem("PbPb-20-30%");
        lambdaComboBox.addItem("PbPb-30-40%");
        lambdaComboBox.addItem("PbPb-40-50%");
        lambdaComboBox.addItem("PbPb-50-60%");
        lambdaComboBox.addItem("PbPb-60-70%");
        lambdaComboBox.addItem("PbPb-70-80%");
        lambdaComboBox.addItem("PbPb-80-90%");
        lambdaComboBox.addItem("PbPb-90-100%");
        antyLambdaComboBox.addItem("pp");
        antyLambdaComboBox.addItem("PbPb");
        antyLambdaComboBox.addItem("PbPb-0-10%");
        antyLambdaComboBox.addItem("PbPb-10-20%");
        antyLambdaComboBox.addItem("PbPb-20-30%");
        antyLambdaComboBox.addItem("PbPb-30-40%");
        antyLambdaComboBox.addItem("PbPb-40-50%");
        antyLambdaComboBox.addItem("PbPb-50-60%");
        antyLambdaComboBox.addItem("PbPb-60-70%");
        antyLambdaComboBox.addItem("PbPb-70-80%");
        antyLambdaComboBox.addItem("PbPb-80-90%");
        antyLambdaComboBox.addItem("PbPb-90-100%");

        GroupLayout loadHistoPanelLayout = new GroupLayout(loadHistoPanel);
        loadHistoPanel.setLayout(loadHistoPanelLayout);
        loadHistoPanelLayout.setHorizontalGroup(
                loadHistoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loadHistoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(loadHistoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(loadHistoPanelLayout.createSequentialGroup()
                                                .addGroup(loadHistoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lambdaLabel)
                                                        .addComponent(antyLambdaLabel))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadHistoPanelLayout.createSequentialGroup()
                                                .addGroup(loadHistoPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(antyLambdaComboBox, GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                                        .addComponent(lambdaComboBox, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(K0Label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.LEADING, loadHistoPanelLayout.createSequentialGroup()
                                                                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(K0ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())))
        );
        loadHistoPanelLayout.setVerticalGroup(
                loadHistoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loadHistoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(K0Label, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(K0ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lambdaLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lambdaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(antyLambdaLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(antyLambdaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fitPanel.setBorder(BorderFactory.createTitledBorder("Fitting panel"));
        sendResultsToDatabasePanel.setBorder(BorderFactory.createTitledBorder("Send to database panel"));
        gaussSlider.setMinimumColor(Color.green);
        gaussSlider.setMaximumValue(2D);
        gaussSlider.setDecimalFormater(new DecimalFormat("#.###"));
        gaussSlider.setVisible(true);

        // gaussSlider.addBiSliderListener(listeners.sliderListener);
        gaussSlider.addBiSliderListener(listeners.sliderListener);
        fitButton.addActionListener(listeners.fitListener);
        finishButton.addActionListener(listeners.finishListener);

        polynomialSlider.setMinimumColor(Color.blue);
        polynomialSlider.setMaximumValue(2D);
        polynomialSlider.setDecimalFormater(new DecimalFormat("#.###"));
        polynomialSlider.addBiSliderListener(listeners.sliderListener);
        polynomialSlider.setVisible(true);
        GroupLayout fitPanelLayout = new GroupLayout(fitPanel);
        GroupLayout results_panelLayout = new GroupLayout(sendResultsToDatabasePanel);
        sendResultsToDatabasePanel.setLayout(results_panelLayout);
        fitPanel.setLayout(fitPanelLayout);


        fitPanel.setLayout(fitPanelLayout);
        fitPanelLayout.setHorizontalGroup(
                fitPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(fitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sigLabel)
                                .addComponent(gaussSlider)
                                .addComponent(bkgLabel)
                                .addComponent(polynomialSlider))
                        .addGroup(fitPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(fitButton)
                                        .addGroup(fitPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                .addComponent(finishButton))
                        )


        );
        fitPanelLayout.setVerticalGroup(
                fitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(fitPanelLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(sigLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gaussSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(bkgLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(polynomialSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(fitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(finishButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                        )
                //possible to give bigger numbers to gaps in order to make window wider

        );


        javax.swing.GroupLayout jLayeredPane2Layout = new GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
                jLayeredPane2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loadHistoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fitPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)


        );
        jLayeredPane2Layout.setVerticalGroup(
                jLayeredPane2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(loadHistoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 19, Short.MAX_VALUE)

                        )
        );
        jLayeredPane2.setLayer(loadHistoPanel, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(sendResultsToDatabasePanel, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(fitPanel, JLayeredPane.DEFAULT_LAYER);

        GroupLayout jLayeredPane3Layout = new GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
                jLayeredPane3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
                jLayeredPane3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        fileMenu.setText("File");

        dataset1.setText("Dataset1");
        fileMenu.add(dataset1);


        dataset2.setText("Dataset2");
        fileMenu.add(dataset2);

        exit.setText("Exit");
        fileMenu.add(exit);

        jMenuBar.add(fileMenu);

        editMenu.setText("Edit");
        jMenuBar.add(editMenu);

        setJMenuBar(jMenuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLayeredPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                        .addComponent(jLayeredPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                        .addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                        .addContainerGap()

                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                                .addGap(0, 0, Short.MAX_VALUE)

                                .addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()

                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)

                                                .addComponent(jLayeredPane2)

                                                .addComponent(jLayeredPane3)


                                )
                                .addGap(0, 21, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>

    public void read() {
        int i;
        K0ComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                K0ComboBox = (JComboBox) e.getSource();
                String s = (String) K0ComboBox.getSelectedItem();

                System.out.print(s);

                if (s.equals("pp")) {
                    plot_hist(0.0D, 1.0D, "pp-K0.txt", 110);
                } else if (s.equals("PbPb")) {
                    plot_hist(0.0D, 1.0D, "PbPb-K0.txt", 1450);
                } else if (s.equals("PbPb-0-10%")) {
                    plot_hist(0.0D, 1.0D, "dataset11.txt", 2600);
                } else if (s.equals("PbPb-10-20%")) {
                    plot_hist(0.0D, 1.0D, "dataset12.txt", 2000);
                } else if (s.equals("PbPb-20-30%")) {
                    plot_hist(0.0D, 1.0D, "dataset13.txt", 1400);
                } else if (s.equals("PbPb-30-40%")) {
                    plot_hist(0.0D, 1.0D, "dataset14.txt", 850);
                } else if (s.equals("PbPb-40-50%")) {
                    plot_hist(0.0D, 1.0D, "dataset15.txt", 420);
                } else if (s.equals("PbPb-50-60%")) {
                    plot_hist(0.0D, 1.0D, "dataset16.txt", 220);
                } else if (s.equals("PbPb-60-70%")) {
                    plot_hist(0.0D, 1.0D, "dataset17.txt", 140);
                } else if (s.equals("PbPb-70-80%")) {
                    plot_hist(0.0D, 1.0D, "dataset18.txt", 60);
                } else if (s.equals("PbPb-80-90%")) {
                    plot_hist(0.0D, 1.0D, "dataset19.txt", 35);
                } else if (s.equals("PbPb-90-100%")) {
                    plot_hist(0.0D, 1.0D, "dataset20.txt", 2.2);
                }
            }
        });

        lambdaComboBox.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                lambdaComboBox = (JComboBox) e.getSource();
                String s = (String) lambdaComboBox.getSelectedItem();

                System.out.print(s);

                if (s.equals("pp")) {
                    plot_hist(1.0D, 2.0D, "pp-Lambda.txt", 150);
                } else if (s.equals("PbPb")) {
                    plot_hist(1.0D, 2.0D, "PbPb-Lambda.txt", 820);
                } else if (s.equals("PbPb-0-10%")) {
                    plot_hist(1.0D, 2.0D, "dataset21.txt", 1200);
                } else if (s.equals("PbPb-10-20%")) {
                    plot_hist(1.0D, 2.0D, "dataset22.txt", 1150);
                } else if (s.equals("PbPb-20-30%")) {
                    plot_hist(1.0D, 2.0D, "dataset23.txt", 850);
                } else if (s.equals("PbPb-30-40%")) {
                    plot_hist(1.0D, 2.0D, "dataset24.txt", 500);
                } else if (s.equals("PbPb-40-50%")) {
                    plot_hist(1.0D, 2.0D, "dataset25.txt", 300);
                } else if (s.equals("PbPb-50-60%")) {
                    plot_hist(1.0D, 2.0D, "dataset26.txt", 150);
                } else if (s.equals("PbPb-60-70%")) {
                    plot_hist(1.0D, 2.0D, "dataset27.txt", 60);
                } else if (s.equals("PbPb-70-80%")) {
                    plot_hist(1.0D, 2.0D, "dataset28.txt", 35);
                } else if (s.equals("PbPb-80-90%")) {
                    plot_hist(1.0D, 2.0D, "dataset29.txt", 10);
                } else if (s.equals("PbPb-90-100%")) {
                    plot_hist(1.0D, 2.0D, "dataset30.txt", 8);
                }
            }
        });

        antyLambdaComboBox.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                antyLambdaComboBox = (JComboBox) e.getSource();
                String s = (String) antyLambdaComboBox.getSelectedItem();

                System.out.print(s);

                if (s.equals("pp")) {
                    plot_hist(1.0D, 2.0D, "pp-AntiLambda.txt", 60);
                } else if (s.equals("PbPb")) {
                    plot_hist(1.0D, 2.0D, "PbPb-AntiLambda.txt", 800);
                } else if (s.equals("PbPb-0-10%")) {
                    plot_hist(1.0D, 2.0D, "dataset31.txt", 1150);
                } else if (s.equals("PbPb-10-20%")) {
                    plot_hist(1.0D, 2.0D, "dataset32.txt", 1100);
                } else if (s.equals("PbPb-20-30%")) {
                    plot_hist(1.0D, 2.0D, "dataset33.txt", 800);
                } else if (s.equals("PbPb-30-40%")) {
                    plot_hist(1.0D, 2.0D, "dataset34.txt", 450);
                } else if (s.equals("PbPb-40-50%")) {
                    plot_hist(1.0D, 2.0D, "dataset35.txt", 270);
                } else if (s.equals("PbPb-50-60%")) {
                    plot_hist(1.0D, 2.0D, "dataset36.txt", 130);
                } else if (s.equals("PbPb-60-70%")) {
                    plot_hist(1.0D, 2.0D, "dataset37.txt", 70);
                } else if (s.equals("PbPb-70-80%")) {
                    plot_hist(1.0D, 2.0D, "dataset38.txt", 25);
                } else if (s.equals("PbPb-80-90%")) {
                    plot_hist(1.0D, 2.0D, "dataset39.txt", 8);
                } else if (s.equals("PbPb-90-100%")) {
                    plot_hist(1.0D, 2.0D, "dataset40.txt", 1.2);
                }
            }
        });

    }


    public void plot_hist(double xMinRange, double xMaxRange, String fileName, double yAxisMax) {
        filename = fileName;


        c1.clearData();
        c1.clearAllLabels();

        // c1.setGrid(getY(), true);
        int number = c1.getNumberOfTics(getY());
        //c1.setNumberOfTics(MAXIMIZED_VERT, 5);
        //	c1.setTicLength(getY(), 50D);
        //	c1.setTextRotationLeft(90);
        System.out.println(Integer.toString(number));
        //this.c1.setMarginSizeLeft(0.1);
//		this.c1.setNumberOfTics(1, 100);
//		this.c1.setTicsRotate(getY(), true);
//		c1.setTextPosTopY(0.01);
//		c1.getTextPosLeftY();
//		c1.getCdY();
        //c1.setMarginSizeLeft(0.3);
        //c1.setAttResizableAll(true);

        //	c1.setLegend(false);
        // c1.clearData();
        //try {
//            fr = new FileReader(name);
//        } catch (FileNotFoundException e) {
//            System.out.println("BÅ?ÄD PRZY OTWIERANIU PLIKU!");
//            System.exit(1);
//        }
//        StreamTokenizer st = new StreamTokenizer(fr);
//        // ODCZYT KOLEJNYCH "TOKENÃW" Z PLIKU:
//        try {
//            while ((wartosc = st.nextToken()) != StreamTokenizer.TT_EOF) {
//                if (wartosc == StreamTokenizer.TT_WORD)
//                    System.out.println("Wczytano sÅowo: " + st.sval);
//                else if (wartosc == StreamTokenizer.TT_NUMBER)
//                    System.out.println("Wczytano liczbÄ: " + st.nval);
//                //h1.fill(st.nval);
//
//            }
//        } catch (IOException e) {
//            System.out.println("BÅ?ÄD ODCZYTU Z PLIKU!");
//            System.exit(2);
//        }


        P0D list_data = new P0D("Histogram", fileName);
        //  ZAMYKANIE PLIKU:
//        try {
//            fr.close();
//        } catch (IOException e) {
//            System.out.println("BÅ?ÄD PRZY ZAMYKANIU PLIKU!");
//            System.exit(3);
//        }

        h1 = list_data.getH1D(400, xMinRange, xMaxRange);

        // H1D h1 = new H1D("Histogram", 100, minx, maxx);

        // Random r = new Random();
        // h1.setFill(true);
        // h1.setFillColor(new Color(r.nextFloat(), r.nextFloat(),
        // r.nextFloat(), 0.5F));
        // h1.setErrX(true);
        // h1.setErrY(true);
        // h1.setPenWidthErr(3);

        // FileReader fr = null;
        // String linia = "";
        // File file = null;

        // h1.setTitle(file.getName());

        // //OTWIERANIE PLIKU:


        // StreamTokenizer st = new StreamTokenizer(fr);
        // ODCZYT KOLEJNYCH "TOKENÃW" Z PLIKU:
        // try {
        // while ((wartosc = st.nextToken()) != StreamTokenizer.TT_EOF) {
        // if (wartosc == StreamTokenizer.TT_WORD)
        // System.out.println("Wczytano sÅowo: " + st.sval);
        // else if (wartosc == StreamTokenizer.TT_NUMBER)
        // System.out.println("Wczytano liczbÄ: " + st.nval);
        // //h1.fill(st.nval);
        //
        // }
//		this.c1.getAntiAlias();
//		this.c1.setAutoRange();
//		this.c1.setNameX("Invariant Mass[GeV]");
//		this.c1.setNameY("Counts");
//		this.c1.setName("Invariant Mass spectra");
        this.c1.setGTitle("Invariant Mass Distribution");
        this.c1.setRange(xMinRange, xMaxRange, 0, yAxisMax);
        //this.c1.setTicLabels(true);
        this.c1.setLegendPos(WIDTH, HIDE_ON_CLOSE);
        this.c1.draw(h1);
        this.c1.drawStatBox(h1, 300, 50);
        this.c1.refreshFrame();

    }

    static void FunctionFitter(double minGauss, double maxGaus, double minPoly,
                               double maxPoly) {

        if (fFitGaus != null) {
            c1.clearAllData();
            c1.draw(h1);
            System.out.println("gausslinestyle :" + c1.getData().toString());
        }
        c1.clearLabels();// clearing data from histogram and plotting data from fit
        polynomialfitter = new HFitter();
        functionFitter = new HFitter();

        functionFitter
                .setFunc("fitGaus", 1, "a* exp(-0.5*((x[0]-mean)/s0)*((x[0]-mean)/s0))+p2*x[0]*x[0]+p1*x[0]+p0", "a,mean,s0,p2,p1,p0");
        functionFitter.setPar("a", 80D);
        functionFitter.setPar("mean", 0.5 * (minGauss + maxGaus));// 0.5*(fitrangegaus.min+fitrangegaus.max)
        functionFitter.setPar("s0", 0.01);
        functionFitter.setRange(minPoly, maxPoly);// tutaj daję range
        // najmniejszy-największy
        functionFitter.setParRange("a", 0D, Math.pow(10, 9));
        functionFitter.setParRange("mean", minGauss, maxGaus);
        functionFitter.setParRange("s0", 0D, (maxGaus - minGauss) / 2D);

        functionFitter.fit(h1);

        IFunction ff = functionFitter.getFittedFunc();
        IFitResult r = functionFitter.getResult();
        Pars = r.fittedParameters();
        double[] Errors = r.errors();
        String[] Names = r.fittedParameterNames();
        System.out.println("Fitted parameters: " + Arrays.toString(r.fittedParameters()));

        polynomialfitter.setFunc("fitPoly", 1, "p2*x[0]*x[0]+p1*x[0]+p0", "p2,p1,p0");
        ;
        polynomialfitter.setPar("p2", Pars[3]);
        polynomialfitter.setPar("p1", Pars[4]);
        polynomialfitter.setPar("p0", Pars[5]);
        polynomialfitter.setRange(minPoly, maxPoly);
        polynomialfitter.fit(h1);

        IFunction ffp = polynomialfitter.getFittedFunc();

        fFitGaus = new F1D("Gauss", ff, minGauss, maxGaus);
        fFitPolynomial = new F1D("Poly", ffp, minPoly, maxPoly);
        fFitGaus.setColor(Color.green);
        fFitGaus.setPenWidth(3);
        fFitPolynomial.setColor(Color.blue);
        fFitPolynomial.setPenWidth(3);

        BckFit = (int) (BackgroundIntegral(minGauss, maxGaus) / (h1.binLowerEdge(1) - h1.binLowerEdge(0)));
        System.out.println("BckFit: " + Integer.toString(BckFit));

        c1.draw(fFitPolynomial);
        c1.draw(fFitGaus);

        double errorFuntion1 = Erf.erf((minGauss - Pars[1]) / (Pars[2] * Math.sqrt(2)));
        double errorFuntion2 = Erf.erf((maxGaus - Pars[1]) / (Pars[2] * Math.sqrt(2)));
        signalFit = (int) (Math.sqrt(Math.PI / 2.) * Pars[0] * Pars[2] * (errorFuntion2 - errorFuntion1) / (h1.binLowerEdge(1) - h1
                .binLowerEdge(0)));
        TotalFit = (signalFit + BckFit);

        fFitGaus.eval(minGauss, maxGaus);

        System.out.println("signalfit " + signalFit);
        System.out.println("totalfit " + TotalFit);

        for (int i = 0; i < ff.numberOfParameters(); i++) {
            System.out.println(Names[i] + ":" + (Pars[i]));
        }
        System.out.println("fitted mean: " + Double.toString(1000D * Pars[1]));
        System.out.println("fitted sigma: " + Double.toString(1000D * Pars[2]));
        DecimalFormat df = new DecimalFormat("0.000000");
        parsData = new String[]{"Total:" + TotalFit, "Background:" + BckFit, "Signal:" + signalFit,
                "Mean:" + df.format(1000D * Pars[1]) + "\u00B1" + df.format(Errors[1] * 1000.),
                "\u03c3:" + df.format(1000D * Pars[2]) + "\u00B1" + df.format(Errors[2] * 1000.)};
        c1.drawTextBox(parsData);
        total = "Total:" + TotalFit;
        backgroundFit = " Background:" + BckFit;
        signal = " Signal:" + signalFit;
        mean = "Mean:" + df.format(1000D * Pars[1]) + "\u00B1" + df.format(Errors[1] * 1000.);
        sigma = "\u03c3:" + df.format(1000D * Pars[2]) + "\u00B1" + df.format(Errors[2] * 1000.);
        dataForDatabase = "Total:" + TotalFit + " Background:" + BckFit + " Signal:" + signalFit + "Mean:" + df.format(1000D * Pars[1]) + "\u00B1" + df.format(Errors[1] * 1000.) + "\u03c3:" + df.format(1000D * Pars[2]) + "\u00B1" + df.format(Errors[2] * 1000.);

    }

    static double BackgroundIntegral(Double xmin, Double xmax) {

        return ((xmax - xmin) * Pars[5] + Pars[4] * (Math.pow(xmax, 2) - Math.pow(xmin, 2)) / 2.)
                + (Pars[3] * (Math.pow(xmax, 3) - Math.pow(xmin, 3)) / 3.);

    }

    private static final long serialVersionUID = 1L;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Histo().setVisible(true);
            }
        });
    }

    public static String getTotal() {
        return total;
    }

    public static String getBackgroundFit() {
        return backgroundFit;
    }

    public static String getSignal() {
        return signal;
    }

    public static String getSigma() {
        return sigma;
    }

    public static String getMean() {
        return mean;
    }


    public double getminGaussRange() {
        return minGaussRange;
    }

    public static void setMinGaussRange(double min) {
        minGaussRange = new BigDecimal(min).setScale(3, RoundingMode.HALF_UP).doubleValue();
        System.out.println(minGaussRange);

    }

    public static void setMaxGaussRange(double max) {

        maxGaussRange = new BigDecimal(max).setScale(3, RoundingMode.HALF_UP).doubleValue();
        System.out.println(maxGaussRange);
    }

    public static void setMinPolyRange(double min) {
        minPolyRange = new BigDecimal(min).setScale(3, RoundingMode.HALF_UP).doubleValue();
        System.out.println(minPolyRange);

    }

    public static void setMaxPolyRange(double max) {
        maxPolyRange = new BigDecimal(max).setScale(3, RoundingMode.HALF_UP).doubleValue();
        System.out.println(maxPolyRange);
    }
}


