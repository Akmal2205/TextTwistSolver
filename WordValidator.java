import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordValidator {
    public String dictionary_filename = "oracle_dictionary.txt";
    public List<String> dictionary_map = new ArrayList<String>();

    public WordValidator(int length) {
        File file = new File(
                "C:\\Users\\ASUS\\Documents\\Sem 4\\Stima\\Implementation\\makalah\\TextTwistSolver\\"
                        + this.dictionary_filename);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        // System.out.println("Initializing..");
        try {
            while ((st = br.readLine()) != null) {
                if (st.length() == length) {
                    this.dictionary_map.add(st);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("Done");
    }

    public Boolean isPrefixValid(String word) {
        for (String wrd : this.dictionary_map) {
            if (wrd.startsWith(word)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isWordValid(String word) {
        return this.dictionary_map.contains(word);
    }

    // public static void main(String[] args) {
    // Scanner input_word = new Scanner(System.in);
    // System.out.print("Masukkan word : ");
    // String word = input_word.nextLine();
    // WordValidator w = new WordValidator(word, 3);
    // System.out.println(w.isPrefixValid(word.toLowerCase()));
    // }
}
