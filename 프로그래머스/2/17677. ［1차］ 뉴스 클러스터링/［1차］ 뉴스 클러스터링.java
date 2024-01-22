import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> strMultiset1 = getSubStr(str1.toUpperCase());
        List<String> strMultiset2 = getSubStr(str2.toUpperCase());
    
        List<String> unionSet = new ArrayList<>();
        List<String> intersectionSet = new ArrayList<>();
        
        for(String s1 : strMultiset1){
            // strMultiset2에 원소 s1가 있을 경우 합집합에 추가
            if(strMultiset2.contains(s1)){
                unionSet.add(s1);
                // strMultiset2에 있는 원소 s1은 삭제
                strMultiset2.remove(s1);
            }
            // 탐색한 strMultiset1의 원소를 교집합에 추가
            intersectionSet.add(s1);
        }
        
        // strMultiset2에서 교집합을 모두 삭제했으므로, 남은 원소들을 합집합에 추가
        intersectionSet.addAll(strMultiset2);
        
        // 공집합일 경우
        if(intersectionSet.size() == 0){
            return 65536;
        }
        double jac = (double)unionSet.size() / intersectionSet.size();
        
        jac = Math.floor(jac*65536);
        
        return (int)jac;
    }
    
    static List<String> getSubStr(String str) {
         // A ~ Z
        List<String> list = new ArrayList<>();
        for(int i = 0; i<str.length() - 1; i++) {
        	char c1 = str.charAt(i);
        	char c2 = str.charAt(i+1);
        	
        	if((int)c1 < 65 || (int)c1 > 90) continue;
        	if((int)c2 < 65 || (int)c2 > 90) continue;
        	String s = str.substring(i,i+2);
        	list.add(s);
        }
        
        return list;
    }
}