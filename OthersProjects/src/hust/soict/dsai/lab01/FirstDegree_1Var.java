package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class FirstDegree_1Var {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input the 'a' parameter",
        "Solve ax+b = 0 (a ≠ 0)",JOptionPane.INFORMATION_MESSAGE));
        if(a == 0){
            JOptionPane.showMessageDialog(null,"Parameter 'a' must not be equal to 0","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input the 'b' parameter",
            "Solve ax+b = 0 (a ≠ 0)",JOptionPane.INFORMATION_MESSAGE));
            JOptionPane.showMessageDialog(null,"The solution is: x = "+ (-b/a));
        }
    }
}
