public class Palindrome {

    public static Deque<Character> wordToDeque(String word){
        Deque<Character> res = new LinkedListDeque<>();
        for(char c : word.toCharArray()){
            res.addLast(c);
        }
        return res;
    }

    public static boolean isPalindrome(String word) {
        char[] ch = word.toCharArray();
        boolean res = true;
        for (int i = 0; i < ch.length / 2; i++) {
            if (ch[i] != ch[ch.length - 1 - i] && Math.abs(ch[i] - ch[ch.length - 1 - i]) != Math.abs('A' - 'a')) {
                res = false;
                break;
            }
        }
        return res;
    }
        public boolean isPalindrome(String word, CharacterComparator cc) {
        int l = word.length();
        boolean res = true;
            for (int i =0;i<l/2;i++){
                if (!cc.equalChars(word.charAt(i),word.charAt(l-1-i))){
                    res = false;
                }
            }
            return res;
        }


    }
