package SingletonPattern;

/**
 * 참고 : https://gampol.tistory.com/entry/Double-checked-locking과-Singleton-패턴
 *
 * 단일 스레드에 적합한 싱글턴 패턴
 *
 * 다중 스레드가 개입하게 되면 동기화되지 않아 해당 객체의 두개의 다른 인스턴스가 생성되어 리턴될 수 있음.
 *
 * 1. Thread 1은 getInstance() 메소드를 호출, instance가 null이라는 것을 결정한다.
 * 2. Thread 1은 if 블록 안으로 들어가지만, //2의 라인을 실행하기 전에 thread 2에 선점된다.
 * 3. Thread 2는 getInstance() 메소드를 호출하고 그 instance가 null 이라는 것을 결정한다.
 * 4. Thread 2는 if 블록으로 들어가서 새로운 Singleton 객체를 만들고 instance 변수에 새로운 객체에 할당한다.
 * 5. Thread 2는 생성한 Singleton 객체 레퍼런스를 리턴한다.
 * 6. Thread 2는 thread 1에 선점된다.
 * 7. Thread 1는 남겨진 곳에서 부터 시작하고 다른 Singleton 객체를 새로 만드는 라인을 실행한다.
 * 8. Thread 1은 또 다른 새롭게 만들어진 Singleton 객체를 리턴
 */
public class Solution1 {
    private static Solution1 instance;

    private Solution1() { }

    public static Solution1 getInstance() {
        if (instance == null) {
            instance = new Solution1();
        }
        return instance;
    }
}






