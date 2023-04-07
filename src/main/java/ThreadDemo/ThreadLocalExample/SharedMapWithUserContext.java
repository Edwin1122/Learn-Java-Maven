package ThreadDemo.ThreadLocalExample;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable {

    //define class-level(static) shared map 'userContextPerUserId'
    //which can be accessed by 'SharedMapWithUserContext.userContextPerUserId'
    final static Map<Integer, Context> userContextPerUserId = new ConcurrentHashMap<>();

    private final Integer userId;
    private final UserRepository userRepository = new UserRepository();

    SharedMapWithUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {

        String userName = userRepository.getUserNameForUserId(userId);

        //manipulate the class-level map 'userContextPerUserId' with context generated in current thread
        userContextPerUserId.put(userId, new Context(userName));

        System.out.println("generated userName " + userName);
    }
}
