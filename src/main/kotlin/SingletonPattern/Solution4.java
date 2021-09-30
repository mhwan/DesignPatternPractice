package SingletonPattern;

/**
 * 참고 : https://m.blog.naver.com/jjoommnn/130036635345
 * double - checking (volatile키워드 사용)
 *
 * volatile키워드를 사용함으로써 코어마다 캐시 메모리를 사용하지 않게 해서 바로 ram에 인스턴스를 대입할 수 있게 됨.
 *
 * 하지만,
 * volatile 키워드는 java 1.4이상부터 사용가능하고,
 * 만약 싱글턴 객체 안에서 일반적인 필드를 선언할때 이 필드도 volatile키워드를 적용해야 제대로 동기화되고 초기화 될 수 있게 된다.
 *
 * 그래서, 새로운 방법들
 * 참고 : https://letyarch.blogspot.com/2019/04/singleton-synchronized_8.html
 *
 * 1. 스레드의 안정성을 위해 lazy한 초기화 방법이 아니라 early한 초기화 방법으로 문제를 해결할 수도 있음 (하지만, 이는 인스턴스를 단 한번도 생성하지 않을때에도 무조건 생성되게 되는 문제 발생)
 * 2. 중첩 클래스를 사용하는 방식 (lazy한 생성, synchronized 사용 불필요)
 * 3. class대신에 enum 클래스 사용.
 */
class Solution4 {
    private static volatile Solution4 instance;

    private Solution4() { }

    public static Solution4 getInstance() {
        if (instance == null) {
            synchronized (Solution3.class) {
                if (instance == null) {
                    instance = new Solution4();
                }
            }
        }
        return instance;
    }
}
