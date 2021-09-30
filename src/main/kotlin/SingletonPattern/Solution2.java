package SingletonPattern;

/**
 * 참고 : https://gampol.tistory.com/entry/Double-checked-locking과-Singleton-패턴
 *
 * 멀티 스레드 환경에서 제대로 동작하기는 하지만 모든 getInstance()메소드 호출에 동기화에대한 비용이 따르게 됨.
 *
 * 여기서 동기화가 필요한 부분은 메소드 내에서 if문과 인스턴스를 생성하는 부분에서만 동기화가 필요함
 * -> 인스턴스가 이미 있을경우에는 그대로 리턴하기만 하면 되므로 스레드에 동기화를 할 필요가 없음
 *
 */
public class Solution2 {
    private static Solution2 instance;

    private Solution2() { }

    public static synchronized Solution2 getInstance() {
        if (instance == null) {
            instance = new Solution2();
        }
        return instance;
    }
}
