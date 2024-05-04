package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Util {
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/mysql");
        dataSource.setUser("mysql");
        dataSource.setPassword("mysql");
        return dataSource;
    }
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }
}
