import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
         HashMap<String, Integer> termList = new HashMap<>();

            int calToday = calDate(today);

            for(String term : terms){
                String[] termArr = term.split(" ");
                termList.put(termArr[0], Integer.parseInt(termArr[1]));

            }

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i<privacies.length; i++){
                int exp = termList.get(privacies[i].split(" ")[1]);
                int expDate = exp*28;
                int priDate = calDate(privacies[i].split(" ")[0]);
                if(expDate + priDate <= calToday){
                    list.add(i+1);
                }
            }

            return list.stream().mapToInt(i -> i).toArray();
        }

        private int calDate(String str){
            String date = str.replace(".", "");
            System.out.println(date);
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));

            return year*12*28 + month*28 + day;
        }
}