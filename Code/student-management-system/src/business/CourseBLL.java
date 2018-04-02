package business;

import business.interfaces.CourseBLLInterface;
import dao.CourseDAO;
import entity.Course;

public class CourseBLL implements CourseBLLInterface {
    CourseDAO courseDAO = new CourseDAO();

    @Override
    public Course findById(int id) {
        return courseDAO.findById(id);
    }
}
