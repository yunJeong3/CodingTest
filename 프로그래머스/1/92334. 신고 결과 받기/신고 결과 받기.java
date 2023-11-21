import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int size = id_list.length;
        // 결과값(신고메일 보낼횟수) 담기
        int[] answer = new int[size];

        // map에 id와 index를 담는다.
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<size; i++) {
            indexMap.put(id_list[i], i);
        }
        // 신고당한사람 : 신고자들 의 인덱스를 담아준다.
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        // id_list를 map에 담기
        for(int i=0; i<size; i++) {
            map.put(i, new HashSet<>());
        }

        // report 를 돌면서 신고당한 사람과 신고자들을 담기
        for(String str : report) {
            String[] arr = str.split(" ");
            // arr[0] : 신고한사람 , arr[1] : 신고당한사람

            // indexMap에 존재하는 신고한 사람과, 신고당한 사람의 인덱스를 찾아서 기존 index에 있는 set을 다시 가져와 담는다.
            int reporterIdx = indexMap.get(arr[0]);
            int reportedIdx = indexMap.get(arr[1]);
            // 해당 set에 index를 add하고 다시 map에 put 한다.
            Set<Integer> set = map.get(reportedIdx);
            set.add(reporterIdx);
            // 신고당한 사람(key)를 통해 신고자들의 목록을 갱신하여 담아 map에 다시 넣어준다.
            map.put(reportedIdx, set);
        }

        for(int i=0; i<size; i++) {
            // map에 있는 각각의(i 인덱스의) set을 확인하여 size >= k 일 때에 set을 확인하여 answer에 각각의 인덱스에 카운트+1
            if(map.get(i).size() >= k) {
                Set<Integer> set = map.get(i);
                for(int idx : set) {
//                    System.out.println(i + " : " + idx);
                    answer[idx]+=1;
                }
            }
        }
        return answer;
    }
}