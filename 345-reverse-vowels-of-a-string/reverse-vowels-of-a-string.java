class Solution {
    public String reverseVowels(String s) {
      StringBuilder vowels = new StringBuilder();

      for(int i = 0; i < s.length(); i++)  {
        char c = s.charAt(i);
        if(isVowel(c)){
            vowels.append(c);
        }
      }
      vowels.reverse();

      StringBuilder result = new StringBuilder();

      int j = 0;
      for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);

        if(isVowel(c)){
            result.append(vowels.charAt(j));
            j++;
        } else{
            result.append(c);
        }
      }
      return result.toString();
    }
    boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
              ||  c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}