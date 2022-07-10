package by.epam.lab;

import by.epam.lab.bean.User;
import by.epam.lab.service.Command;
import by.epam.lab.service.impl.ListImpl;
import by.epam.lab.service.impl.MapImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.Assert.*;

public class TestMapImplRunner {

    @Test
    public void testRegisterTwoUserInEmptyListWithSleepingAfterReg() {
        //prepare data (Given)
        ListImpl.id = 0;
        User[] usersSource = {new User("Vlad"), new User("Hleb")};
        CountDownLatch countDownLatch = new CountDownLatch(usersSource.length);
        Map<Integer, String> resultUserMap = new HashMap<>();
        Command command = new MapImpl(resultUserMap, countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(usersSource.length);

        //getting results (When)
        List<Future<Optional<User>>> futureUsersList = new ArrayList<>();
        for (User currentUser : usersSource) {
            Future<Optional<User>> futureUser = executorService.submit(() -> command.register(currentUser));
            futureUsersList.add(futureUser);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();

        //checking results (Then)
        for (Future<Optional<User>> currentUser : futureUsersList) {
            try {
                Optional<User> user = currentUser.get();
                Assert.assertTrue(user.isPresent());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
            }
        }

        // creating new expected and result lists with Account fields and compare.
        assertTrue(resultUserMap.values()
                .stream()
                .toList()
                .containsAll(Arrays.stream(usersSource)
                        .map(User::getAccount)
                        .toList()));
        assertEquals(2, resultUserMap.size());
    }

    @Test
    public void testRegisterTwoUserInEmptyListWithSleepingBeforeReg() {
        //prepare data (Given)
        ListImpl.id = 0;
        User[] usersSource = {new User("Vlad"), new User("Hleb")};
        CountDownLatch countDownLatch = new CountDownLatch(usersSource.length);
        Map<Integer, String> resultUserMap = new HashMap();
        Command command = new MapImpl(resultUserMap, countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(usersSource.length);

        //getting results (When)
        List<Future<Optional<User>>> futureUsersList = new ArrayList<>();
        for (User currentUser : usersSource) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Future<Optional<User>> futureUser = executorService.submit(() -> command.register(currentUser));
            futureUsersList.add(futureUser);
        }

        executorService.shutdown();

        //checking results (Then)
        for (Future<Optional<User>> currentUser : futureUsersList) {
            try {
                Optional<User> user = currentUser.get();
                Assert.assertTrue(user.isPresent());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
            }
        }

        assertTrue(resultUserMap.values()
                .stream()
                .toList()
                .containsAll(Arrays.stream(usersSource)
                        .map(User::getAccount)
                        .toList()));
        assertEquals(2, resultUserMap.size());
    }


    @Test
    public void testRegisterTwoUserInNotEmptyListWithSleepingAfterReg() {
        //prepare data (Given)
        ListImpl.id = 0;
        User[] usersSource = {new User("Vlad"), new User("Hleb")};
        CountDownLatch countDownLatch = new CountDownLatch(usersSource.length);
        Map<Integer, String> resultUserMap = new HashMap<>();
        resultUserMap.put(0, "Gena");
        resultUserMap.put(1, "Ilya");
        Command command = new MapImpl(resultUserMap, countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(usersSource.length);

        //getting results (When)
        List<Future<Optional<User>>> futureUsersList = new ArrayList<>();
        for (User currentUser : usersSource) {
            Future<Optional<User>> futureUser = executorService.submit(() -> command.register(currentUser));
            futureUsersList.add(futureUser);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();

        //checking results (Then)
        for (Future<Optional<User>> currentUser : futureUsersList) {
            try {
                Optional<User> user = currentUser.get();
                Assert.assertTrue(user.isPresent());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
            }
        }

        assertTrue(resultUserMap.values()
                .stream()
                .toList()
                .containsAll(Arrays.stream(usersSource)
                        .map(User::getAccount)
                        .toList()));
        assertEquals(4, resultUserMap.size());
    }

    @Test
    public void testRegisterTwoUserInNotEmptyListWithSleepingBeforeReg() {
        //prepare data (Given)
        ListImpl.id = 0;
        User[] usersSource = {new User("Vlad"), new User("Hleb")};
        CountDownLatch countDownLatch = new CountDownLatch(usersSource.length);
        Map<Integer, String> resultUserMap = new HashMap<>();
        resultUserMap.put(0, "Gena");
        resultUserMap.put(1, "Ilya");
        Command command = new MapImpl(resultUserMap, countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(usersSource.length);

        //getting results (When)
        List<Future<Optional<User>>> futureUsersList = new ArrayList<>();
        for (User currentUser : usersSource) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Future<Optional<User>> futureUser = executorService.submit(() -> command.register(currentUser));
            futureUsersList.add(futureUser);
        }

        executorService.shutdown();

        //checking results (Then)
        for (Future<Optional<User>> currentUser : futureUsersList) {
            try {
                Optional<User> user = currentUser.get();
                Assert.assertTrue(user.isPresent());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
            }
        }

        assertTrue(resultUserMap.values()
                .stream()
                .toList()
                .containsAll(Arrays.stream(usersSource)
                        .map(User::getAccount)
                        .toList()));
        assertEquals(4, resultUserMap.size());
    }

    @Test
    public void testRegisterTenDifferentUsersInEmptyList() {
        //prepare data (Given)
        ListImpl.id = 0;
        User[] usersSource = {
                new User("Vlad"),
                new User("Hleb"),
                new User("Valera"),
                new User("Kirill"),
                new User("Dasha"),
                new User("Pavel"),
                new User("Ira"),
                new User("Vika"),
                new User("Natasha"),
                new User("Sergey")};
        CountDownLatch countDownLatch = new CountDownLatch(usersSource.length);
        Map<Integer, String> resultUserMap = new HashMap<>();
        Command command = new MapImpl(resultUserMap, countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(usersSource.length);

        //getting results (When)
        List<Future<Optional<User>>> futureUsersList = new ArrayList<>();
        for (User currentUser : usersSource) {
            Future<Optional<User>> futureUser = executorService.submit(() -> command.register(currentUser));
            futureUsersList.add(futureUser);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        Future<Optional<User>> presentUser = executorService.submit(() -> command.getUser(1));
        Future<Optional<User>> notPresentUser = executorService.submit(() -> command.getUser(12));

        executorService.shutdown();

        //checking results (Then)
        for (Future<Optional<User>> currentUser : futureUsersList) {
            try {
                Optional<User> user = currentUser.get();
                Assert.assertTrue(user.isPresent());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
            }
        }

        try {
            Optional<User> user1 = presentUser.get();
            Optional<User> user2 = notPresentUser.get();
            Assert.assertTrue(user1.isPresent());
            Assert.assertTrue(user2.isEmpty());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        } catch (ExecutionException e) {
            System.err.println(e.getMessage());
        }

        List<String> resultAccounts = resultUserMap
                .values()
                .stream()
                .toList();
        List<String> expectedAccounts = Arrays
                .stream(usersSource)
                .map(User::getAccount)
                .toList();

        Assert.assertTrue(expectedAccounts.containsAll(resultAccounts));
        assertEquals(usersSource.length, resultUserMap.size());
    }

    @Test
    public void testRegisterTenSameUsersInEmptyMap() {
        //prepare data (Given)
        ListImpl.id = 0;
        User[] usersSource = {
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad")};
        CountDownLatch countDownLatch = new CountDownLatch(usersSource.length);
        Map<Integer, String> resultUserMap = new HashMap<>();
        Command command = new MapImpl(resultUserMap, countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(usersSource.length);

        //getting results (When)
        List<Future<Optional<User>>> futureUsersList = new ArrayList<>();
        for (User currentUser : usersSource) {
            Future<Optional<User>> futureUser = executorService.submit(() -> command.register(currentUser));
            futureUsersList.add(futureUser);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        Future<Optional<User>> presentUser = executorService.submit(() -> command.getUser(0));
        Future<Optional<User>> notPresentUser = executorService.submit(() -> command.getUser(12));

        executorService.shutdown();

        //checking results (Then)
        int present = 0;
        int notPresent = 0;
        for (Future<Optional<User>> currentUser : futureUsersList) {
            try {
                Optional<User> user = currentUser.get();
                if (user.isPresent()) {
                    present++;
                } else {
                    notPresent++;
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
            }
        }
        Assert.assertEquals(1, present);
        Assert.assertEquals(9, notPresent);

        try {
            Optional<User> user1 = presentUser.get();
            Optional<User> user2 = notPresentUser.get();
            Assert.assertTrue(user1.isPresent());
            Assert.assertTrue(user2.isEmpty());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        } catch (ExecutionException e) {
            System.err.println(e.getMessage());
        }

        assertTrue(resultUserMap.values()
                .stream()
                .toList()
                .containsAll(Arrays.stream(usersSource)
                        .map(User::getAccount)
                        .toList()));
        assertEquals(1, resultUserMap.size());
    }

    @Test
    public void testRegisterFiveUniqueUsersInEmptyMap() {
        //prepare data (Given)
        ListImpl.id = 0;
        User[] usersSource = {
                new User("Vlad"),
                new User("Hleb"),
                new User("Valera"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Pavel"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Vlad"),
                new User("Sergey")};
        CountDownLatch countDownLatch = new CountDownLatch(usersSource.length);
        Map<Integer, String> resultUserMap = new HashMap<>();
        Command command = new MapImpl(resultUserMap, countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(usersSource.length);

        //getting results (When)
        List<Future<Optional<User>>> futureUsersList = new ArrayList<>();
        for (User currentUser : usersSource) {
            Future<Optional<User>> futureUser = executorService.submit(() -> command.register(currentUser));
            futureUsersList.add(futureUser);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        Future<Optional<User>> presentUser = executorService.submit(() -> command.getUser(1));
        Future<Optional<User>> notPresentUser = executorService.submit(() -> command.getUser(12));

        executorService.shutdown();

        //checking results (Then)
        int present = 0;
        int notPresent = 0;
        for (Future<Optional<User>> currentUser : futureUsersList) {
            try {
                Optional<User> user = currentUser.get();
                if (user.isPresent()) {
                    present++;
                } else {
                    notPresent++;
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
            }
        }

        futureUsersList.forEach(System.out::println);
        Assert.assertEquals(5, present);
        Assert.assertEquals(5, notPresent);

        try {
            Optional<User> user1 = presentUser.get();
            Optional<User> user2 = notPresentUser.get();
            Assert.assertTrue(user1.isPresent());
            Assert.assertTrue(user2.isEmpty());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        } catch (ExecutionException e) {
            System.err.println(e.getMessage());
        }

        List<String> resultAccounts = resultUserMap
                .values()
                .stream()
                .toList();
        List<String> expectedAccounts = Arrays
                .stream(usersSource)
                .map(User::getAccount)
                .toList();

        resultAccounts.forEach(System.out::println);

        Assert.assertTrue(expectedAccounts.containsAll(resultAccounts));
        assertEquals(5, resultUserMap.size());
    }

}