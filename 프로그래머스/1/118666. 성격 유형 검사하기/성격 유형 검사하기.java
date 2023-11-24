import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        /* 최종 수정 후 소요시간 
        테스트 1 〉	통과 (1.83ms, 84.8MB)
        테스트 2 〉	통과 (2.42ms, 72.3MB)
        테스트 3 〉	통과 (1.73ms, 76.5MB)
        테스트 4 〉	통과 (2.93ms, 77.6MB)
        테스트 5 〉	통과 (2.11ms, 82.8MB)
        테스트 6 〉	통과 (2.22ms, 75.4MB)
        테스트 7 〉	통과 (2.02ms, 76MB)
        테스트 8 〉	통과 (2.03ms, 76.6MB)
        테스트 9 〉	통과 (2.29ms, 76.2MB)
        테스트 10 〉	통과 (2.74ms, 91.4MB)
        테스트 11 〉	통과 (1.89ms, 77.5MB)
        테스트 12 〉	통과 (1.74ms, 77.1MB)
        테스트 13 〉	통과 (2.39ms, 76.2MB)
        테스트 14 〉	통과 (2.66ms, 73.3MB)
        테스트 15 〉	통과 (2.00ms, 77.4MB)
        테스트 16 〉	통과 (2.20ms, 75.9MB)
        테스트 17 〉	통과 (2.80ms, 76.3MB)
        테스트 18 〉	통과 (2.23ms, 80.5MB)
        테스트 19 〉	통과 (2.94ms, 82.6MB)
        테스트 20 〉	통과 (2.67ms, 75.8MB)
        */
        String answer = "";
        // 최종적으로 점수를 확인할 checkMap
        HashMap<Integer, String> checkMap = new HashMap<>();
        checkMap.put(0, "RT");
        checkMap.put(1, "CF");
        checkMap.put(2, "JM");
        checkMap.put(3, "AN");
        // 각 유형별 점수를 담을 map
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<4; i++){
            // map에 유형을 각각 담아준다.
            map.put(checkMap.get(i).charAt(0), 0);
            map.put(checkMap.get(i).charAt(1), 0);
        }
        System.out.println(checkMap);
        System.out.println(map);

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

        System.out.println(map);
        // checkMap을 통해 점수 확인. ("RT", "CF", "JM", "AN")
        for(int i=0; i<4; i++) {
            Character checkStr1 = checkMap.get(i).charAt(0);
            Character checkStr2 = checkMap.get(i).charAt(1);
            int score = map.get(checkStr1);
            if(score < map.get(checkStr2)) answer += checkStr2;
            else answer += checkStr1;
        }
        return answer;
}
