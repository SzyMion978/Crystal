package xrd;

import java.util.ArrayList;
import java.util.List;

import src.ReadingManager;
import src.panels.Particle;
import src.panels.UnitCell;
import src.renderer.point.MyVector;

public class Func {

	public static List<MyVector> k_vec;
	
	Ions ions;
	public Func() {
		ions = new Ions(); 		
		k_vec = new ArrayList<MyVector>();
		
		// Wektory_sieci_odwrotnej
		add_k(1, 0, 0);
		add_k(0, 1, 0);
		add_k(0, 0, 1);
		
		add_k(1, 0, 1);
		add_k(-1, 0, 1);
		add_k(1, 1, 0);
		
		
		add_k(-1, 1, 0);
		add_k(0, 1, 1);
		add_k(0, -1, 1);
		add_k(1, 1, 1);
		add_k(-1, 1, 1);
		add_k(1, -1, 1);
		add_k(1, 1, -1);
		
		add_k(2, 0, 0);
		add_k(0, 2, 0);
		add_k(0, 0, 2);
		add_k(2, 0, 2);
		add_k(-2, 0, 2);
		add_k(2, 2, 0);
		add_k(-2, 2, 0);
		add_k(0, 2, 2);
		add_k(0, -2, 2);
		
		add_k(2, 2, 2);
		add_k(-2, 2, 2);
		add_k(2, -2, 2);
		add_k(2, 2, -2);	
		
		add_k(0, 1, 2);
		add_k(0, -1, 2);
		add_k(0, 2, 1);
		add_k(0, -2, 1);		
		add_k(2, 1, 0);
		add_k(2, -1, 0);
		add_k(1, 2, 0);
		add_k(1, -2, 0);		
		add_k(1, 0, 2);
		add_k(-1, 0, 2);
		add_k(2, 0, 1);
		add_k(-2, 0, 1);
		
		add_k(1, 1, 2);
		add_k(-1, 1, 2);
		add_k(1, -1, 2);
		add_k(1, 1, -2);		
		add_k(1, 2, 1);
		add_k(-1, 2, 1);
		add_k(1, -2, 1);
		add_k(1, 2, -1);		
		add_k(2, 1, 1);
		add_k(-2, 1, 1);
		add_k(2, -1, 1);
		add_k(2, 1, -1);
		
		add_k(3, 0, 0);
		add_k(0, 3, 0);
		add_k(0, 0, 3);
		
		add_k(2, 2, 1);
		add_k(-2, 2, 1);
		add_k(2, -2, 1);
		add_k(2, 2, -1);		
		add_k(2, 1, 2);
		add_k(-2, 1, 2);
		add_k(2, -1, 2);
		add_k(2, 1, -2);		
		add_k(1, 2, 2);
		add_k(-1, 2, 2);
		add_k(1, -2, 2);
		add_k(1, 2, -2);
		
		add_k(0, 1, 3);
		add_k(0, -1, 3);
		add_k(0, 3, 1);
		add_k(0, -3, 1);		
		add_k(3, 1, 0);
		add_k(3, -1, 0);
		add_k(1, 3, 0);
		add_k(1, -3, 0);		
		add_k(1, 0, 3);
		add_k(-1, 0, 3);
		add_k(3, 0, 1);
		add_k(-3, 0, 1);
		
		add_k(0, 2, 3);
		add_k(0, -2, 3);
		add_k(0, 3, 2);
		add_k(0, -3, 2);		
		add_k(3, 2, 0);
		add_k(3, -2, 0);
		add_k(2, 3, 0);
		add_k(2, -3, 0);		
		add_k(2, 0, 3);
		add_k(-2, 0, 3);
		add_k(3, 0, 2);
		add_k(-3, 0, 2);
		
		add_k(1, 1, 3);
		add_k(-1, 1, 3);
		add_k(1, -1, 3);
		add_k(1, 1, -3);		
		add_k(1, 3, 1);
		add_k(-1, 3, 1);
		add_k(1, -3, 1);
		add_k(1, 3, -1);		
		add_k(3, 1, 1);
		add_k(-3, 1, 1);
		add_k(3, -1, 1);
		add_k(3, 1, -1);
		
		add_k(0, 1, 4);
		add_k(0, -1, 4);
		add_k(0, 4, 1);
		add_k(0, -4, 1);		
		add_k(4, 1, 0);
		add_k(4, -1, 0);
		add_k(1, 4, 0);
		add_k(1, -4, 0);		
		add_k(1, 0, 4);
		add_k(-1, 0, 4);
		add_k(4, 0, 1);
		add_k(-4, 0, 1);
		
		add_k(1,2,3);
		add_k(-1,2,3);
		add_k(1,-2,3);
		add_k(1,2,-3);		
		add_k(2,1,3);
		add_k(-2,1,3);
		add_k(2,-1,3);
		add_k(2,1,-3);		
		add_k(2,3,1);
		add_k(-2,3,1);
		add_k(2,-3,1);
		add_k(2,3,-1);		
		add_k(3,2,1);
		add_k(-3,2,1);
		add_k(3,-2,1);
		add_k(3,2,-1);		
		add_k(3,1,2);
		add_k(-3,1,2);
		add_k(3,-1,2);
		add_k(3,1,-2);		
		add_k(1,3,2);
		add_k(-1,3,2);
		add_k(1,-3,2);
		add_k(1,3,-2);
		
		add_k(1, 1, 4);
		add_k(-1, 1, 4);
		add_k(1, -1, 4);
		add_k(1, 1, -4);		
		add_k(1, 4, 1);
		add_k(-1, 4, 1);
		add_k(1, -4, 1);
		add_k(1, 4, -1);		
		add_k(4, 1, 1);
		add_k(-4, 1, 1);
		add_k(4, -1, 1);
		add_k(4, 1, -1);
		
		add_k(3, 3, 3);
		add_k(-3, 3, 3);
		add_k(3, -3, 3);
		add_k(3, 3, -3);
		
		add_k(3, 0, 3);
		add_k(-3, 0, 3);
		add_k(3, 3, 0);
		add_k(-3, 3, 0);
		add_k(0, 3, 3);
		add_k(0, -3, 3);
		
		add_k(2, 2, 3);
		add_k(-2, 2, 3);
		add_k(2, -2, 3);
		add_k(2, 2, -3);		
		add_k(2, 3, 2);
		add_k(-2, 3, 2);
		add_k(2, -3, 2);
		add_k(2, 3, -2);		
		add_k(3, 2, 2);
		add_k(-3, 2, 2);
		add_k(3, -2, 2);
		add_k(3, 2, -2);
		
		add_k(3, 3, 2);
		add_k(-3, 3, 2);
		add_k(3, -3, 2);
		add_k(3, 3, -2);		
		add_k(3, 2, 3);
		add_k(-3, 2, 3);
		add_k(3, -2, 3);
		add_k(3, 2, -3);		
		add_k(2, 3, 3);
		add_k(-2, 3, 3);
		add_k(2, -3, 3);
		add_k(2, 3, -3);
		
		add_k(3, 3, 1);
		add_k(-3, 3, 1);
		add_k(3, -3, 1);
		add_k(3, 3, -1);		
		add_k(3, 1, 3);
		add_k(-3, 1, 3);
		add_k(3, -1, 3);
		add_k(3, 1, -3);		
		add_k(1, 3, 3);
		add_k(-1, 3, 3);
		add_k(1, -3, 3);
		add_k(1, 3, -3);
		
		
		add_k(0, 2, 4);
		add_k(0, -2, 4);
		add_k(0, 4, 2);
		add_k(0, -4, 2);		
		add_k(4, 2, 0);
		add_k(4, -2, 0);
		add_k(2, 4, 0);
		add_k(2, -4, 0);		
		add_k(2, 0, 4);
		add_k(-2, 0, 4);
		add_k(4, 0, 2);
		add_k(-4, 0, 2);
		
		add_k(0, 3, 4);
		add_k(0, -3, 4);
		add_k(0, 4, 3);
		add_k(0, -4, 3);		
		add_k(4, 3, 0);
		add_k(4, -3, 0);
		add_k(3, 4, 0);
		add_k(3, -4, 0);		
		add_k(3, 0, 4);
		add_k(-3, 0, 4);
		add_k(4, 0, 3);
		add_k(-4, 0, 3);
		

		
		add_k(2, 2, 4);
		add_k(-2, 2, 4);
		add_k(2, -2, 4);
		add_k(2, 2, -4);		
		add_k(2, 4, 2);
		add_k(-2, 4, 2);
		add_k(2, -4, 2);
		add_k(2, 4, -2);		
		add_k(4, 2, 2);
		add_k(-4, 2, 2);
		add_k(4, -2, 2);
		add_k(4, 2, -2);
		
		add_k(3, 3, 4);
		add_k(-3, 3, 4);
		add_k(3, -3, 4);
		add_k(3, 3, -4);		
		add_k(3, 4, 3);
		add_k(-3, 4, 3);
		add_k(3, -4, 3);
		add_k(3, 4, -3);		
		add_k(4, 3, 3);
		add_k(-4, 3, 3);
		add_k(4, -3, 3);
		add_k(4, 3, -3);
		
		add_k(1, 4, 4);
		add_k(1, -4, 4);
		add_k(1, 4, 4);
		add_k(1, -4, 4);		
		add_k(4, 4, 1);
		add_k(4, -4, 1);
		add_k(4, 4, 1);
		add_k(4, -4, 1);		
		add_k(4, 1, 4);
		add_k(-4, 1, 4);
		add_k(4, 1, 4);
		add_k(-4, 1, 4);
		
		add_k(2, 4, 4);
		add_k(2, -4, 4);
		add_k(2, 4, 4);
		add_k(2, -4, 4);		
		add_k(4, 4, 2);
		add_k(4, -4, 2);
		add_k(4, 4, 2);
		add_k(4, -4, 2);		
		add_k(4, 2, 4);
		add_k(-4, 2, 4);
		add_k(4, 2, 4);
		add_k(-4, 2, 4);
		
		add_k(3, 4, 4);
		add_k(3, -4, 4);
		add_k(3, 4, 4);
		add_k(3, -4, 4);		
		add_k(4, 4, 3);
		add_k(4, -4, 3);
		add_k(4, 4, 3);
		add_k(4, -4, 3);		
		add_k(4, 3, 4);
		add_k(-4, 3, 4);
		add_k(4, 3, 4);
		add_k(-4, 3, 4);
		
		add_k(4, 4, 4);
		add_k(-4, 4, 4);
		add_k(4, -4, 4);
		add_k(4, 4, -4);
	}
	
