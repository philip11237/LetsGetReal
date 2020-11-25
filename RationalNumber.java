public class RationalNumber extends Number {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int num, int den){
  //this value is ignored!
    if (den==0){
      denominator=1;
      numerator=0;

    }
    else {
    numerator=num;
   denominator=den;
 }
  }

  public double getValue(){
    return (double)numerator/denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator,numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    other.reduce();
    this.reduce();
    return ((other.numerator==this.numerator)&& (other.denominator==this.numerator));
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    this.reduce();
    return this.numerator+"/"+this.denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one
    If a<b, exchange a and b.
Divide a by b and get the remainder, r. If r=0, report b as the GCD of a and b.
Replace a by b and replace b by r. Return to the previous step.*/
    //sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if (a<0){
      a=Math.abs(a);
    }
    if (b<0){
      b=Math.abs(b);
    }
      if (a<b){
        return gcd(b,a);
      }
      if (b==0){
        return 0;
      }
      int r=a % b;
      if (r==0)
    {
      return b;
    }
    else {
       return gcd(b,r);
    }
  }
  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){

    if (denominator<0){
      denominator*=-1;
      numerator*=-1;
    }
    int gcd=gcd (numerator,denominator);
    if (gcd==0){
      return;
    }
    numerator=numerator/gcd;
    denominator=denominator/gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
      RationalNumber answer=new RationalNumber ( (this.numerator*other.numerator), this.denominator*other.denominator);

        answer.reduce();
        return answer;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber answer=new RationalNumber ( (this.numerator*other.denominator), this.denominator*other.numerator);

      answer.reduce();
      return answer;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber answer=new RationalNumber ( (this.numerator*other.denominator)+ this.denominator*other.numerator,(this.denominator*other.denominator));
      answer.reduce();
      return answer;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
     RationalNumber answer=new RationalNumber ( (this.numerator*other.denominator) - this.denominator*other.numerator,(this.denominator*other.denominator));
      answer.reduce();
      return answer;
  }
}
