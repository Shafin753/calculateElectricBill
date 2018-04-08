import javax.swing.JOptionPane; 
public class ProcessCustomerReport {
   public static void main (String[] args){
   
   double minKilowatt = 0.0;
   double maxKilowatt = 1000.0;
   double lowRateKilowattMin = 200.0;
   double lowRate = 0.08;
   double highRate = 0.11;
   double totalOwed = 0.0;
   String customerNumber = "";
   int numCustomers = 0;
   
   double kilowattUsed = 0;
   String report = "";
   double amountOwed = 0;
   report += "Monthly Billing Report\n";
   report += "Customer Number | Customer Name | Kilowatts Used | Amount Owed\n";
   
   
      customerNumber = JOptionPane.showInputDialog("Please enter the customer number");

   
   
   while (!customerNumber.equalsIgnoreCase("QUIT")){
   
      String name = JOptionPane.showInputDialog("Please enter you name");
      
      do{
         try {
            kilowattUsed= Double.parseDouble(JOptionPane.showInputDialog("Please enter the number of kilo watt used"));
         }
         catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error");   
         }
         if ((kilowattUsed < minKilowatt) || (kilowattUsed >= maxKilowatt)) {
            JOptionPane.showMessageDialog(null,"Error!Please enter a valid number of kilowatts");
         }
      }while (!(kilowattUsed >= minKilowatt && kilowattUsed < maxKilowatt));
      
      if (kilowattUsed < lowRateKilowattMin){ 
           amountOwed = kilowattUsed*highRate; 
      }
      else {
         amountOwed = kilowattUsed*lowRate; 
      }
      
      totalOwed = totalOwed + amountOwed;
      
        numCustomers = numCustomers + 1;
      
      report += customerNumber +"|"+ name + "|" + amountOwed + "\n";
      
     
      customerNumber = JOptionPane.showInputDialog("Please enter the customer number");
      
     
   }
   
   if (numCustomers > 0) {
      report +="Number of Customers"+ numCustomers  + "\nTotal Owed: " + String.format("$%.2f",totalOwed);
   }
   
   JOptionPane.showMessageDialog(null, report);
   
   
   }
   }