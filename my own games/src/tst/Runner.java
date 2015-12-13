package tst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.swing.text.html.HTML;

public class Runner {

	static ArrayList<Character> sToChar;
	static ArrayList<Node> nodes;
	static ArrayList<String> words;

	public static void main(String args[]) {
		String toSearch;
		String Url = "http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt";
		sToChar = new ArrayList<Character>();
		nodes = new ArrayList<Node>();
		Random rand = new Random();
		words = new ArrayList<String>();

		ArrayList<String> Html = new ArrayList<String>();
		URL oracle;
		try {
			oracle = new URL(Url);
			BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				//System.out.println("working");
				Html.add(rand.nextInt(Html.size() + 1), inputLine);
			}
		} catch (IOException e) {

			System.out.println("inputted Url did not work");
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < Html.size(); i++) {
			if (Html.get(i).isEmpty() == false) {
				insert(Html.get(i));
			}

		}
		System.out.println(System.currentTimeMillis());
		
		System.out.println(search("hello"));
		System.out.println(search("hell"));
		System.out.println(search("hello321"));
		System.out.println(search("hellno"));

		while (true) {

			toSearch = JOptionPane.showInputDialog("search for a word?");
			System.out.println(System.currentTimeMillis());
			search(toSearch);
			System.out.println(System.currentTimeMillis());
			JOptionPane.showMessageDialog(null, search(toSearch));
			
		}
	}

	public static void insert(String toInsert) {
		int[] compare = new int[2];
		// System.out.println(toInsert);
		int currentNode = 0;
		// System.out.println(currentNode);

		toCharArray(toInsert);

		if (nodes.size() == 0) {
			// System.out.println("didthis");
			nodes.add(new Node(sToChar.get(0)));
			// System.out.println((nodes.get(0)).getValue());

		}
		while (true) {

			if (sToChar.size() == 1) {
				// System.out.println("finished");
				nodes.get(currentNode).setEnd(true);
				break;
			}
			// System.out.println(sToChar.get(0) + toInsert);
			compare = nodes.get(currentNode).compare(sToChar.get(0));
			// System.out.println(compare[0] + "\t" + compare[1]);
			if (compare[0] == 0) {
				sToChar.remove(0);
				if (compare[1] == -1) {

					nodes.add(new Node(sToChar.get(0)));
					nodes.get(currentNode).setEqualKid(nodes.size() - 1);
					currentNode = nodes.get(currentNode).equalKid;

				} else {
					currentNode = compare[1];
				}
			}
			if (compare[0] == -1) {
				if (compare[1] == -1) {
					nodes.add(new Node(sToChar.get(0)));
					nodes.get(currentNode).setLoKid(nodes.size() - 1);
					currentNode = nodes.get(currentNode).loKid;
				} else {
					currentNode = compare[1];
				}
			}
			if (compare[0] == 1) {
				if (compare[1] == -1) {
					nodes.add(new Node(sToChar.get(0)));
					nodes.get(currentNode).setHiKid(nodes.size() - 1);
					currentNode = nodes.get(currentNode).hiKid;
				} else {
					currentNode = compare[1];
				}
			}
		}

	}

	public static boolean search(String toSearch) {
		boolean found = false;
		int[] compare = new int[2];
		int currentNode = 0;
		// System.out.println(toSearch);
		toCharArray(toSearch);
		// System.out.println(sToChar.size());
		while (true) {
			// System.out.println(currentNode);
			// System.out.println(sToChar.size());
			if (sToChar.size() == 1) {
				System.out.println("here");
				if (nodes.get(currentNode).end == true) {
					found = true;
				}
				break;
			}
			compare = nodes.get(currentNode).compare(sToChar.get(0));
			if (compare[1] == -1) {
				found = false;
				break;
			} else {
				currentNode = compare[1];
			}
			if (compare[0] == 0) {
				sToChar.remove(0);
			}

		}
		return found;

	}

	public void getWords() {

	}

	public static void toCharArray(String tochar) {
		sToChar.clear();
		for (int i = 0; i < tochar.length(); i++) {
			sToChar.add(tochar.charAt(i));
		}

	}

}
