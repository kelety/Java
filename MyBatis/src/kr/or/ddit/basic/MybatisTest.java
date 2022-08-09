package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {
	public static void main(String[] args) {
		// myBatis를 이용하여 DB자료를 처리하는 작업 순서
		// 1. myBatis의 환경 설정파일을 읽어와 실행시킨다.

		SqlSession sqlSession = null;
		try {
			// 1-1. xml설정문서 읽어오기
			// 설정파일의 인코딩정보 설정(한글처리를 위해)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");

			// 1-2. 위에서 읽어온 Reader 객체를 이용하여 실제 작업을 진행할 객체 생성하기
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rd);

			// 오토커밋 여부 설정
			sqlSession = sessionFactory.openSession(true);

			rd.close(); // 자원반납

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
