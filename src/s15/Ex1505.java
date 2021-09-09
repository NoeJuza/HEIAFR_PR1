//==============================================================================
//  HEIA-FR
//==============================================================================
/*01*/ package s15;
/*02*/
/*03*/   public class Ex1505 {
/*04*/     public static void main(String [] args) {
/*05*/       Thing x = new Thing(4);
/*06*/       int u=x.f(x.f(3));
/*07*/       x.a = x.a+1;
/*08*/       System.out.println(u +" "+ x.a);
/*09*/       Thing y = new Thing(2);
/*10*/       u=y.f(5);
/*11*/       System.out.println(u +" "+ x.a);
/*12*/       System.out.println(y.a);
/*13*/     }
/*14*/   }