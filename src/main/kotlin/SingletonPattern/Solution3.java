package SingletonPattern;

/**
 * 참고 : https://m.blog.naver.com/jjoommnn/130036635345
 *
 * double - checking 기법 (volatile 미사용)
 *
 * double checking 즉, instance가 null인지 synchronized구문 안에서도 체크해줘야한다.
 * 만약 instance를 생성하는 것만 동기화 처리한다면, 두개의 스레드가 instance가 null이면 동시적으로 if문 내에 접근하게 되고,
 * 인스턴스 초기화에만 하나의 스레드가 synchronized 블럭에 들어가고 다른 스레드는 block된다.
 * 그렇게 첫번째 스레드가 Singleton 객체를 만든 뒤, 두번째 스레드에서는 이미 인스턴스가 생성되었지만 Singleton 객체를 새로 만들게 되는 문제가 생긴다.
 *
 * -> 때문에 double checking이 필요하다.
 *
 * 1. Thread 1은 getInstance() 메소드로 들어간다.
 * 2. Thread 1은 instance가 null이기 때문에 synchronized 블록으로 들어간다.
 * 3. Thread 1은 thread 2에 선점된다.
 * 4. Thread 2는 getInstance() 메소드로 들어간다.
 * 5. Thread 2는 instance가 여전히 null이기 때문에 //1에서 lock 얻기를 시도한다. 하지만 thread 1이 lock을 보유하고 있기 때문에 thread 2는 블록된다.
 * 6. Thread 2는 thread 1에 선점된다.
 * 7. Thread 1은 실행하고 인스턴스가 여전히 null 이기 때문에, Singleton 객체를 만들고 이것의 레퍼런스를 instance에 할당한다.
 * 8. Thread 1은 synchronized 블록을 종료하고 getInstance() 메소드에서 인스턴스를 리턴한다.
 * 9. Thread 1은 thread 2에 선점된다.
 * 10. Thread 2는 lock을 얻어서 instance가 null인지를 점검한다.
 * 11. instance가 non-null이기 때문에, 두 번째 Singleton 객체는 만들어지지 않고 thread 1에 만들어진것이 리턴된다.
 *
 *
 * 하지만, cpu 메모리 아키텍쳐 때문에 문제가 발생한다.
 * 우리의 생각만으로는 cpu가 ram만 사용해 작동한다고 가정하지만, 실제로는 캐시메모리, 레지스터가 추가적으로 있음.
 * 특히 멀티 코어 환경에서 각각의 코어마다 전용 레스터와 캐시를 갖게 되는데, 이 때문에 ram과 각 코어간의 캐시가 제대로 동기화되지 않아 일관성 문제가 생길 수 있다.
 *
 * 만약, 하나의 스레드에서 instance를 생성해서 필드에 대입할때 코어의 레지스터에 대입하고, 캐시에 대입하는 과정을 거쳐야하는데,
 * 캐시나 램의 instance에 대입하는 과정에서 unlock된 이후에 이루어질 수도 아예 이루어지지 않을 수 있어서 문제가 생긴다.
 * 만약 램으로의 instance를 대입하는 과정이 늦어지게 되면 thread2에서도 instance가 null이게 되어 2개의 객체가 생성될 수 있다.
 *
 * -> 그래서 volatile키워드 사용 필요
 */
public class Solution3 {
    private static Solution3 instance;

    private Solution3() { }

    public static Solution3 getInstance() {
        if (instance == null) {
            synchronized (Solution3.class) {
                if (instance == null) {
                    instance = new Solution3();
                }
            }
        }
        return instance;
    }
}
