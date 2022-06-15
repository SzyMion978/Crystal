package xrd;

public class Complex {
    public final double re;  
    public final double im;   

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public double abs() {
        return Math.hypot(re, im);
    }

    public double phase() {
        return Math.atan2(im, re);
    }
    public Complex plus(Complex b) {
        Complex a = this;             
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    public Complex conjugate() {
        return new Complex(re, -im);
    }
}
