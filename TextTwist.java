import java.util.ArrayList;
import java.util.List;

public class TextTwist {
    private WordValidator w;
    public ArrayList<String> result;
    private ArrayList<String> letters;
    private int length;

    public TextTwist(int length, ArrayList<String> letters) {
        this.w = new WordValidator(length);
        this.letters = letters;
        this.result = new ArrayList<>();
        this.length = length;
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

    public void recursiveTextTwistDFS(ArrayList<String> let, String word, int depth) {
        if (depth == 0 && this.w.isWordValid(word) && !this.result.contains(word)) {
            this.result.add(word);
        }
        for (int i = 0; i < (int) let.size(); i++) {
            StringBuilder wrd = new StringBuilder(word);
            ArrayList<String> temp = new ArrayList<>(let);
            wrd.append(temp.remove(i));
            // System.out.println(wrd + " == " + (depth));
            recursiveTextTwistDFS(temp, wrd.toString(), depth - 1);
        }
    }

    public void mainTextTwistBT() {
        recursiveTextTwistBT(letters, "", this.length);
    }

    public static void main(String[] args) {
        ArrayList<String> letters = new ArrayList<>();
        letters.add("r");
        letters.add("l");
        letters.add("i");
        letters.add("l");
        letters.add("e");
        letters.add("f");
        TextTwist t = new TextTwist(6, letters);
        final long startTime = System.currentTimeMillis();
        t.recursiveTextTwistBT(letters, "", 6);
        final long endTime = System.currentTimeMillis();
        System.out.println(t.result + " " + (endTime - startTime) + " ms");
    }
}
