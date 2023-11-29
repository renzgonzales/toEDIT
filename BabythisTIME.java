
    import javax.swing.JOptionPane;
/**
 *
 * @author Gonzales_CPE
 */
public class BabythisTIME {
    private static final String[] item = {"PABO", "Gansa", "PATO", "MANOK", "PUGO"};
    private static final double[] price = {10.0, 20.0, 30.0, 40.0, 50.0};
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int choice;
        int quantity;
        double total = 0.0;
        
        
        do {
            choice = showMenu();
            
            if (choice >= 1 && choice <= item.length) {
                quantity = getQuantity();
                total += calculateTotal(choice - 1, quantity);
                
                int chsy = JOptionPane.showConfirmDialog(null, "Do you want to continue shopping?", "Continue Shopping", JOptionPane.YES_NO_OPTION);
                if (chsy == JOptionPane.NO_OPTION) {
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
        
        double dscnt = total *0.5;
        double csh = total-dscnt;
        int dsct = JOptionPane.showConfirmDialog(null, "Sexy ka o dili?", "Question", JOptionPane.YES_NO_OPTION);
        if (dsct == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Total: "+ csh + "\nDiscount Applied: 5%");
        }else{
            JOptionPane.showMessageDialog(null, "Total : "+total+ "\nNo Discount Applied");
        }
        
        
        while(true){
        String input = JOptionPane.showInputDialog(null, "Your total is " + total + "\nEnter Cash: " );
        int ipt = Integer.parseInt(input);
        double b = ipt-csh;
        if(ipt > csh){
            JOptionPane.showMessageDialog(null, "Your change is: " +b );
            JOptionPane.showMessageDialog(null, "Salamat sa pag palit boss");
            break;
        } else if( ipt == csh){
            JOptionPane.showMessageDialog(null, "Thank you for your payment");
            JOptionPane.showMessageDialog(null, "Salamat sa pag palit boss");
            break;
        }else{
            JOptionPane.showMessageDialog(null, "INAVLID! Please Enter Cash Again.");
        }
        }
    }
    
    private static int showMenu() {
        StringBuilder menuMessage = new StringBuilder();
        menuMessage.append("Choose a product:\n");
        
        for (int i = 0; i < item.length; i++) {
            menuMessage.append(i + 1).append(". ").append(item[i]).append(" - P").append(price[i]).append("\n");
        }
        
        String choiceString = JOptionPane.showInputDialog(null, menuMessage.toString(), "7/7", JOptionPane.QUESTION_MESSAGE);
        
        try {
            return Integer.parseInt(choiceString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static int getQuantity() {
        String quantityString = JOptionPane.showInputDialog(null, "Enter the quantity:", "Quantity", JOptionPane.QUESTION_MESSAGE);
        
        try {
            return Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private static double calculateTotal(int choice, int quantity) {
        return price[choice] * quantity;
    }
    
    //private static double applyDiscount(double total) {
       // String discountString = JOptionPane.showInputDialog(null, "Discount Percentage:", "Discount", JOptionPane.QUESTION_MESSAGE);
        
       // try {
          //  double dscntt = Double.parseDouble(discountString);
         //   return total * (dscntt / 100.0);
        //} catch (NumberFormatException e) {
         //   return 0.0;
       // }
   // }
    
}

}
