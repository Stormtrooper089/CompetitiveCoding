import java.util.HashMap;
import java.util.LinkedHashMap;

public class NonRepeatingCharacter {
    public static void main(String []  args){
        String question = "hello";
        HashMap<Character,Integer> store = new LinkedHashMap<>();
        for(int i =0 ; i < question.length() ; i++){
            char charName = question.charAt(i);
            if( store .containsKey(charName)){
                int intialCount = store.get(charName);
                intialCount+=1;
                store.put(charName,intialCount);
            }else{
                store.put(charName,1);
            }
        }
        for (Character c:
             store.keySet()) {
            if(store.get(c) == 1){
                System.out.println("the first non repeating character is  " + c);
                break;
            }
        }
    }
}
