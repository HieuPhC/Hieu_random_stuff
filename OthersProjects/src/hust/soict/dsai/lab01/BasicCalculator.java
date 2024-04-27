package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class BasicCalculator {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the first number (num1)"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the second number (num2)"));
        double a = num1 + num2;
        double b = Math.abs(num1 - num2);
        double c = num1 * num2;
        if(num2 == 0){
            JOptionPane.showMessageDialog(null,"The sum is: "+ Math.round(a*100.0)/100.0 + "\n" +
                                    "The difference is: "+ Math.round(b*100.0)/100.0 + "\n"+"The product is: "+ 
                                    Math.round(c*100.0)/100.0 +"\n"+"The quotient is: error(divide by 0)");
            }
        else{
            JOptionPane.showMessageDialog(null,"The sum is: "+ Math.round(a*100.0)/100.0  + "\n" +
                                    "The difference is: "+Math.round(b*100.0)/100.0+ "\n"+"The product is: "+ 
                                    Math.round(c*100.0)/100.0 +"\n"+"The quotient is:" + Math.round((num1/num2)*100.0)/100.0);
            }     
        
    }
}
