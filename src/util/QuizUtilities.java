package util;

import javax.swing.*;

public class QuizUtilities implements CommonRules {

    /**
     * Makes sure the size and regex of the string is correct. If not, asks for a new String.
     * @param s
     * @param isDescription
     * @return
     */
    public static String getFittingString(String s, boolean isDescription){
        if(s.matches(CommonRules.COMMON_REGEX)
                && s.length() < (isDescription ? CommonRules.DESCRIPTION_SIZE : CommonRules.COMMON_SIZE)){
            return s;
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Please enter a new field.\n");
            stringBuilder.append("Character limit is ");
            stringBuilder.append(isDescription ? CommonRules.DESCRIPTION_SIZE : CommonRules.COMMON_SIZE);
            stringBuilder.append("\nSpecial character use is limited.");

            return JOptionPane.showInputDialog(null, stringBuilder.toString(), "Input", JOptionPane.WARNING_MESSAGE);
            //FIXME Put this in a while loop ... specify which was incorrect and why, and ask for input until the user gives good input
        }
    }
}
