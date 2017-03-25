package Craps;

import java.awt.Container;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Class:        CrapsGUI
 * File:	 CrapsGUI.java
 * Description:	 This program is designed to simulate the game of craps. The player
 *               rolls 2 dices.
 *               This program is to simulate the game of craps. The player rolls 2 
 *               dices to get a score value. If they roll a 7 or a 11 on the first roll they win.
 *               If they roll a 2,3,4, and 12 they lose. Any other number rolled on the 1st roll
 *               becomes a point value. The player will continue to roll to try and match the
 *               point value in order to win. During the second roll and on wards, if they get a
 *               value of 7, they lose. This program also keeps track of number of games played,
 *               won/lost, and winning percentage of the games played. It also keeps track of each
 *               of the faces rolled and the percentage of each faced roll during the game session.
 *               Save will save the statistics of each game session to a external text file.
 *               With Gambling Feature Enabled: The player can simulate gambling. The player starts
 *               off with a bank balance of $1000 and can double their winnings with the amount they
 *               placed if they win. If they lose, the player will lose the same amount as they
 *               betted from their bank balance. Exiting Gambling or Clearing will reset this feature
 *               to the starting bank balance.
 * @author:	 Ryu Muthui
 * Environment:	 PC, Windows 7, jdk:1.7.0_10, NetBeans IDE 7.2
 * Date:	 03/06/2013
 * @version:	 1.01
 * @see:         java.awt.Container;
 * @see:         java.awt.Toolkit;
 * @see:         java.io.FileWriter;
 * @see:         java.io.IOException;
 * @see:         java.io.PrintWriter;
 * @see:         java.text.DecimalFormat;
 * @see:         java.text.NumberFormat;
 * @see:         javax.swing.ImageIcon;
 * @see:         javax.swing.JOptionPane;
 * @exception    exp -- File not found.
 * @exception    exception -- File read Error.
 * @param args the command line arguments
 * Hours:        24 Hours.
 * History Log:	 Created 2/26/2013, Updated 03/01/2013, 03/02/2013
*                03/03/2013, 03/04/2013, Last updated 03/06/2013*/
public class CrapsGUI extends javax.swing.JFrame 
{
  //instance variables.
    final int MAX = 6,
              NUM_OF_DICE = 2;
        int points = 0,
            sum = 0,
            gamesPlayed = 0,
            gamesWon = 0,
            gamesLost = 0,
            rollCounter = 0,
            betAmount = 0,
            bankBalance = 1000; 
    boolean roll = false,
            gambling = false;
    double  statsGameWins = 0.0;
    
    //Sting
    String FILEPATH1 = "src/Craps/Images/die";
    String FILEPATH2 = ".png";
    String gameStats = "";
    
    //call the die class and genarate a random integer number to be used when rolling.
    Die DieFace = new Die();
    
    //Arrays to hold the frequency of rolls and percentage of the rolls.
    int[] rollFrequency = new int[MAX];
    double[] rollPercentage = new double [MAX];
    
    //Decimal format set to display the roll percentage.
    DecimalFormat percent = new DecimalFormat("#0.00%");
    /**
     * An imported NumberFormat method to display in the dollars format.
     * @author Ryu Muthui
     */
    NumberFormat dollars = NumberFormat.getCurrencyInstance();
    
