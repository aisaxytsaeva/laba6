import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.*;
public class TopWords {
    private static final Pattern PUNCTUATION_PATTERN = Pattern.compile("\\p{Punct}");

    private static String cleanWord(String word) {
        Matcher matcher = PUNCTUATION_PATTERN.matcher(word);
        return matcher.replaceAll("");
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Professional\\учеба\\итип\\laba6\\Text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> topWords = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            word = cleanWord(word); 
            if (!word.isEmpty() && Character.isLetter(word.charAt(0))) {
                if (topWords.containsKey(word)) {
                    topWords.put(word, topWords.get(word) + 1);
                } else {
                    topWords.put(word, 1);
                }
            }
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(topWords.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.printf("%d. %s (%d)\n", i + 1, list.get(i).getKey(), list.get(i).getValue());
        }
    }


    
}
