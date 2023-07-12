package utilityMethods;

import java.util.StringTokenizer;

public class SearchUtility {
    /**
     *
     * @param stringToSearch - the string object to search through.
     * @param key - The word within stringToSearch to look for.
     * @return - -1 if the key is not in the entered string, or the index the key was found at.
     */
    public static int sequentialSearchForTokenKey(String stringToSearch,String key){
        int indexFound = -1;
        StringTokenizer tokenizer = new StringTokenizer(stringToSearch);
        int index = 0;
        while(tokenizer.hasMoreTokens()){
            if(tokenizer.nextToken().equals(key.toString())){
                indexFound = index;
                return indexFound;
            }
            index++;
        }
        return indexFound;
    }
}
