package s03;

public class Ex0302 {
    public static void main(String[] args) {
        int a = 0,b = 0,c = 0,d = 0,x =0;
        if (a<b){
            if (c<d){
                x=1;
            }else{
                x=6;
            }
            if (a<d){
                if (b>c){
                    x=4;
                }else {
                    x=5;
                }
            }else{

            }
        }else{
            x=7;
        }
        if (a<b){
            if (c<d) {
                x=1;
            } else {
                if (a<c){
                    if (b<d){
                        x=2;
                    }else{
                        x=3;
                    }
                }else {
                    if (a < d) {
                        if (b > c) {
                            x = 4;
                        } else {
                            x = 5;
                        }
                    } else {
                        x = 6;
                    }
                }
            }
        }else{
            x=7;
        }

    }
}
