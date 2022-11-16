package s11;

import static java.lang.System.exit;

public class Ex1102 {

    public static void main(String[] args) {
        int sum = 0;
        try {
            for (int i = 0; i < args.length; i++) {
                sum += Integer.valueOf(args[i]);
            }
        } catch (Exception e) {
            System.err.println("Merci de n'envoyer que des nombres entiers en paramètre");
            exit(1);
        }
        System.out.println("La somme des valeurs des paramètres est de: " + sum);
    }
}