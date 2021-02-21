import com.wt.mapper.BlogMapper;
import com.wt.pojo.Blog;
import com.wt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.wt.utils.IDUtils.getID;

public class Test {
    @org.junit.Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.insertBlog(new Blog(getID(),"mybatis技术概要","王涛",new Date(),1530));
        blogMapper.insertBlog(new Blog(getID(),"spring技术概要","王涛",new Date(),3306));
        blogMapper.insertBlog(new Blog(getID(),"ssm项目实战","王涛",new Date(),443));
        blogMapper.insertBlog(new Blog(getID(),"springboot技术概要","王涛",new Date(),80));
        blogMapper.insertBlog(new Blog(getID(),"springboot项目实战","王涛",new Date(),8080));

        sqlSession.commit();
    }

    @org.junit.Test
    public void test00(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = blogMapper.getAllBlogs();

        for(Blog blog:blogs){
            System.out.println(blog.getId());
        }

    }

    @org.junit.Test
    public void testDynamicSQL(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        //先测试不传入参数的查询情况
        List<Blog> blogs = blogMapper.getBlogsByDynamicSQL(map);
        for(Blog blog:blogs){
            System.out.println(blog.getTitle());
        }
        System.out.println("---------下面传入标题的参数---------");

        //下面传入标题的参数
        map.put("title","s");
        List<Blog> blogs1 = blogMapper.getBlogsByDynamicSQL(map);
        for(Blog blog:blogs1){
            System.out.println(blog.getTitle());
        }
        System.out.println("---------下面传入作者的参数---------");

        //面传入作者的参数
        map.put("author","王");
        map.put("title","s");
        List<Blog> blogs2 = blogMapper.getBlogsByDynamicSQL(map);
        for(Blog blog:blogs2){
            System.out.println(blog.getAuthor());
        }

        sqlSession.close();
    }

    @org.junit.Test
    public void testDynamicSQL1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("author","涛");
        List<Blog> blogs = blogMapper.getBlogsByDynamicSQL1(map);
        for(Blog blog:blogs){
            System.out.println(blog.getTitle());
        }

        sqlSession.close();
    }

    @org.junit.Test
    public void testDynamicSQL2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","实战");
        List<Blog> blogs = blogMapper.getBlogsByDynamicSQL2(map);
        for(Blog blog:blogs){
            System.out.println(blog.getTitle());
        }
        System.out.println("----------------");
        map.remove("title");
        map.put("views",2000);
        List<Blog> blogs1 = blogMapper.getBlogsByDynamicSQL2(map);
        for(Blog blog:blogs1){
            System.out.println(blog.getViews());
        }

        sqlSession.close();
    }

    @org.junit.Test
    public void testDynamicSQL3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("author","ktsrkwtmk");
        map.put("id","04e401c8efa540d3888f26c47a82bb01");

        blogMapper.updateByDynamicSQL(map);

        sqlSession.close();
    }
}
