import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;


public class WordFrequency {

	private HashMap<String, Integer> map;
	
	
	public WordFrequency() {
		map = new HashMap<String, Integer>();
	}
	
	public static void sortByDescending(ArrayList<Entry<String, Integer>> l) {
		Collections.sort(l, new Comparator<Entry<String, Integer>>()
		        {
		            public int compare(Entry<String, Integer> a,
		                    Entry<String, Integer> b)
		            {
		            	if (a.getValue() == b.getValue()) {
		            		return (a.getKey().compareTo(b.getKey()));
		            	}
		            	return b.getValue().compareTo(a.getValue());

		            }
		        });
	}
	
	public static void printWords(ArrayList<Entry<String, Integer>> l, int k) {
		int i = 0;
		while (i < l.size() && k > 0) {
			System.out.println(l.get(i).getKey());
			i++;
			k--;
		}
	}
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String size = in.readLine();
		int n = Integer.parseInt(size);
		
		WordFrequency w = new WordFrequency();
		
		while (n > 0) {
			String word = in.readLine();
			if (w.map.containsKey(word)) {
				int i = w.map.get(word);
				w.map.put(word, i + 1);
			} else {
				w.map.put(word, 1);
			}
			n--;
		}
		
		int k = Integer.parseInt(in.readLine());
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(w.map.entrySet());
		sortByDescending(list);
		printWords(list, k);
		
	}

}
