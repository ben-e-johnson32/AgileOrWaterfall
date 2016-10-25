package com.Ben;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgileOrWaterfall extends JFrame
{
    // All the form objects.
    private JTextField projectNameTextField;
    private JTextField numProgrammersTextField;
    private JCheckBox stringentQCCheckBox;
    private JCheckBox teamExperienceCheckBox;
    private JCheckBox earlyIntegrationCheckBox;
    private JCheckBox workingModelsCheckBox;
    private JButton recommendButton;
    private JCheckBox firmDeadlinesCheckBox;
    private JLabel resultLabel;
    private JPanel rootPanel;

    AgileOrWaterfall()
    {
        // Sets the title for the window.
        super("Agile or Waterfall");

        // Set up the frame - make it visible, make it close the program when the window is closed.
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // When the recommend button is clicked, update the result.
        recommendButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateResult();
            }
        });
    }

    private void updateResult()
    {
        // Get all the data from the GUI and pass it to the agileOrWaterfall method.
        String projectName = projectNameTextField.getText();
        int numProgrammers = Integer.parseInt(numProgrammersTextField.getText());
        boolean stringentQC = stringentQCCheckBox.isSelected();
        boolean teamExperience = teamExperienceCheckBox.isSelected();
        boolean earlyIntegration = earlyIntegrationCheckBox.isSelected();
        boolean workingModels = workingModelsCheckBox.isSelected();
        boolean firmDeadlines = firmDeadlinesCheckBox.isSelected();

        String result = agileOrWaterfall(numProgrammers, stringentQC, teamExperience,
                                         earlyIntegration, workingModels, firmDeadlines);

        // If the result was a tie, display that.
        if (result.equals("either one"))
        {
            resultLabel.setText("For " + projectName + ", either one seems like a good choice.");
        }

        // Otherwise, tell the user which method is best for their project.
        else
        {
            resultLabel.setText("The best method for " + projectName + " is " + result + ".");
        }
    }

    private String agileOrWaterfall(int numOfProgrammers, boolean stringentQC, boolean teamExperience,
                                    boolean earlyIntegration, boolean workingModels, boolean firmDeadlines)
    {
        // Initialize score counters for each method.
        int agile = 0;
        int waterfall = 0;

        // If statements that add up the score. Looks at the values of each variable and adds a point where appropriate.
        if (numOfProgrammers > 50)
        { waterfall++; }
        if (teamExperience)
        { agile++; }
        if (stringentQC)
        { agile++; }
        if (earlyIntegration)
        { agile++; }
        if (workingModels)
        { agile++; }
        if (firmDeadlines)
        { waterfall++; }

        // Compare the scores and return the correct word. If the scores are tied, return 'either one'.
        if (agile > waterfall)
        { return "agile"; }
        else if (waterfall > agile)
        { return "waterfall"; }
        else
        { return "either one"; }
    }
}
