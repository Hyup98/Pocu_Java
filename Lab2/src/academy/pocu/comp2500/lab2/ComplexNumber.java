package academy.pocu.comp2500.lab2;


public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber()
    {
        this.real = 0.0;
        this.imaginary = 0.0;
    }
    public  ComplexNumber(double real)
    {
        this.real = real;
        this.imaginary = 0.0;
    }
    public  ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal()
    {
        if (imaginary == 0.0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public boolean isImaginary()
    {
        if (real == 0.0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public ComplexNumber getConjugate()
    {
        ComplexNumber num = new ComplexNumber(this.real, -this.imaginary);
        return num;
    }

    public  ComplexNumber add(ComplexNumber rhs)
    {
        ComplexNumber num = new ComplexNumber(this.real + rhs.real, this.imaginary + rhs.imaginary);
        return num;
    }

    public  ComplexNumber subtract(ComplexNumber rhs)
    {
        ComplexNumber num = new ComplexNumber(this.real - rhs.real, this.imaginary - rhs.imaginary);
        return num;
    }

    public  ComplexNumber multiply(ComplexNumber rhs)
    {
        double temReal = this.real * rhs.real - this.imaginary * rhs.imaginary;
        double temImag = this.imaginary*rhs.real + this.real* rhs.imaginary;
        ComplexNumber num = new ComplexNumber(temReal, temImag);
        return num;
    }

    public  ComplexNumber divide(ComplexNumber rhs)
    {
        ComplexNumber tem1 = new ComplexNumber(this.real ,this.imaginary);
        ComplexNumber tem2 = new ComplexNumber(rhs.real ,-rhs.imaginary);
        ComplexNumber tem3 = tem1.multiply(tem2);
        ComplexNumber answer = new ComplexNumber(tem3.real/(rhs.real* rhs.real + rhs.imaginary* rhs.imaginary), tem3.imaginary/(rhs.real* rhs.real + rhs.imaginary* rhs.imaginary));
        return answer;
    }

}
