package ThreadDemo.FutureTask;

import Other.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.*;

import static com.google.common.collect.Lists.asList;
import static org.junit.jupiter.api.Assertions.*;

class FutureTaskExampleTest {

    @Test
    void main() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("系统最大线程数  ： " + i);
    }

    @Test
    void test() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        List<Student> studentList = Stream.of(students, Arrays.asList(new Student("艾斯", 25, 183), new Student("雷利", 48, 176)))
                .flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(studentList);
    }


}