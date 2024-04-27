package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class SecondDegree_1Var {
    public static void main(String[] args) {
        String input1 = JOptionPane.showInputDialog(null, "Please input a,b,c parameters (seperated by a \"space\")",
        "Solve ax^2+bx+c=0 (a ≠ 0) ",JOptionPane.INFORMATION_MESSAGE);
        String[] array1 = input1.split("\\s+",3);
        double a = Double.parseDouble(array1[0]);
        double b = Double.parseDouble(array1[1]);
        double c = Double.parseDouble(array1[2]);
        double D = b*b - 4*a*c;
        if (a == 0){
            JOptionPane.showMessageDialog(null,"a must not be 0");
        }
        else{
            if (D < 0){
              JOptionPane.showMessageDialog(null,"No Real solution");
            }
            else if (D ==0){
                JOptionPane.showMessageDialog(null, "The solution is a double root: x = "+(-b/(2*a)));
            }
            else{
                double x1 = (-b+Math.sqrt(D))/(2*a);
                double x2 = (-b-Math.sqrt(D))/(2*a);
                JOptionPane.showMessageDialog(null, "The solution is: (x1; x2) = ("+x1+"; "+x2+")");
            }
        }
    }
}
