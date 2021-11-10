//==============================================================================
// HEIA-FR / F. Bapst
//==============================================================================
package corr.s12;

public class Ex1203_Corr {
  public static void main(String [] args) {
    solve1();
    System.out.println("or... (please wait !)");
    solve2();
  }
  // --------------------
  static void traceSolution(int mark, int allen, int weiss) {
    System.out.println("MARK="+mark +" ALLEN="+allen +" WEISS="+weiss);
  }
  // ============================================================
  public static void solve2() {
    for (int i=10_000; i<99_999; i++) {     // any 5-digit number for weiss
      if (i%1000==0) System.out.println(i); // just to follow on screen...
      for(int j=1_000; j<9_999; j++) {      // any 4-digit number for mark
        testSol(j, i-j, i);
      }
    }
  }
  // --------------------
  static void testSol(int mark, int allen, int weiss) {
    boolean[] used = new boolean[10];
    resetSol(used);
    assignDigits(mark, allen, weiss, used);
    if (failRepetition(mark, allen, weiss))
      return;
    if (failUseAll(used))
      return;
    traceSolution(mark, allen, weiss);
  }
  // --------------------
  static void resetSol(boolean[] used) {
    for (int i=0; i<10; i++)
      used[i] = false;
  }
  // --------------------
  static void assignDigits(int mark, int allen, int weiss, 
                           boolean[] used) {
    for (int i=0; i<4; i++) {
      used[digit(mark,  i)] = true;
      used[digit(allen, i)] = true;
      used[digit(weiss, i)] = true;
    }
    used[digit(allen, 4)] = true;
    used[digit(weiss, 4)] = true;
  }
  // --------------------
  static boolean failUseAll(boolean[] used) {
    for (int i=0; i<10; i++) {
      if (! used[i]) return true;
    }
    return false;
  }
  // --------------------
  static boolean failRepetition(int mark, int allen, int weiss) {
    if (digit(mark,  2) != digit(allen, 4))  return true;
    if (digit(allen, 1) != digit(weiss, 3))  return true;
    if (digit(allen, 3) != digit(allen, 2))  return true;
    if (digit(weiss, 0) != digit(weiss, 1))  return true;
    return false;
  }
  // --------------------
  static int digit(int x0, int i0) {
    int x=x0; int i=i0;
    while(i>0) {
      x = x/10; i--;
    }
    //System.out.println("Digit "+x0+" "+i+ " "+x%10);
    return x%10;
  }
  //============================================================
  // this kind of code, with 10 nested loops, is clearly not very elegant... 
  public static void solve1() {
    boolean[] u = new boolean[10];  // means isUsed[]
    int m, a, r, k, l, e, n, w, i, s;
    for (m=0; m<=9; m++) {if (u[m]){continue;} u[m] = true;
     for (a=0; a<=9; a++) {if (u[a]){continue;} u[a] = true;
      for (r=0; r<=9; r++) {if (u[r]){continue;} u[r] = true;
       for (k=0; k<=9; k++) {if (u[k]){continue;} u[k] = true;
        for (l=0; l<=9; l++) {if (u[l]){continue;} u[l] = true;
         for (e=0; e<=9; e++) {if (u[e]){continue;} u[e] = true;
          for (n=0; n<=9; n++) {if (u[n]){continue;} u[n] = true;
           for (w=0; w<=9; w++) {if (u[w]){continue;} u[w] = true;
            for (i=0; i<=9; i++) {if (u[i]){continue;} u[i] = true;
             for (s=0; s<=9; s++) {if (u[s]){continue;} u[s] = true;
              testSol(m, a, r, k, l, e, n, w, i, s);
              u[s] = false; }
             u[i] = false; }
            u[w] = false; }
           u[n] = false; }
          u[e] = false; }
         u[l] = false; }
        u[k] = false; }
       u[r] = false; }
      u[a] = false; }
     u[m] = false;
    }
  }
  // --------------------
  static void testSol(int m, int a, int r, int k, int l, int e, 
                             int n, int w, int i, int s) {
    int mark  = k + 10*r + 100*a + 1000*m;
    int allen = n + 10*e + 100*l + 1000*l + 10000*a;
    int weiss = s + 10*s + 100*i + 1000*e + 10000*w;
    if (mark + allen == weiss)
      traceSolution(mark, allen, weiss);
  }
  // --------------------
}
