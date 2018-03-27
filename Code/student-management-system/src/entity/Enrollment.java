package entity;

public class Enrollment {
    private int enrollmentId;
    private Student student;
    private Course course;
    private int period;

    public Enrollment() {
    }

    public Enrollment(int enrollmentId, Student student, Course course, int period) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.period = period;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrollment that = (Enrollment) o;

        if (enrollmentId != that.enrollmentId) return false;
        if (period != that.period) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        return course != null ? course.equals(that.course) : that.course == null;
    }

    @Override
    public int hashCode() {
        int result = enrollmentId;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + period;
        return result;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", student=" + student +
                ", course=" + course +
                ", period=" + period +
                '}';
    }
}
