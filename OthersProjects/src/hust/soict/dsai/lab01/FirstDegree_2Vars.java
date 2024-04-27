package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class FirstDegree_2Vars {
    public static void main(String[] args) {
        String input1 = JOptionPane.showInputDialog(null, "Please input a1,b1,c1 parameters (seperated by a \"space\")",
        "Solve a1x + b1y = c1 & a2x +b2y = c2",JOptionPane.INFORMATION_MESSAGE);
        String[] array1 = input1.split("\\s+",3);
        double a1 = Double.parseDouble(array1[0]);
        double b1 = Double.parseDouble(array1[1]);
        double c1 = Double.parseDouble(array1[2]);

        String input2 = JOptionPane.showInputDialog(null, "Please input a2,b2,c2 parameters (seperated by a \"space\")",
        "Solve a1x + b1y = c1 & a2x +b2y = c2",JOptionPane.INFORMATION_MESSAGE);
        String[] array2 = input2.split("\\s+",3);
        double a2 = Double.parseDouble(array2[0]);
        double b2 = Double.parseDouble(array2[1]);
        double c2 = Double.parseDouble(array2[2]);
        double D = a1*b2 - a2*b1;
        if  (D == 0.0) {
            if((a1/a2 == b1/b2 && a1/a2 == c1/c2)||(a1 == 0.0 && a1 == a2 && b1/b2 == c1/c2)||(b1 == 0.0 && b1 == b2 && a1/a2 == c1/c2)
            ||(c1 == 0 && c1 == c2 && a1/a2 == b1/b2)||(a1 == a2 && a1 == 0 && c1 == c2 && c1 == 0) || (b1 == b2 && b1 == 0 && c1 == c2 && c1 == 0)){
                JOptionPane.showMessageDialog(null,"Infinite solution");
            }
            else{
                JOptionPane.showMessageDialog(null,"No solution");
            }
        }
        else{
                double D1 = c1*b2 - c2*b1;
                double D2 = a1*c2 - a2*c1;
                JOptionPane.showMessageDialog(null,"The solution is: (x; y) = ("+ D1/D +"; "+ D2/D +")");
        }
    }
}
