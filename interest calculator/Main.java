import java.util.*;
abstract class Account{
	double intrestRate;
	double amount;
	public abstract double calculateInterest(double amount);
}
class FDaccount extends Account {

    double FDinterestRate;
    double FDAmount;
    int noOfDays;
    int ageOfACHolder;
    Scanner FDScanner = new Scanner(System.in);

    @Override
    public double calculateInterest(double amount) {
        this.FDAmount = amount;
        System.out.println("Enter FD days");
        noOfDays = FDScanner.nextInt();
        System.out.println("Enter FD age holder ");
        ageOfACHolder = FDScanner.nextInt();
        if (amount < 0) {
           System.out.println("Invalid amount");
        }
        if(noOfDays<0){
            System.out.println("Invalid days");
        }
        if(ageOfACHolder<0){
            System.out.println("Invalid age");
        }
		if (amount < 10000000&& ageOfACHolder>60) {
            if (noOfDays >= 7 && noOfDays <= 14) {
                FDinterestRate = 0.0500;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                FDinterestRate = 0.0525;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                FDinterestRate = 0.0600;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                FDinterestRate = 0.0750;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                FDinterestRate = 0.0800;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                FDinterestRate = 0.0850;
            }
            
        } 
		else if (amount < 10000000&& ageOfACHolder<60) {
            if (noOfDays >= 7 && noOfDays <= 14) {
                FDinterestRate = 0.0450; 
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                FDinterestRate = 0.0470;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                FDinterestRate = 0.0550;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                FDinterestRate = 0.0700;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                FDinterestRate = 0.0750;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                FDinterestRate = 0.0800;
            }    
        }
		else {
            if (noOfDays >= 7 && noOfDays <= 14) {
                FDinterestRate = 0.065;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                FDinterestRate = 0.0675;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                FDinterestRate = 0.00675;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                FDinterestRate = 0.080;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                FDinterestRate = 0.0850;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                FDinterestRate = 0.10;
            }

        }

        return FDAmount * FDinterestRate;
    }
}

class RDaccount extends Account {

    double RDInterestRate;
    double RDamount;
    int noOfMonths;
    double monthlyAmount;
    double General, SCitizen;
    Scanner RDScanner = new Scanner(System.in);

    @Override
   public double calculateInterest(double Ramount){
        this.RDamount = Ramount;
        System.out.println("Enter RD months");
        noOfMonths = RDScanner.nextInt();
        System.out.println("Enter RD holder age");
        int age = RDScanner.nextInt();
        if (RDamount < 0) {
             System.out.println("Invalid amount");
        }
        if(noOfMonths<0){
             System.out.println("Invalid months");
        }
        if(age<0){
             System.out.println("Invalid Age");
        }
        if (noOfMonths >= 0 && noOfMonths <= 6) {
            General = .0750;
            SCitizen = 0.080;
        } else if (noOfMonths >= 7 && noOfMonths <= 9) {
            General = .0775;
            SCitizen = 0.0825;
        } else if (noOfMonths >= 10 && noOfMonths <= 12) {
            General = .0800;
            SCitizen = 0.0850;
        } else if (noOfMonths >= 13 && noOfMonths <= 15) {
            General = .0825;
            SCitizen = 0.0875;
        } else if (noOfMonths >= 16 && noOfMonths <= 18) {
            General = .0850;
            SCitizen = 0.0900;
        } else if (noOfMonths >= 22) {
            General = .0875;
            SCitizen = 0.0925;
        }
		if(age<60){
			RDInterestRate=General;
		}
		else{
			RDInterestRate=SCitizen;
		}
        return RDamount * RDInterestRate;

    }

}

class SBaccount extends Account {
    double SBamount , SbInterestRate, interest;
    Scanner SBScanner = new Scanner(System.in);
    
    @Override
    public double calculateInterest(double amount){
        this.SBamount = amount;
        if(SBamount < 0 ){
           System.out.println("Invalid amount");
        }
        System.out.println("Select account type \n1. NRI \n2. Normal ");
        int accountChoice = SBScanner.nextInt();
        switch (accountChoice) {
            case 1:
                SbInterestRate = .06;
                break;
            case 2:
                SbInterestRate = .04;
                break;
            default:
                System.out.println("Please choose right account again");
                
        }
     return amount * SbInterestRate;
   
}
}
public class Main 
{
    public static void main(String as[])
    {
		Scanner sc=new Scanner(System.in);
		System.out.println("===========================\nSelect the option:\n 1. Interest Calculator -SB\n 2. Interest Calculator -FD\n 3. Interest Calculator -RD\n 4. Exit\n ===========================");
		int option=sc.nextInt();	
        switch (option) 
        {
            case 1:SBaccount sb = new SBaccount();
                    System.out.println("Enter the SB amount ");
                    double amount = sc.nextDouble();
                    System.out.println("Interest gained is : Rs. " + sb.calculateInterest(amount));
                    break;
            case 2: FDaccount fd = new FDaccount();
                    System.out.println("Enter the FD Amount");
                    double fAmount = sc.nextDouble();
                    System.out.println("Interest gained is: Rs. " + fd.calculateInterest(fAmount));
                    break;
            case 3: RDaccount rd = new RDaccount();
                    System.out.println("Enter the RD amount");
                    double Ramount = sc.nextDouble();
                    System.out.println("Interest gained is: Rs. " + rd.calculateInterest(Ramount));
                    break;
            case 4: System.out.println("Exit");
					System.exit(0);
                    break;
            default: System.out.println("Invalid Option");
                    break;
        }
     
    }

}
