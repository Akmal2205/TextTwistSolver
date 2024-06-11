import java.util.ArrayList;
import java.util.List;

public class TextTwist {
    private WordValidator w;
    public ArrayList<String> result;

    public TextTwist(int length, ArrayList<String> letters) {
        this.w = new WordValidator(length);
        this.result = new ArrayList<>();
    }

    public Boolean boundFunction(String word) {
        return w.isPrefixValid(word);
    }

    public void recursiveTextTwistBT(ArrayList<String> let, String word, int depth) {
        if (depth == 0 && this.w.isWordValid(word) && !this.result.contains(word)) {
            this.result.add(word);
        }
        if (boundFunction(word)) {
            for (int i = 0; i < (int) let.size(); i++) {
                StringBuilder wrd = new StringBuilder(word);
                ArrayList<String> temp = new ArrayList<>(let);
                wrd.append(temp.remove(i));
                // System.out.println(wrd + " == " + (depth));
                recursiveTextTwistBT(temp, wrd.toString(), depth - 1);
            }
        }
    }

    public void recursiveTextTwistDLS(ArrayList<String> let, String word, int depth) {
        if (depth == 0 && this.w.isWordValid(word) && !this.result.contains(word)) {
            this.result.add(word);
        }
        for (int i = 0; i < (int) let.size(); i++) {
            StringBuilder wrd = new StringBuilder(word);
            ArrayList<String> temp = new ArrayList<>(let);
            wrd.append(temp.remove(i));
            recursiveTextTwistDLS(temp, wrd.toString(), depth - 1);
        }
    }

}
