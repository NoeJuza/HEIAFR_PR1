package s11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex1105 {
    public static void main(String[] args) {
        String inputFileName;
        if (args.length > 0){
            inputFileName = args[0];
        }else {
            System.err.println("Indiquez le nom du fichier d'entrée:");
            Scanner sc = new Scanner(System.in);
            inputFileName = sc.nextLine();
        }
        try (BufferedReader rd = new BufferedReader(new FileReader( new File(new File(new File(".","src" ),"s11"),inputFileName) ))){
            String fileContent = "";
            String line;
            int lcount = 0; // line count
            int wcount = 0; // word count
            int ccount = 0; // char count

            while ( (line = rd.readLine()) != null){
                fileContent += line;
                lcount++;
            }
            //System.out.println(fileContent);
            StringTokenizer t = new StringTokenizer(fileContent); // Déclaration d'un découpeur de mots
            wcount = t.countTokens(); // Calcul du nombre de mots dans le String

            while(t.hasMoreTokens()) { // Teste s'il reste des mots à parcourir
                String word = t.nextToken(); // Consulter le prochain mot
                ccount += word.length();
            }
            System.out.println("Number of lines: " + lcount + "\r\nNumber of words: " + wcount + "\r\nNumber of chars: " + ccount);
        } catch (Exception e){
            System.err.println("Problème durant l'execution: " + e.toString());
        }
    }
}
