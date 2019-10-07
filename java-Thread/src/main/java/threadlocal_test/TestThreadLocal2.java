package threadlocal_test;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/9/28 15:49
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestThreadLocal2 {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConnection(){
        Connection connection = threadLocal.get();
        if (null == connection) {
            connection = Datasource.get();
            threadLocal.set(connection);
        }
        return connection;
    }


    public static void remove(){
        threadLocal.remove();
    }



    public static void main(String[] args) throws InterruptedException {

        Executor executors = Executors.newFixedThreadPool(10);
        executors.execute(()->{
            System.out.println(getConnection());
        });
        executors.execute(()->{
            System.out.println(getConnection());
        });

        System.out.println(getConnection());
    }

    private static class Connection{
        String name;
        public Connection(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Connection{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private static class Datasource{
        static ArrayBlockingQueue<Connection> connections = new ArrayBlockingQueue<Connection>(5);

        static {
            connections.offer(new Connection("1"));
            connections.offer(new Connection("2"));
            connections.offer(new Connection("3"));
            connections.offer(new Connection("4"));
            connections.offer(new Connection("5"));
        }

        static Connection get(){
            Connection connection =null;
            try {
                // 移除并返回头部元素 阻塞操作
                connection = connections.take();
                // 把移除的元素再添加回去 比如 一开始是 1 2 3 4 5 现在 take一个变成了 2 3 4 5 _ 然后put变成了 2 3 4  5 1 .
                connections.put(connection);
            } catch (InterruptedException e) {
                System.out.println("线程阻塞");
            }
            return connection;
        }
    }




/*    public void test() throws InterruptedException {
        LinkedBlockingQueue<Connection> connections = new LinkedBlockingQueue<Connection>(5);
        connections.offer(new Connection("1"));
        connections.offer(new Connection("2"));
        connections.offer(new Connection("3"));
        connections.offer(new Connection("4"));
        connections.offer(new Connection("5"));

        ArrayBlockingQueue<Connection> connections1 = new ArrayBlockingQueue<>(5);
        connections1.offer(new Connection("1"));
        connections1.offer(new Connection("2"));
        connections1.offer(new Connection("3"));
        connections1.offer(new Connection("4"));
        connections1.offer(new Connection("5"));


        long start1 = System.currentTimeMillis();
        for (int x = 0; x < 1000000; x++) {
            Connection connection = connections.take();
            connections.put(connection);
        }
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        for (int x = 0; x < 1000000; x++) {
            Connection connection = connections1.take();
            connections1.put(connection);
        }
        System.out.println(System.currentTimeMillis() - start2);

        ConcurrentLinkedQueue<Connection> connections2 = new ConcurrentLinkedQueue<Connection>();
        connections2.offer(new Connection("1"));
        connections2.offer(new Connection("2"));
        connections2.offer(new Connection("3"));
        connections2.offer(new Connection("4"));
        connections2.offer(new Connection("5"));

        long start3 = System.currentTimeMillis();
        for (int x = 0; x < 1000000; x++) {
            Connection connection = connections2.poll();
            connections2.add(connection);
        }

        System.out.println(connections2.size());
        System.out.println(System.currentTimeMillis() - start3);
    }*/
}
