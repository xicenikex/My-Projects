
public class Calculations {
	
	public static String computeSimpleInterest(double principle, double rate, double years) {
		String statement1 = "";
		String simple = "";
		double simpleInterest = 0.0;
		
		for(int i=1; i <= years; i++) {
			simpleInterest = principle + (principle * (rate/100) * i);
			simple = String.format("%,.2f", simpleInterest);
			statement1 += i + "-->$" + simple + "\n";
		}
		String display = "Principle: " + principle + ", Rate: " + rate 
				+ "\nYear, Simple Interest\n";
		return display + statement1;
	}

	public static String computeCompoundInterest(double principle, double rate, double years) {
		String statement2 = "";
		String compound = "";
		double compoundInterest = 0.0;
		for(int i=1; i <= years; i++) {
			compoundInterest = principle * Math.pow((1+rate/100), i);
			compound = String.format("%,.2f", compoundInterest);
			statement2 += i + "-->$" + compound + "\n";
		}
		String display = "Principle: " + principle + ", Rate: " + rate 
				+ "\nYear Compound Interest\n";
		return display + statement2;
	}
	
	public static String bothStrings(double principle, double rate, double years) {
		double simpleInterest = 0.0, compoundInterest = 0.0;
		String simple = "", compound = "", both = "";
		
		for(int i=1; i <= years; i++) {
			simpleInterest = principle * (1 + (rate/100) * i);
			simple = String.format("%,.2f", simpleInterest);
			compoundInterest = principle * Math.pow((1+(rate/100)), i);
			compound = String.format("%,.2f", compoundInterest);
			both += i + "-->$" + simple + "-->$" + compound + "\n";
		}
		
		String display = "Principle: " + principle + ", Rate: " + rate 
				+ "\nYear, Simple Interest, Compound Interest\n";
		return display + both;
	}
}
