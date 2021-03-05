import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentStruct implements Student{

    private String Name;
    private ArrayList Course;

    public StudentStruct(String name, ArrayList course) {
      this.Name = name;
      this.Course = course;
    }

    @Override
    public String getName() { return  Name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.Course;
    }
}
