
/**
 ** Java Program to implement Longest Common Subsequence Algorithm
 **/
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
/** Class  LongestCommonSubsequence **/
public class  LongestCommonSubsequence
{    
    /** function lcs **/
    public String lcs(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
 
        int[][] arr = new int[l1 + 1][l2 + 1];
 
        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else 
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }
 
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2) 
        {
            if (str1.charAt(i) == str2.charAt(j)) 
            {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1]) 
                i++;
            else
                j++;
        }
        return sb.toString();
    }
    
    private static String longestCommonSubstring(String S1, String S2)
    {
        int Start = 0;
        int Max = 0;
        for (int i = 0; i < S1.length(); i++)
        {
            for (int j = 0; j < S2.length(); j++)
            {
                int x = 0;
                while (S1.charAt(i + x) == S2.charAt(j + x))
                {
                    x++;
                    if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
                }
                if (x > Max)
                {
                    Max = x;
                    Start = i;
                }
             }
        }
        return S1.substring(Start, (Start + Max));
    }
    
    public static int longestSubset(int[] array) {
        int min, max, longest = 0;
        for (int i=0; i < array.length; i++) {
            min = array[i];
            max = array[i];
            for (int j=i+1; j < array.length; j++) {
                if (array[j] < min)
                    min = array[j];
                else if (array[j] > max)
                    max = array[j];
                if (max - min <= 1 && (j - i) + 1 > longest)
                    longest = (j - i) + 1;
            }
        }
        return longest;
    }
 
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Subsequence Algorithm Test\n");
 
        System.out.println("\nEnter string 1");
        String str1 = br.readLine();
 
        System.out.println("\nEnter string 2");
        String str2 = br.readLine();
 
        LongestCommonSubsequence obj = new LongestCommonSubsequence(); 
        String result = obj.lcs(str1, str2);
        //String result = longestCommonSubstring(str1, str2);
        System.out.println("\nLongest Common Subsequence : "+ result);
        
        /*int test1[] = {1,5,1,0,2,6,2,1};
        int test2[] = {6,6,5,5,4,4,3,3,2,2,2,1,0,7,7,7,7};
        int test3[] = {0,0,-1,-1,-9,9,-9,9,-9,9,-9,-10,9};
        System.out.println(longestSubset(test1));
        System.out.println(longestSubset(test2));
        System.out.println(longestSubset(test3));*/
    }
}
