package xrd;

public class Ion {
	String name;
	double A1, A2, A3, A4;
	double B1, B2, B3, B4;
	double C;
	
	public Ion(String n, double[] param) {
		name = n;
		A1 = param[0];
		B1 = param[1];
		A2 = param[2];
		B2 = param[3];
		A3 = param[4];
		B3 = param[5];
		A4 = param[6];
		B4 = param[7];
		C = param[8];
	}
}
