import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        // photo의 크기만큼 answer 크기 지정
        answer = new int[photo.length];

        // 사진 속에 나오는 인물의 '그리움 점수를 모두 합산'한 값이 해당 사진의 "추억점수"가 된다.
        // name: 그리워하는 사람의 이름 배열
        // yearing: 각 사람별 그리움 점수를 담은 배열
        // photo: 각 사진에 찍힌 인물의 이름을 담은 배열
        // => 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return

        // yearningMap: key로 이름, value로 해당 이름의 그리움점수 저장하기
        HashMap<String, Integer> yearningMap = new HashMap<>();


        for(int i=0; i<name.length; i++) {
            // yearningMap key(이름), value(그리움점수) 담기
            yearningMap.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++) {
            // nameCntMap: key로 이름, value로 해당 이름이 몇 번 존재하는지 저장
            HashMap<String, Integer> nameCntMap = new HashMap<>();
            // 최종 합산 값 저장
            int sum = 0;
            for(int j=0; j<photo[i].length; j++) {
                // nameCntMap에 photo[i][j]의 이름이 존재하면 value값을 하나 증가해주고, 없으면 생성해준 후 value값 하나 증가한다.
                nameCntMap.put(photo[i][j], nameCntMap.getOrDefault(photo[i][j], 0) +1);
            }
            // name 배열에 존재하는 cnt값과 그리움점수를 합산하여 sum에 저장하고 answer에 저장
            for(int j=0; j<name.length; j++) {
                if(nameCntMap.get(name[j]) != null) {
                    sum += nameCntMap.get(name[j]) * yearningMap.get(name[j]);
                }
            }
            answer[i] = sum;
        }

        // yearningMap의 그리움 점수와 nameCntMap의 점수를 key의 이름과 매칭하여 합산하고, 최종 값을 출력
        return answer;
    }
}