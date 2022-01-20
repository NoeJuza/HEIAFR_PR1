
package corr.s25;

import java.util.function.LongBinaryOperator;

public class HexNumberVariants {
  
  //=======================================================
  // reuse BasedNumber by composition
  public static class HexNumberV1 {
    private static final int BASE=16;
    
    private BasedNumber basedNumber;
    
    public HexNumberV1(String s) {
      basedNumber = new BasedNumber(s, BASE);
    }
    
    public long asLong() {
      return basedNumber.asLong();
    }
    
    public void add(HexNumberV1 n) {
      applyBinaryOp(n, (a,b)->a+b);
      
      // or, without using that private method:
      //   long a=this.basedNumber.asLong();
      //   long b=n.basedNumber.asLong();
      //   basedNumber = new BasedNumber(String.valueOf(a+b), BASE);
      
      // or, if basedNumber.number is accessible: 
      //   basedNumber.number += n.basedNumber.number;
    }
    
    public void subtract(HexNumberV1 n) {
      applyBinaryOp(n, (a,b)->a-b);
    }
    
    public void multiply(HexNumberV1 n) {
      applyBinaryOp(n, (a,b)->a*b);
    }
    
    private void applyBinaryOp(HexNumberV1 n, LongBinaryOperator op) {
      long a = this.basedNumber.asLong();
      long b =    n.basedNumber.asLong();
      long res=op.applyAsLong(a,b);
      basedNumber = new BasedNumber(String.valueOf(res), 10);
    }
    
    public String toString() {
      return basedNumber.inBase(BASE);
    }

  }

  //=======================================================
  // reuse BasedNumber without inheritance nor composition
  public static class HexNumberV2 {
    private static final int BASE=16;

    private String hexString;
    
    public HexNumberV2(String s) {
      hexString = (fromHexString(s)).inBase(BASE);
    }
    
    public long asLong() {
      return fromHexString(hexString).asLong();
    }
    
    public void add(HexNumberV2 n) {
      applyBinaryOp(n, (a,b)->a+b);
    }
    
    public void subtract(HexNumberV2 n) {
      applyBinaryOp(n, (a,b)->a-b);
    }
    
    public void multiply(HexNumberV2 n) {
      applyBinaryOp(n, (a,b)->a*b);
    }
    
    private BasedNumber fromHexString(String s) {
      return new BasedNumber(s, BASE);
    }
    
    private void applyBinaryOp(HexNumberV2 n, LongBinaryOperator op) {
      long a=fromHexString(this.hexString).asLong();
      long b=fromHexString(   n.hexString).asLong();
      long res=op.applyAsLong(a,b);
      BasedNumber result = new BasedNumber(String.valueOf(res), 10);
      hexString = result.inBase(BASE);
    }

    public String toString() {
      return hexString;
    }

  }

  //=======================================================
  public static void main(String[] args) {
    HexNumberV1 a;
    a=new HexNumberV1("1F4B");
    a.add(new HexNumberV1("A8C7"));
    System.out.println(a); // -> "C812"

    HexNumberV2 b;
    b=new HexNumberV2("1F4B");
    b.add(new HexNumberV2("A8C7"));
    System.out.println(b); // -> "C812"
  }

}
