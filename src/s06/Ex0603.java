package s06;
public class Ex0603 {
    public static void main(String[] args) {
        System.out.println(maxof(12,32,65,12));
    }
    public static int maxof(int a, int b){
        int max = 0;
        if (a > b){
            max = a;
        }else{
            max = b;
        }
        return max;
    }
    public static int maxof(int a,int b,int c, int d){
        int max = 0;
        if (maxof(a,b) > maxof(c,d)){
            max = maxof(a,b);
        }else{
            max = maxof(c,d);
        }
        return max;
    }
}
