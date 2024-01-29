

public class HashTagTokenizer {

	public static void main(String[] args) 
	{

		String hashTag = "iloverecursion";
		String []dictionary = readDictionary("dictionary.txt");
		System.out.println(existInDictionary("zone8", dictionary));
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) 
	{
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		String stringline = "";
		for(int i = 0; i < dictionary.length; i++)
		{
			stringline = in.readLine();
			dictionary[i] = stringline;
		}
		return dictionary;
	}
	/*The function public static boolean existInDictionary(String word, String[] dictionary) 
	is designed to take a string as an input and determine its presence in the dictionary. 
	It returns true if the word is found within the dictionary array, and false if it is not.  */
	public static boolean existInDictionary(String word, String []dictionary) 
	{
		boolean flag = false;
		boolean flagW = true;
		int j = 0;
		for(int i = 0; i < dictionary.length; i++)
		{
			if(dictionary[i].length() == word.length()) //Checks if the lengths are equal. If not it passes above the while and goes to the next word.
			{
				flagW = true;
			}
			else
			{
				flagW = false;
			}
			j = 0;
			while((j < word.length()) && (flagW))
			{
				if(word.charAt(j)!= dictionary[i].charAt(j))
				{
					flagW = false;
				}
				j++;
			}
			if(flagW == true)
			{
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) 
	{

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) 
		{
            return;
        }
        int N = hashtag.length();
		hashtag = hashtag.toLowerCase();
		String originial = hashtag;
        for (int i = 1; i <= N; i++) 
		{
			hashtag = originial.substring(0, i);
			if(existInDictionary(hashtag, dictionary))
			{
				System.out.println(hashtag);
				breakHashTag(originial.substring(i), dictionary);
				return;
			}
        }
		
    }

}
