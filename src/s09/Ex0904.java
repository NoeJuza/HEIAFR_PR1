package s09;

public class Ex0904 {
  
  public static char extPos(String s, int p) {
    if (s != null && s.length()>0)
      return s.charAt(p);
    else
      return '?';
  }

  public static void main(String[] args) {
    String txt = "A certain text";
    scan(txt);
  }
  
  public static void scan(String t) {
    int cnt=0, len=t.length();
    
    for (int i=len; i>(len/2); i--) {
      if (extPos(t, i)=='e') cnt++;
    }
    System.out.println(cnt);
  }
}
