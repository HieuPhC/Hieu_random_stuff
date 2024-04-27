package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?",null,0);
        JOptionPane.showMessageDialog(null,"You have chosen: "+(option == JOptionPane.YES_OPTION?"Yes":"No"));

/*         Object[] options = { "I do", "I don't" };
        int option = JOptionPane.showOptionDialog(null,"Do you want to change to the first class ticket?",
                                                    "Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(option == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "You have choosen \"I do\"" );
        }
        else if(option == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "You have choosen \"I don't\"" );
        } */
    }
}