package 완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

//p에는 있고, c에는 없는 값을 찾아서 던져주면 된다.
//조건 1 : 없는 사람은 단 1명이다 (현재 조건은 그러함)
//조건 2 : p에는 중복이 들어올 수 있다. (따라서 set처럼 중복을 없애는 값들은 고려를 해봐야 한다.)

public class Solution {
    public String solution(String[] participants, String[] completers) {
        Map<String, Integer> pMap = new HashMap();

        //1. 배열 -> 맵 변환 (기본 값 1로 초기화, 동명이인은 2이상)
        for (String key : participants) {
            pMap.put(key, pMap.getOrDefault(key, 0) + 1);
        }

        //2. 완주자는 뺀다 (값이 1인 경우 삭제)
        for (String key : completers) {
            if (pMap.get(key) == 1) {
                pMap.remove(key);
            } else { //동명이인 일 경우 현재 값에서 -1
                pMap.replace(key, pMap.get(key) - 1);
            }
        }

        //3. 완주하지 못한 사람 색출 - 남은 값 하나 뽑으면 됨
        return (String) pMap.keySet().toArray()[0];
    }
}
