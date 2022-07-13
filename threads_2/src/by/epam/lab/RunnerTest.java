package by.epam.lab;

import by.epam.lab.bean.User;
import by.epam.lab.service.UserService;
import by.epam.lab.service.impl.ListImpl;
import by.epam.lab.service.impl.MapImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;

import static by.epam.lab.utils.Constants.*;

import static org.junit.Assert.*;

public class RunnerTest {

//    List<User> usersList = new CopyOnWriteArrayList<>();
//    UserService userService = new ListImpl(usersList);

    // comment above two rows and uncomment below two rows to change List implementation to Map

    Map<Integer, String> usersList = new ConcurrentHashMap<>();
    UserService userService = new MapImpl(usersList);

    @Test
    public void registerTwoDifferentUsersInEmptyContainer() {
        userService.setStartingIdAsZero();

        String[] usersSource = {
                "Vlad",
                "Hleb"
        };

        CountDownLatch latch = new CountDownLatch(usersSource.length);

        Arrays.stream(usersSource)
                .forEach(u -> new Thread(() -> {
                    userService.register(u);
                    sleep();
                    latch.countDown();
                }).start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(INTERRUPTED_EXCEPTION + e.getMessage());
        }

        final int EXPECTED_USERS_NUM = 2;
        assertEquals(EXPECTED_USERS_NUM, usersList.size());
    }

    @Test
    public void registerTwoDifferentUsersInNotEmptyContainer() {
        usersList.clear();
        userService.setStartingIdAsZero();
        userService.register("Kate");
        userService.register("Denis");
        String[] usersSource = {
                "Vlad",
                "Hleb"
        };

        CountDownLatch latch = new CountDownLatch(usersSource.length);

        Arrays.stream(usersSource)
                .forEach(u -> new Thread(() -> {
                    userService.register(u);
                    sleep();
                    latch.countDown();
                }).start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(INTERRUPTED_EXCEPTION + e.getMessage());
        }

        final int EXPECTED_USERS_NUM = 4;
        assertEquals(EXPECTED_USERS_NUM, usersList.size());
    }

    @Test
    public void registerTwoSameUsersInNotEmptyContainer() {
        usersList.clear();
        userService.setStartingIdAsZero();
        userService.register("Kate");
        userService.register("Denis");
        String[] usersSource = {
                "Vlad",
                "Vlad"
        };

        CountDownLatch latch = new CountDownLatch(usersSource.length);

        Arrays.stream(usersSource)
                .forEach(u -> new Thread(() -> {
                    userService.register(u);
                    sleep();
                    latch.countDown();
                }).start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(INTERRUPTED_EXCEPTION + e.getMessage());
        }

        final int EXPECTED_USERS_NUM = 3;
        assertEquals(EXPECTED_USERS_NUM, usersList.size());
    }

    @Test
    public void registerTwoSameUsersInEmptyContainer() {
        usersList.clear();
        userService.setStartingIdAsZero();
        String[] usersSource = {
                "Vlad",
                "Vlad"
        };

        CountDownLatch latch = new CountDownLatch(usersSource.length);

        Arrays.stream(usersSource)
                .forEach(u -> new Thread(() -> {
                    userService.register(u);
                    sleep();
                    latch.countDown();
                }).start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(INTERRUPTED_EXCEPTION + e.getMessage());
        }

        final int EXPECTED_USERS_NUM = 1;
        assertEquals(EXPECTED_USERS_NUM, usersList.size());
    }

    @Test
    public void registerTenDifferentUsersInEmptyContainer() {
        System.out.println(REGISTER_TEN_DIFF_USERS);
        usersList.clear();
        userService.setStartingIdAsZero();
        String[] usersSource = {
                "Vlad",
                "Hleb",
                "Valera",
                "Kirill",
                "Dasha",
                "Pavel",
                "Ira",
                "Vika",
                "Natasha",
                "Sergey"
        };

        CountDownLatch latch = new CountDownLatch(usersSource.length);

        Arrays.stream(usersSource)
                .forEach(u -> new Thread(() -> {
                    userService.register(u);
                    Optional<User> user = randomGetUserById();
                    user.ifPresent(System.out::println);
                    latch.countDown();
                }).start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(INTERRUPTED_EXCEPTION + e.getMessage());
        }

        final int EXPECTED_USERS_NUM = 10;
        assertEquals(EXPECTED_USERS_NUM, usersList.size());
    }

    @Test
    public void registerTenSimilarUsersInEmptyContainer() {
        System.out.println(REGISTER_TEN_SIMILAR_USERS);
        usersList.clear();
        userService.setStartingIdAsZero();
        String[] usersSource = {
                "Vlad",
                "Vlad",
                "Vlad",
                "Vlad",
                "Vlad",
                "Vlad",
                "Vlad",
                "Vlad",
                "Vlad",
                "Vlad"
        };

        CountDownLatch latch = new CountDownLatch(usersSource.length);

        Arrays.stream(usersSource)
                .forEach(u -> new Thread(() -> {
                    userService.register(u);
                    Optional<User> user = randomGetUserById();
                    user.ifPresent(System.out::println);
                    latch.countDown();
                }).start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(INTERRUPTED_EXCEPTION + e.getMessage());
        }

        final int EXPECTED_USERS_NUM = 1;
        assertEquals(EXPECTED_USERS_NUM, usersList.size());
    }

    @Test
    public void registerFiveUniqueUsersInEmptyContainer() {
        System.out.println(REGISTER_FIVE_UNIQUE_USERS);
        usersList.clear();
        userService.setStartingIdAsZero();
        String[] usersSource = {
                "Vlad",
                "Hleb",
                "Vlad",
                "Vlad",
                "Vlad",
                "Pavel",
                "Ira",
                "Vika",
                "Vlad",
                "Vlad"
        };

        CountDownLatch latch = new CountDownLatch(usersSource.length);

        Arrays.stream(usersSource)
                .forEach(u -> new Thread(() -> {
                    userService.register(u);
                    Optional<User> user = randomGetUserById();
                    user.ifPresent(System.out::println);
                    latch.countDown();
                }).start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(INTERRUPTED_EXCEPTION + e.getMessage());
        }

        final int EXPECTED_USERS_NUM = 5;
        assertEquals(EXPECTED_USERS_NUM, usersList.size());
    }

    private void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ignored) {
            //the thread shouldn't be interrupted
            System.err.println(THREAD_SLEEP_EXCEPTION);
        }
    }

    private Optional<User> randomGetUserById() {
        final int MIN_ID = 0;
        final int MAX_ID = 9;
        return userService.getUser(ThreadLocalRandom.current().nextInt(MIN_ID, MAX_ID));
    }
}