import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class main {




    public static void main(String[] args) {


        List<Course> course = new ArrayList<>(Arrays.asList(
                new CourseMap("Java"),
                new CourseMap("Web"),
                new CourseMap("Modeling")
        ));

        List<Student> student = new ArrayList<>(Arrays.asList(
                new StudentStruct("Петя", (ArrayList) course),
                new StudentStruct("Вася",(ArrayList) course),
                new StudentStruct("Маша", (ArrayList) course)
        ));

        Stream<Student> stream = student.stream();


        System.out.println(w(stream));


    }


    static Stream<Student> w (Stream<Student> stream){
        return  stream.filter(x->x.getAllCourses().size()>1)
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Student::getName)
                .distinct();

    }


}
