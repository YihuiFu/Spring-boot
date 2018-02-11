package per.fyh.springbootdemo.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @Description:
 * @Author：Foyerry
 * @Date：Created in  2018/1/2 17:17
 */
public class MybatisDBHelper {
	public static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {

		}
	}

	public static SqlSession getSession(){
		try {
			return sqlSessionFactory.openSession();
		}
		catch (Exception e){
			return null;
		}

	}

}
