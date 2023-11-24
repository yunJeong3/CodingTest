class Solution {
    public int[] solution(String[] wallpaper) {
int[] answer = new int[4];
        // wallpaper를 돌면서 x,y 각각의 최소/최대 위치를 구한다.
        // x) 최소1 최대3 / y) 최소0, 최대2 ==> 최대를 구할 땐 (최대+1)을 해준다. [0,1,3,4]
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                // 파일 위치 찾기
                if(wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(i, minX);
                    minY = Math.min(j, minY);
                    maxX = Math.max(i+1, maxX);
                    maxY = Math.max(j+1, maxY);
                }
            }
        }

        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;
        return answer;
    }
}