import com.wt.mapper.StudentMapper;
import com.wt.pojo.Student;
import com.wt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class Test {
    @org.junit.Test
    public void test00(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = studentMapper.getAllStudents01();
        for(Student student:students){
            System.out.print(student.getId());
            System.out.print(" ");
            System.out.println(student.getTeacher().getName());
        }
        System.out.println("--------------------------------");
        List<Student> students2 = studentMapper.getAllStudents02();
        for(Student student:students2){
            System.out.print(student.getId());
            System.out.print(" ");
            System.out.println(student.getTeacher().getName());
        }

        sqlSession.close();

    }
}
