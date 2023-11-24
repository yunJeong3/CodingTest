import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 최종적으로 점수를 확인할 check 배열
        String[] check = {"RT", "CF", "JM", "AN"};
        // 각 유형별 점수를 담을 hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<check.length; i++){
            // map에 유형을 각각 담아준다.
            map.put(check[i].charAt(0), 0);
            map.put(check[i].charAt(1), 0);
        }

        // 1 2 3 4 5 6 7
        // 3 2 1 0 1 2 3 => 3 이하면 왼쪽에 점수 추가, 5이상이면 오른쪽에 점수 추가
        for(int i=0; i<survey.length; i++) {
            // 1 2 3 (3이하) 면 앞 유형에 담기
            // 각각 3점 2점 1점
            if(choices[i] <= 3) {
                // map에 점수 담기
                // 4 -1 = +3
                // 4 -2 = +2
                // 4 -3 = +1
                int keyScore = map.get(survey[i].charAt(0));
                map.put(survey[i].charAt(0), keyScore + (4 -choices[i]));
            // 5 이상이면 뒷 유형에 담기
            } else if(choices[i] >= 5) {
                // 5 6 7
                // 각각 1 2 3
                // 5 -4 = +1
                // 6 -4 = +2
                // 7 -4 = +3
                int keyScore = map.get(survey[i].charAt(1));
                map.put(survey[i].charAt(1), keyScore + (choices[i] -4));
            }
        }

        // survey를 다 돈 후에 체크 배열에서 둘 다 0이거나 같은 점수면 앞 문자를 담기
        // String[] check = {"RT", "CF", "JM", "AN"};
        for(int i=0; i<check.length; i++) {
            int score = map.get(check[i].charAt(0));
            if(score < map.get(check[i].charAt(1))) answer += check[i].charAt(1);
            else answer += check[i].charAt(0);
        }
        return answer;
    }
}