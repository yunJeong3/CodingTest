class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        // my_string의 인덱스 s ~ overwrite_string의 길이
        // 만큼을 문자열 overwrite_string으로 바꾼 문자열을 return
        // => my_string을 처음부터 출력하다가 s번째가 되면 overwrite_string의 문자로 출력하고
        // overwrite_string문자를 다 출력하고 나면 남은 문자열만큼 my_string 출력
        String answer = "";
        int len = my_string.length();
        int target = overwrite_string.length();
        int count = 0;
        
        for(int i=0; i<len; i++) {
            if(i >= s && count < target) {
                answer += overwrite_string.charAt(count++);
            } else answer += my_string.charAt(i);
        }
        
        return answer;
    }
}