     /**
     * This creates a new instance of CrapsGUI form and reads inputs 
     * prior to the GUI loading.
     * @ author Ryu Muthui
     * @ see disableJButtons method.
     */
    public CrapsGUI() 
    {
        initComponents();
        
        //Sets the form to display in the center on start up.
        setLocationRelativeTo(null);
        
        //Sets the default button on the form.
        this.getRootPane().setDefaultButton(rollJButton);
        
        //Sets the background color of the form.
        Container background = this.getContentPane();
        background.setBackground(new java.awt.Color(51,153,255));
        
        //Sets icon image on form.
        this.setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/Craps/Images/die6.png"));
        
        //display a message where to start playing the game.
        displayJTextArea.setText("\n\nClick the Roll Button\nto start a New Game.");
        
        //Sets the Splash Screen timer to 5 seconds.
        try {Thread.sleep(5000);}
        catch(InterruptedException e){}
        
        //prompt for gambling feature when the form loads.
        Object[] options = { "Yes", "No" };
          int choice = JOptionPane.showOptionDialog(null, 
              "Would  you like to enable the gambling feature?", 
              "Enable Gambling?", 
              JOptionPane.YES_NO_OPTION, 
              JOptionPane.QUESTION_MESSAGE, 
              null, 
              options, 
              options[0]);
          gamblingJCheckBox.setSelected(true);

          //interpret the user's choice
          if (choice == JOptionPane.NO_OPTION)
          {
            gamblingJPanel.setVisible(false);
            gamblingJCheckBox.setSelected(false);
          }
        //calls disableButtons Method to disable the appropriate buttons on start.
        disableButtons();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        gamblingJPanel = new javax.swing.JPanel();
        betAmountTextField = new javax.swing.JLabel();
        bankBalanceJLabel = new javax.swing.JLabel();
        currentBankBalanceJLabel = new javax.swing.JLabel();
        betAmountJTextField = new javax.swing.JTextField();
        setbetAmmountJButton = new javax.swing.JButton();
        controlJPanel = new javax.swing.JPanel();
        rollJButton = new javax.swing.JButton();
        statisticsJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        displayJTextArea = new javax.swing.JTextArea();
        statusJPanel = new javax.swing.JPanel();
        sumJLabel = new javax.swing.JLabel();
        sumJTextField = new javax.swing.JTextField();
        statusJLabel = new javax.swing.JLabel();
        statusJTextField = new javax.swing.JTextField();
        pointJLabel = new javax.swing.JLabel();
        pointJTextField = new javax.swing.JTextField();
        diceJPanel = new javax.swing.JPanel();
        gamblingJCheckBox = new javax.swing.JCheckBox();
        die2JLabel = new javax.swing.JLabel();
        die1JLabel = new javax.swing.JLabel();
        fileJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        actionJMenu = new javax.swing.JMenu();
        rollMenuItem = new javax.swing.JMenuItem();
        statisticsJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Craps Simulation Game");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(153, 0, 0));
        titleJLabel.setText("Welcome to Craps Game Simulation");
        titleJLabel.setToolTipText("Welcome to Craps Game Simulation!");

        gamblingJPanel.setBackground(new java.awt.Color(51, 153, 255));
        gamblingJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")), "Place your bet here:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        betAmountTextField.setText("Enter bet amount:");

        bankBalanceJLabel.setText("Your Bank Balance:");

        currentBankBalanceJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        currentBankBalanceJLabel.setText("$1000.00");
        currentBankBalanceJLabel.setToolTipText("Your current bank balance.");

        betAmountJTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        betAmountJTextField.setText("0");
        betAmountJTextField.setToolTipText("Enter a betting amount.");

        setbetAmmountJButton.setMnemonic('B');
        setbetAmmountJButton.setText("Set Bet Amount");
        setbetAmmountJButton.setToolTipText("Click to lock in your betting amount.");
        setbetAmmountJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setbetAmmountJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gamblingJPanelLayout = new javax.swing.GroupLayout(gamblingJPanel);
        gamblingJPanel.setLayout(gamblingJPanelLayout);
        gamblingJPanelLayout.setHorizontalGroup(
            gamblingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamblingJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamblingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bankBalanceJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(betAmountTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gamblingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currentBankBalanceJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(betAmountJTextField))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamblingJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setbetAmmountJButton)
                .addGap(36, 36, 36))
        );
        gamblingJPanelLayout.setVerticalGroup(
            gamblingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamblingJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamblingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankBalanceJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentBankBalanceJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gamblingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(betAmountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(betAmountTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(setbetAmmountJButton)
                .addContainerGap())
        );

        controlJPanel.setBackground(new java.awt.Color(51, 153, 255));
        controlJPanel.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        rollJButton.setMnemonic('R');
        rollJButton.setText("Roll");
        rollJButton.setToolTipText("Click to roll the dices.");
        rollJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(rollJButton);

        statisticsJButton.setMnemonic('S');
        statisticsJButton.setText("Statistics");
        statisticsJButton.setToolTipText("Click to view the game statistics.");
        statisticsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(statisticsJButton);

        printJButton.setMnemonic('P');
        printJButton.setText("Print");
        printJButton.setToolTipText("Click to Print the Display Text Area Window.");
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(printJButton);

        clearJButton.setMnemonic('C');
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Click to reset the game.");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(clearJButton);

        exitJButton.setMnemonic('X');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Click to Exit program.");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(exitJButton);

        displayJTextArea.setEditable(false);
        displayJTextArea.setColumns(20);
        displayJTextArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        displayJTextArea.setRows(5);
        displayJTextArea.setToolTipText("Displays the game statistics and roll information in this text field.");

        statusJPanel.setBackground(new java.awt.Color(51, 153, 255));
        statusJPanel.setLayout(new java.awt.GridLayout(3, 2));

        sumJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sumJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sumJLabel.setText("Sum =");
        statusJPanel.add(sumJLabel);

        sumJTextField.setEditable(false);
        sumJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sumJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusJPanel.add(sumJTextField);

        statusJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusJLabel.setText("Status:");
        statusJPanel.add(statusJLabel);

        statusJTextField.setEditable(false);
        statusJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusJPanel.add(statusJTextField);

        pointJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pointJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pointJLabel.setText("Point =");
        statusJPanel.add(pointJLabel);

        pointJTextField.setEditable(false);
        pointJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pointJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusJPanel.add(pointJTextField);

        diceJPanel.setBackground(new java.awt.Color(51, 153, 255));

        gamblingJCheckBox.setText("Enable Gambling");
        gamblingJCheckBox.setToolTipText("Enable or Disable Gambling Feature.");
        gamblingJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamblingJCheckBoxActionPerformed(evt);
            }
        });

        die2JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Craps/Images/die1.png"))); // NOI18N

        die1JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Craps/Images/die1.png"))); // NOI18N

        javax.swing.GroupLayout diceJPanelLayout = new javax.swing.GroupLayout(diceJPanel);
        diceJPanel.setLayout(diceJPanelLayout);
        diceJPanelLayout.setHorizontalGroup(
            diceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diceJPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(diceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diceJPanelLayout.createSequentialGroup()
                        .addComponent(die1JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(die2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(diceJPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(gamblingJCheckBox)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        diceJPanelLayout.setVerticalGroup(
            diceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diceJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamblingJCheckBox)
                .addGap(12, 12, 12)
                .addGroup(diceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(die2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die1JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        clearJMenuItem.setMnemonic('L');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Select to print out the entire game window.");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);
        fileJMenu.add(fileJSeparator);

        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        fileJMenuBar.add(fileJMenu);

        actionJMenu.setMnemonic('T');
        actionJMenu.setText("Action");

        rollMenuItem.setMnemonic('R');
        rollMenuItem.setText("Roll");
        rollMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(rollMenuItem);

        statisticsJMenuItem.setMnemonic('S');
        statisticsJMenuItem.setText("Statistics");
        statisticsJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(statisticsJMenuItem);

        fileJMenuBar.add(actionJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        fileJMenuBar.add(helpJMenu);

        setJMenuBar(fileJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gamblingJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diceJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(displayJTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(statusJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(titleJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gamblingJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(diceJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(displayJTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Calls the Print Utilities class to print out the displayJTextField.
 * @param evt Click event.
 * @see PrintUtilities Class.
 * @throws e.printStackTrace
 */
    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
        //Clicking the printJButton will print out the displayJTextField.
        try
        {
        //prints the displayJTextArea field.
        displayJTextArea.print();
        }
        //exception for when the printer is not found.
        catch(Exception e)
        {
        e.printStackTrace(); 
        }
    }//GEN-LAST:event_printJButtonActionPerformed
/**
 * Calls the Print Utilities class to print out the entire GUI.
 * @param evt Menu Action Event.
 * @see PrintUtilities Class.
 * @throws e.printStackTrace
 */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        try
        {
        //prints the entire GUI.
        PrintUtilities.printComponent(this);
        }
        //exception for when the printer is not found.
        catch(Exception e)
        {
        e.printStackTrace(); 
        }
    }//GEN-LAST:event_printJMenuItemActionPerformed
/**
 * Exits the program when selected.
 * @param evt Click Event.
 */
    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        //Exits the program when selected.
        System.exit(0);
    }//GEN-LAST:event_exitJButtonActionPerformed
/**
 * Calls the exitJButtonActionPerformed click event in which turn will also exit the program.
 * @param evt Menu Action Event.
 */
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        //Exits the program when selected by calling the exitJButtonActionPerformed evt.
        exitJButton.doClick();
    }//GEN-LAST:event_quitJMenuItemActionPerformed
/**
 * Clears the state of the game back to default state by calling 3 methods and setting 
 * various counter variables back to default state.
 * @param evt Click Event.
 * @see disableButtons method.
 * @see resetGame method.
 * @see resetArrays method.
 */
    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        //Clears the state of the game back to the default state by disabling appropriate
        //buttons/menus. Reset counter variables and arrays and sets gambling state to start.
        disableButtons();
        resetGame();
        resetArrays();
        roll = false;
        betAmount = 0;
        bankBalance = 1000;
        currentBankBalanceJLabel.setText(dollars.format( bankBalance ));
        betAmountJTextField.setText("0");
        betAmountJTextField.setEnabled(true);
        setbetAmmountJButton.setEnabled(true);
        setbetAmmountJButton.setText("Set Bet Amount");
    }//GEN-LAST:event_clearJButtonActionPerformed
/**
 * This method increases various statistics variable to enable calculation and keeps
 * track of roll percentages. Calls 5 Methods to perform all necessary game actions.
 * @see gameLogic Method
 * @see setFrequency Method x2 set to die1 and die2
 * @see displayGameResults Method set to die1
 * @see enableButtons Method
 * @see enableButtons Method
 * @param evt rollJButton click event.
 */
    private void rollJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollJButtonActionPerformed
       //Simulates the 2 dices rolled and updating statistics variables and calculations
       //to keep track of game states.
        
       //increases the roll counter each time the roll button is clicked. 
       rollCounter++;
       
       //set the betting actions button to false so that user can't place bet mid game.
       betAmountJTextField.setEnabled(false);
       setbetAmmountJButton.setEnabled(false);
       
       //call the die class and get a random integer number for the dice and set its value.
       int die1 = DieFace.getDieValue();
       int die2 = DieFace.getDieValue();
        
       //the sum is the 2 faces added together.
       sum = die1 + die2;
        
       //sets the icon to display with the corresponding die face.
       die1JLabel.setIcon(new ImageIcon(FILEPATH1 + die1 + FILEPATH2));
       die2JLabel.setIcon(new ImageIcon(FILEPATH1 + die2 + FILEPATH2));
        
       //call game logic to simulate game.
       gameLogic();
        
       //call the setFrequency method and pass the die value from the die
       //class to calculate the roll frequency.
       setFrequency(die1);
       setFrequency(die2);
            
       //display results of each roll action by callilng the displayGameResults method.
       displayGameResults();
        
       //Enables appropriate buttosn and menu options after a single game session is completed.
       if (gamesPlayed > 0)
       {
            enableButtons();
       }        
       //enables print and clear button/menus if player's game status is "Roll Again."
       if (rollCounter > 0) 
       {
            printJButton.setEnabled(true);
            clearJButton.setEnabled(true);
            printJMenuItem.setEnabled(true);
            clearJMenuItem.setEnabled(true);
       }
       //calls game statistics method to calculate game win percentage.
       getGameStatistics();

    }//GEN-LAST:event_rollJButtonActionPerformed
/**
 * Displays the game statistics in the displayJTextArea by setting the test
 * with the appropriate variables.
 * @param evt  Statistics JButton Click Event.
 */
    private void statisticsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsJButtonActionPerformed
        //Display game statistics.
        displayJTextArea.setText("Number of games played = " + gamesPlayed + "\n"
                + "Number of games won = " + gamesWon + "\n"
                + "Number of games lost = " + gamesLost + "\n"
                + "Percentage of games won = " + percent.format(statsGameWins));
    }//GEN-LAST:event_statisticsJButtonActionPerformed
/**
 * Calls the rollJButtonAction performed event and in turn does what the roll
 * button does from the file menu.
 * @param evt Menu Action Event.
 */
    private void rollMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollMenuItemActionPerformed
        //roll the dice and start playing the game.
        rollJButton.doClick();
    }//GEN-LAST:event_rollMenuItemActionPerformed
/**
 * Calls the statisticsJButtonAction performed event and in turn does what the
 * statistics button does from the file menu.
 * @param evt  Menu Action Event.
 */
    private void statisticsJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsJMenuItemActionPerformed
        //display game statistics when selected.
        statisticsJButton.doClick();
    }//GEN-LAST:event_statisticsJMenuItemActionPerformed
/**
 * Calls the clearJButtonAction performed event and in turn does what the
 * clearJbutton does from the file menu.
 * @param evt Menu Action Event.
 */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        //Clears the state of the game back to the default state.
        clearJButton.doClick();
    }//GEN-LAST:event_clearJMenuItemActionPerformed
/**
 * This check box enables or disables the gambling feature on or off by setting
 * visibility to the gambling panel. When unchecked, also returns the gambling
 * state back to default starting state.
 * @param evt 
 */
    private void gamblingJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamblingJCheckBoxActionPerformed
        //Enables gambling mode on or off when selected.
        if (gamblingJCheckBox.isSelected())
        {
        gamblingJPanel.setVisible(true);
        }
        else
        {
        gamblingJPanel.setVisible(false);
        betAmount = 0;
        bankBalance = 1000;
        currentBankBalanceJLabel.setText(dollars.format( bankBalance ));
        betAmountJTextField.setText("0");
        }
    }//GEN-LAST:event_gamblingJCheckBoxActionPerformed
    /**
     * This checks for input validation when the user enters amount to bet when
     * Gambling is enabled. It will also lock the button so that once a valid
     * bet is placed, the user can't change the betting amount.
     * @param evt  setBetAmmountJButton Click event.
     */
    private void setbetAmmountJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setbetAmmountJButtonActionPerformed
        //Select to lock in the bet amount when valid input by user is met.
        
        if (gambling = true)
        {
           betAmountJTextField.setEnabled(false);  
         
           try 
           {
               //check to see if bet amount is in valid range with players bank balance.
               betAmount = Integer.parseInt(betAmountJTextField.getText());
               if (betAmount < 0 || betAmount > bankBalance)
               throw new NumberFormatException();
               setbetAmmountJButton.setText("Locked-In");
               setbetAmmountJButton.setEnabled(false);
                              
               if (Integer.parseInt(betAmountJTextField.getText()) > bankBalance)
                     {
                     JOptionPane.showMessageDialog (null,
                     "Please entere a positive whole number in the range [1, " + bankBalance
                     + "]", "Illegal Input", JOptionPane.WARNING_MESSAGE);
                     betAmountJTextField.setText("0");
                     betAmountJTextField.requestFocus();
                     betAmountJTextField.setEnabled(true);
                     setbetAmmountJButton.setText("Set Bet Amount");
                     }
           }
           catch (NumberFormatException name)
           {
               //display error message when bet amount is out of range.
               JOptionPane.showMessageDialog (null,
                       "Please entere a positive whole number in the range [1, " + bankBalance
                      + "]", "Illegal Input", JOptionPane.WARNING_MESSAGE);
               betAmountJTextField.requestFocus();
               betAmountJTextField.setText("0");
               betAmountJTextField.selectAll();
               betAmount = 0;
               betAmountJTextField.setEnabled(true);
            }
         }
    }//GEN-LAST:event_setbetAmmountJButtonActionPerformed
/**
 * Calls the saveGameStats Method in order to write the game statistics to an 
 * external text file.
 * @see saveGmaeStats Method.
 * @param gameStats
 * @param evt saveJMenu Action Event.
 */
    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        //
        //call saveGameStats method.
        saveGameStats();
        
        try
        {
            //File writer and Print writer to save game statistics to an external txt file.
            FileWriter fwriter = new FileWriter("src/Craps/GameStatistics.txt", true);
            PrintWriter outputFile = new PrintWriter(fwriter);
            //Write the game statistics to the file.
            outputFile.println(gameStats.toString());
            outputFile.close();  
        }
        catch (IOException e)
        {
               e.printStackTrace(); 
        }

    }//GEN-LAST:event_saveJMenuItemActionPerformed
/**
 * Sets the About Form to visible
 * @see AboutCraps.java
 * @param evt aboutJMenuItemActionPerformed
 */
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        //Sets the About Form to be visible.
        AboutCraps aboutCraps = new AboutCraps();
        aboutCraps.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**
     * A private method to increase the rollFrequency Array at each appropriate index
     * when the corresponding die face is rolled. 
     * @param roll 
     */
    private void setFrequency (int roll)
    {
        //a method to set the frequency with the matching rolled face.
        switch (roll)
        {
            case 1:
                rollFrequency[0]++;
                break;

            case 2:
                rollFrequency[1]++;
                break;

            case 3:
                rollFrequency[2]++;
                break;

            case 4:
                rollFrequency[3]++;
                break;

            case 5:
                rollFrequency[4]++;
                break;

            default:
                rollFrequency[5]++;
                break;
        }
    }
    /**
     * A private method to calculate the roll frequency array and display it
     * in the JTextField Area. It feeds the values from Roll frequency array
     * and divide it by the total number of rolls for each die face and divide
     * by 2 (because there are 2 dice) to calculate the roll frequency.
     * Then append the text in a for loop.
     * @param rollFrequcny[]
     * @param rollPercentage[]
     * @param rollCounter
     * @param NUM_OF_DICE
     */
    private void displayGameResults()
    {
     //for loop to read the rollcounts array values and display it.
     displayJTextArea.setText("Face\tFrequency\tPercent\n"); //first line sets the headers.
        for ( int i = 0; i < rollFrequency.length; i++ )
        {
            //set up roll percent array and increment it.
            //which equals to number of counts devided by actual roll count / 2 (2 dices)
            rollPercentage[i] = (double)rollFrequency[i]/rollCounter/NUM_OF_DICE;
            //adding to the text field, incrementing by 1. tab over to match format.
            displayJTextArea.append((i+1) + "\t" + rollFrequency[i] + "\t\t" 
            + percent.format(rollPercentage[i]) + "\n");
        }        
    }
    /**
     * A private method to simulate and calculate the game logic. It handles the 1st roll
     * win/lose/continue conditions else 2nd roll conditions. It also handles the win/loss
     * of the gambling feature and chatter messages.
     * @param roll (Boolean) 
     * @param sum
     * @param gamesWon
     * @param gamesLost
     * @param gamesPlayed
     * @param bankBalance
     * @param betAmount
     * @param points
     * @return void
     */
       private void gameLogic()
    {
        //Handles the outcome of win/lose/continue rolling on the FIRST roll.
        if (roll == false)
            {
                //win condition.
                if (sum == 7 || sum == 11)
                {
                    sumJTextField.setText(Integer.toString(sum));
                    statusJTextField.setText("You Win!");
                    pointJTextField.setText("");
                    gamesWon++;
                    gamesPlayed++;
                    
                    //Gambling win.
                    bankBalance +=  betAmount;
                    currentBankBalanceJLabel.setText(dollars.format( bankBalance ));
                    betAmount = 0;
                    betAmountJTextField.setText("0");
                    betAmountJTextField.setEnabled(true);
                    setbetAmmountJButton.setText("Set Bet Amount");
                    setbetAmmountJButton.setEnabled(true);
                    //Chatter if player gets over $10k.
                    if (bankBalance >= 10000)
                            {
                            JOptionPane.showMessageDialog (null,
                            "You're up over $10,000. You better cash out and run!" , "Your doing Good!!", +
                            JOptionPane.WARNING_MESSAGE);
                            }
                }
                else 
                {
                    //Lose condition.
                    if (sum == 2 || sum == 3 || sum == 12)
                    {
                    sumJTextField.setText(Integer.toString(sum));
                    statusJTextField.setText("You Lose!");
                    pointJTextField.setText("");
                    gamesLost++;
                    gamesPlayed++;             
                    
                    //Gambling loss.
                    bankBalance -=  betAmount;
                    currentBankBalanceJLabel.setText(dollars.format( bankBalance ));
                    betAmount = 0;
                    betAmountJTextField.setText("0");
                    betAmountJTextField.setEnabled(true);
                    setbetAmmountJButton.setText("Set Bet Amount");
                    setbetAmmountJButton.setEnabled(true);
                        //Chatter if player bust's during gambling session.
                        if (bankBalance == 0)
                            {
                            JOptionPane.showMessageDialog (null,
                            "Sorry you are broke! Better luck next time!! " , "BUSTED!!", +
                            JOptionPane.WARNING_MESSAGE);
                            gamblingJCheckBox.doClick();
                            }
                    }
                    else 
                    //Continue roll condition.
                    {
                    sumJTextField.setText(Integer.toString(sum));
                    statusJTextField.setText("Roll Again!");
                    points = sum;
                    pointJTextField.setText(Integer.toString(points));
                    roll = true;
                    }
                }
            }
        else 
        {
            //Handles the outcome of win/lose/continue rolling on the SECOND roll onwards.
            if( sum == 7)
            {
                sumJTextField.setText(Integer.toString(sum));
                statusJTextField.setText("You Lose!");
                points = 0;
                gamesLost++;
                gamesPlayed++;
                roll = false;
                
                //Gambling loss.
                bankBalance -=  betAmount;
                currentBankBalanceJLabel.setText(dollars.format( bankBalance ));
                betAmount = 0;
                betAmountJTextField.setText("0");
                betAmountJTextField.setEnabled(true);
                setbetAmmountJButton.setText("Set Bet Amount");
                setbetAmmountJButton.setEnabled(true);
                    //Chatter if player bust's during gambling session.
                    if (bankBalance == 0)
                            {
                            JOptionPane.showMessageDialog (null,
                            "Sorry you are broke! Better luck next time!! " , "BUSTED!!", +
                            JOptionPane.WARNING_MESSAGE);
                            gamblingJCheckBox.doClick();
                            }
            }
            else
            {
               if( sum == points)
                {
                    //Win condition.
                    sumJTextField.setText(Integer.toString(sum));
                    statusJTextField.setText("You Win!");
                    points = 0;
                    roll = false;
                    gamesWon++;
                    gamesPlayed++;
                    
                    //Gambling win.
                    bankBalance +=  betAmount;
                    currentBankBalanceJLabel.setText(dollars.format( bankBalance ));
                    betAmount = 0;
                    betAmountJTextField.setText("0");
                    betAmountJTextField.setEnabled(true);
                    setbetAmmountJButton.setText("Set Bet Amount");
                    setbetAmmountJButton.setEnabled(true);
                    
                    //Chatter if player gets over $10k.
                    if (bankBalance >= 10000)
                            {
                            JOptionPane.showMessageDialog (null,
                            "You're up over $10,000. You better cash out and run!" , "Your doing Good!!", +
                            JOptionPane.WARNING_MESSAGE);
                            }
                }
                else
                   //Continue roll condition.
                   {
                    sumJTextField.setText(Integer.toString(sum));
                    statusJTextField.setText("Roll Again!");
                   }
            }
        }
    }
    /**
     * A private method to disable the appropriate buttons/menus depending
     * on game status.
     * @see gameResetMethod
     * @see initialComponents
     */
    private void disableButtons()
    {
        statisticsJButton.setEnabled(false);
        printJButton.setEnabled(false);
        clearJButton.setEnabled(false);
        clearJMenuItem.setEnabled(false);
        printJMenuItem.setEnabled(false);
        saveJMenuItem.setEnabled(false);
        statisticsJMenuItem.setEnabled(false);
    }
    /**
     * A private method to enable the appropriate buttons/menus depending
     * on game status.
     * @see gameResetMethod
     * @see initialComponents
     */
    private void enableButtons()
    {
        statisticsJButton.setEnabled(true);
        printJButton.setEnabled(true);
        clearJButton.setEnabled(true);
        clearJMenuItem.setEnabled(true);
        printJMenuItem.setEnabled(true);
        saveJMenuItem.setEnabled(true);
        statisticsJMenuItem.setEnabled(true);
    }
    /**
     * A private method to calculate the percentage of game wins by dividing
     * number of game wins with number of games played.
     * @param gamesWon
     * @param gamesPlayed
     * @param statsGameWins
     * @see rollJButton Click Event.
     */
    private void getGameStatistics()
    {
     statsGameWins = (double)(gamesWon) / gamesPlayed;
    }
    /**
     * A private method to reset the DisplayJTextArea buck to default state.
     * Including the game state text fields. It also resets all counter variables
     * for game statistics back to default so that a new game can be started with
     * cleared statistics.
     */
    private void resetGame()
    {
        displayJTextArea.setText("\n\nClick the Roll Button\nto start a New Game.");
        sumJTextField.setText("");
        statusJTextField.setText("");
        pointJTextField.setText("");
        rollCounter = 0;
        sum = 0;
        gamesWon = 0;
        gamesLost = 0;
        rollCounter = 0;
        gamesPlayed = 0;
        statsGameWins = 0.0;
     }
    /**
     * A private method to reset the rollFrequncy array back to default values.
     * Since rollPercentage is dependent on these numbers resetting the rollFrequncy
     * array to default sets the rollPercentage array index values to "0" as well.
     */
    private void resetArrays()
    {
     for ( int i = 0; i < rollFrequency.length; i++ )
                {
                  rollFrequency[i] = 0;
                }
    }    
    /**
     * A public method to store the game statistics to a string variable that can be
     * called by the saveGameMethod to write the game statistics to an external file.
     * @param gamesPlayed
     * @param gamesWon
     * @param gamesLost
     * @param statsGameWins
     * @return gameStats
     */
    public String saveGameStats ()
    {
       gameStats = ("Number of games played = " + gamesPlayed + "\n"
                + "Number of games won = " + gamesWon + "\n"
                + "Number of games lost = " + gamesLost + "\n"
                + "Percentage of games won = " + percent.format(statsGameWins) 
                + "\n");
       return gameStats;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrapsGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenu actionJMenu;
    private javax.swing.JLabel bankBalanceJLabel;
    private javax.swing.JTextField betAmountJTextField;
    private javax.swing.JLabel betAmountTextField;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JLabel currentBankBalanceJLabel;
    private javax.swing.JPanel diceJPanel;
    private javax.swing.JLabel die1JLabel;
    private javax.swing.JLabel die2JLabel;
    private javax.swing.JTextArea displayJTextArea;
    private javax.swing.JButton exitJButton;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JMenuBar fileJMenuBar;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JCheckBox gamblingJCheckBox;
    private javax.swing.JPanel gamblingJPanel;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel pointJLabel;
    private javax.swing.JTextField pointJTextField;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JButton rollJButton;
    private javax.swing.JMenuItem rollMenuItem;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JButton setbetAmmountJButton;
    private javax.swing.JButton statisticsJButton;
    private javax.swing.JMenuItem statisticsJMenuItem;
    private javax.swing.JLabel statusJLabel;
    private javax.swing.JPanel statusJPanel;
    private javax.swing.JTextField statusJTextField;
    private javax.swing.JLabel sumJLabel;
    private javax.swing.JTextField sumJTextField;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
