package com.utility;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Employee;

public class HibernateUtil {

	private static StandardServiceRegistry reg;
	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			Map<String, Object> settings = new HashMap<String, Object>();
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/EmployeeExample");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.HBM2DDL_AUTO, "create");
			settings.put(Environment.FORMAT_SQL, "true");
			settings.put(Environment.SHOW_SQL, "true");

			settings.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
			settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");

			reg = new StandardServiceRegistryBuilder().applySettings(settings).build();
			MetadataSources mds = new MetadataSources(reg);
			mds.addAnnotatedClass(Employee.class);
			Metadata md = mds.getMetadataBuilder().build();
			sf = md.getSessionFactoryBuilder().build();

		}
		return sf;
	}
}
