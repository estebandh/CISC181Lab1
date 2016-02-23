//Lab 1
//Lab Group 011-11
import java.util.Scanner;
public class retirementPlanning {
	
static Scanner userInput = new Scanner(System.in);
static double yearsToWorkDouble;
static double eARDouble;
static double eSSIDouble;
static double eYearsRetiredDouble;
static double eRetiredARDouble;
static double eMonthDrawDouble;
static double eRetirementNumeber;
static double eSavePerMonth;

	public static void main(String[] args) {
		userInformation();
		calculateRetirementNumber();
		calculateMontlySave();
		
	}
	//Prompts the user for all the necessary information
	public static void userInformation(){
		yearsToWork();
		expectedAnnualReturn();
		expectedSSI();
		expectedYearsRetired();
		retiredAnnualReturn();
		expectedMonthlyDraw();
	}
	
	//Prompts the user for their expected years in the work force
	//accounting for user error of not entering in a number
	public static void yearsToWork() {
		try { 
			System.out.println("Enter the number of years you plan to work:");
			String yearsToWork = userInput.next();
			yearsToWorkDouble = Double.parseDouble(yearsToWork);
			System.out.println("Years to Work = "+ yearsToWorkDouble);
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			yearsToWork();
		}
	}
	
	//Prompts the user for their expected annual return while in the work force 
	//account for user error of not entering in a number
	public static void expectedAnnualReturn(){
		try { 
			System.out.println("Enter your percent expected annual return on investment:");
			String eAR = userInput.next();
			eARDouble = Double.parseDouble(eAR);
			System.out.println("Expected annual Return = "+ eARDouble+"%");
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			expectedAnnualReturn();
		}
	}
	
	//Prompts the user for their expected SSI accounting for user error of not entering in a number
	public static void expectedSSI(){
		try { 
			System.out.println("Enter your expected monthly SSI income:");
			String eSSI = userInput.next();
			eSSIDouble = Double.parseDouble(eSSI);
			System.out.println("Expected SSI income = $"+ eSSIDouble);
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			expectedSSI();
		}
	}
	
	//Prompts the user for their expected years retired accounting for user error of not entering in a number
	public static void expectedYearsRetired(){
		try { 
			System.out.println("Enter your expected years retired:");
			String eYR = userInput.next();
			eYearsRetiredDouble = Double.parseDouble(eYR);
			System.out.println("Expected years retired = "+ eYearsRetiredDouble+" years");
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			expectedYearsRetired();
		}
	}
	
	//Prompts the user for their expected retired annual accounting for user error of not entering in a number
	public static void retiredAnnualReturn(){
		try { 
			System.out.println("Enter your percent expected retirement annual return:");
			String eRAN = userInput.next();
			eRetiredARDouble = Double.parseDouble(eRAN);
			System.out.println("Expected retirement annual return = "+ eRetiredARDouble+ "%");
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			retiredAnnualReturn();
		}
	}	
	
	//Prompts the user for their expected monthly draw accounting for user error of not entering in a number
	public static void expectedMonthlyDraw(){
		try { 
			System.out.println("Enter your expected retired monthly draw:");
			String eMD = userInput.next();
			eMonthDrawDouble = Double.parseDouble(eMD);
			System.out.println("Expected retirement monthly draw = "+ eMonthDrawDouble);
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			retiredAnnualReturn();
		}
	}
	
	//Calculates how much total money you need for your retirement
	public static void calculateRetirementNumber() {
		eRetirementNumeber = (eMonthDrawDouble-eSSIDouble)*((1-(1/(Math.pow(1+(eRetiredARDouble/100)/12,eYearsRetiredDouble*12 )))))/((eRetiredARDouble/100)/12);	
		eRetirementNumeber = Math.round(eRetirementNumeber * 100.0) / 100.0;
		System.out.println("You need to save $"+ eRetirementNumeber+" in total.");
	}

	//Calculates how much you need to save each month	
	public static void calculateMontlySave() {
		eSavePerMonth = eRetirementNumeber*(((eARDouble/100)/12)/((Math.pow(1+(eARDouble/100)/12, yearsToWorkDouble*12))-1));
		eSavePerMonth = Math.round(eSavePerMonth * 100.0) / 100.0;
		System.out.println("You should save, $"+ eSavePerMonth + " per month");
		System.out.println("Enjoy retirement!");
		
	}
}