	private static void add_k(int h, int k, int l) {
		MyVector kk = new MyVector(
				h/ReadingManager.unitCell.a,
				k/ReadingManager.unitCell.b,
				l/ReadingManager.unitCell.c);
		k_vec.add(kk);
	}
	
	// Czynnik_Lorentza
	public static double Lp(double theta) {
		return (1 + Math.cos(2 * theta)*Math.cos(2 * theta))/(Math.cos(theta) * Math.sin(theta)*Math.sin(theta));
	}
	// Czynnik_atomowy
	public static double fj(double x, String name) {
		double[] coeff = Ions.giveParam(name);
		double sum = 0;
		for(int i = 0; i < 8; i+=2) {
			sum += coeff[i]*Math.exp(-1*coeff[i+1] * (x*x));
		}
		sum += coeff[8];
		return sum;
	}
	// Czynnik_struktury
	public static Complex F(MyVector k, double lambda, double theta) {
		
		double real_sum = 0;
		double im_sum = 0;		
		for (Particle p : UnitCell.particles) {
			if((p.x/ReadingManager.scale + ReadingManager.unitCell.a/2) > 0.99*ReadingManager.unitCell.a 
					|| (p.y/ReadingManager.scale + ReadingManager.unitCell.b/2) > 0.99 * ReadingManager.unitCell.b 
					|| (p.z/ReadingManager.scale + ReadingManager.unitCell.c/2) > 0.99 * ReadingManager.unitCell.c)
				continue;

			double dot = k.x * (p.x / ReadingManager.scale + ReadingManager.unitCell.a / 2) 
					+ k.y * (p.y / ReadingManager.scale + ReadingManager.unitCell.b / 2) 
					+ k.z * (p.z / ReadingManager.scale + ReadingManager.unitCell.c / 2);
			double f = fj(Math.sin(theta) / lambda, p.name);
			real_sum += f * Math.cos(2*Math.PI * dot);
			im_sum += f * Math.sin(2*Math.PI * dot);
			
		}
		return new Complex(real_sum, im_sum);
	}
	
	public double Intensity(double lambda, double theta, MyVector k) {		 
		Complex F = F(k, lambda, theta);
		double Isum = Lp(theta)*(F.re*F.re + F.im*F.im)/UnitCell.particles.length;	
		return Isum;
	}
}
