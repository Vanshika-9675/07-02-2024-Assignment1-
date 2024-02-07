import java.util.*;

class Assignment1{

    //function for checking if two strings are anagrams or not
    public static boolean Anagrams(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        int []count1 = new int[26];
        int []count2 = new int[26];

        Arrays.fill(count1, 0);
        Arrays.fill(count2, 0);

        for(int i=0;i<str1.length();i++){
             count1[(str1.charAt(i)-'a')]++;
             count2[(str2.charAt(i)-'a')]++;
        }
        boolean areArraysEqual= true;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                areArraysEqual = false;
                break;
            }
        }
        return areArraysEqual;
}
    public static void main(String[] args) {
        //taking input
        Scanner sc = new Scanner(System.in);
        ArrayList<String> stringArray = new ArrayList<>();
        System.out.println("Enter the size of stringArray:");
        int n= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the strings of string array:");
        for(int i=0;i<n;i++){
            stringArray.add(sc.nextLine());
        }
        
        //resultant 2d array
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        //taking each string from the input array and checkking if anagrams of that string is present or not 
        //keep adding anagrams to temp array
        //push temp array to result array
        for(int i=0;i<stringArray.size();i++){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(stringArray.get(i));
            for(int j=0;j<stringArray.size();j++){
                if(j!=i){
                    //check for anagram
                    if(Anagrams(stringArray.get(i),stringArray.get(j))){
                        temp.add(stringArray.get(j));
                    }
                }
            }
            Collections.sort(temp);
            if(!res.contains(temp))
            res.add(new ArrayList<>(temp));
        }

        //printing resultant array
        System.out.println(res);
        sc.close();
    }
}