import com.wt.mapper.StudentMapper;
import com.wt.mapper.TeacherMapper;
import com.wt.pojo.Student;
import com.wt.pojo.Teacher;
import com.wt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test00(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = studentMapper.getAllStudents();

        for(Student student:students){
            System.out.println(student.getId());
        }
        sqlSession.close();
    }

    @org.junit.Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Student> students = teacherMapper.getStudentsOfTeacherByTeacherId();
        for(Student student:students){
            System.out.println(student.getName());
        }
        sqlSession.close();
    }

    @org.junit.Test
    public void test02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherAndHerStudents(1);
        for(Student student:teacher.getStudents()){
            System.out.print(student.getId());
            System.out.print(student.getName());
            System.out.println(teacher.getName());
            System.out.println("--------------------------------");
        }
        sqlSession.close();
    }
}
