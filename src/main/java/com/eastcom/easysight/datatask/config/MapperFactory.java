package com.eastcom.easysight.datatask.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.web.context.ContextLoader;

import me.jpa.test.Mapper;


public enum MapperFactory {

	ES {
		private SqlSessionFactory sqlSessionFactory;

		@Override
		public <T> T createMapper(Class<? extends Mapper> clazz) {
			return createMapper(clazz, this);
		}

		@Override
		protected void createSqlSessionFactory() {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource((DataSource)ContextLoader.getCurrentWebApplicationContext().getBean("esDataSource"));
			try {
				sqlSessionFactory = factoryBean.getObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, this.name());
		}

		@Override
		public SqlSessionFactory getSqlSessionFactory() {
			return sqlSessionFactory;
		}

	},
	ZG {
		private SqlSessionFactory sqlSessionFactory;

		@Override
		public <T> T createMapper(Class<? extends Mapper> clazz) {
			return createMapper(clazz, this);
		}

		@Override
		protected void createSqlSessionFactory() {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource((DataSource)ContextLoader.getCurrentWebApplicationContext().getBean("zgDataSource"));
			try {
				sqlSessionFactory = factoryBean.getObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, this.name());
		}

		@Override
		public SqlSessionFactory getSqlSessionFactory() {
			return sqlSessionFactory;
		}
	};

	/**
	 * Create a mapper of environment by Mapper class
	 * 
	 * @param clazz
	 *            Mapper class
	 * @param environment
	 *            A datasource environment
	 * @return a Mapper instance
	 */
	public abstract <T> T createMapper(Class<? extends Mapper> clazz);

	/**
	 * Create SqlSessionFactory of environment
	 */
	protected abstract void createSqlSessionFactory();

	/**
	 * get SqlSessionFactory
	 */
	public abstract SqlSessionFactory getSqlSessionFactory();

	//private static InputStream inputStream = null;
	static {
		/*try {
			inputStream = Resources.getResourceAsStream("mybatis/mybatis.xml");
			ZG.createSqlSessionFactory();
			ZG.createSqlSessionFactory();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(inputStream);
		}*/
		ES.createSqlSessionFactory();
		ZG.createSqlSessionFactory();
	}

	private static <T> T createMapper(Class<? extends Mapper> clazz, MapperFactory MapperFactory) {
		SqlSession sqlSession = MapperFactory.getSqlSessionFactory().openSession();
		Mapper mapper = sqlSession.getMapper(clazz);
		return (T) MapperProxy.bind(mapper, sqlSession);
	}

	/**
	 * Mapper Proxy executing mapper method and close sqlsession
	 * 
	 * @author boyce
	 * @version 2014-4-9
	 */
	private static class MapperProxy implements InvocationHandler {
		private Mapper mapper;
		private SqlSession sqlSession;

		private MapperProxy(Mapper mapper, SqlSession sqlSession) {
			this.mapper = mapper;
			this.sqlSession = sqlSession;
		}

		private static Mapper bind(Mapper mapper, SqlSession sqlSession) {
			return (Mapper) Proxy.newProxyInstance(mapper.getClass().getClassLoader(),
					mapper.getClass().getInterfaces(), new MapperProxy(mapper, sqlSession));
		}

		/**
		 * execute mapper method and finally close sqlSession
		 */
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Object object = null;
			try {
				object = method.invoke(mapper, args);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return object;
		}
	}
	
}
