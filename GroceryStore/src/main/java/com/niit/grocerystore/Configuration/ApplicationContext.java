package com.niit.grocerystore.Configuration;

    import java.util.Properties;

	import javax.sql.DataSource;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
    import org.springframework.jdbc.datasource.DriverManagerDataSource;
    import org.springframework.orm.hibernate5.HibernateTransactionManager;
    import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
    import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.grocerystore.Dao.AuthenticationDao;
import com.niit.grocerystore.Dao.BillingDao;
    import com.niit.grocerystore.Dao.CartDao;
    import com.niit.grocerystore.Dao.CartItemsDao;
    import com.niit.grocerystore.Dao.CategoryDao;
    import com.niit.grocerystore.Dao.OrderDao;
    import com.niit.grocerystore.Dao.OrderItemsDao;
    import com.niit.grocerystore.Dao.PayDao;
    import com.niit.grocerystore.Dao.ProductDao;
    import com.niit.grocerystore.Dao.ShippingDao;
    import com.niit.grocerystore.Dao.SupplierDao;
    import com.niit.grocerystore.Dao.UserDao;
import com.niit.grocerystore.DaoImpl.AuthenticationDaoImpl;
import com.niit.grocerystore.DaoImpl.BillingDaoImpl;
import com.niit.grocerystore.DaoImpl.CartDaoImpl;
import com.niit.grocerystore.DaoImpl.CartItemsDaoImpl;
import com.niit.grocerystore.DaoImpl.CategoryDaoImpl;
import com.niit.grocerystore.DaoImpl.OrderDaoImpl;
import com.niit.grocerystore.DaoImpl.OrderItemsDaoImpl;
import com.niit.grocerystore.DaoImpl.PayDaoImpl;
import com.niit.grocerystore.DaoImpl.ProductDaoImpl;
import com.niit.grocerystore.DaoImpl.ShippingDaoImpl;
import com.niit.grocerystore.DaoImpl.SupplierDaoImpl;
    import com.niit.grocerystore.DaoImpl.UserDaoImpl;
import com.niit.grocerystore.model.Authentication;
import com.niit.grocerystore.model.Billing;
    import com.niit.grocerystore.model.Cart;
    import com.niit.grocerystore.model.CartItems;
    import com.niit.grocerystore.model.Category;
    import com.niit.grocerystore.model.Order;
    import com.niit.grocerystore.model.OrderItems;
    import com.niit.grocerystore.model.Pay;
    import com.niit.grocerystore.model.Product;
    import com.niit.grocerystore.model.Shipping;
    import com.niit.grocerystore.model.Supplier;
    import com.niit.grocerystore.model.User;
	
	
	@Configuration
	@ComponentScan("com.niit.*")
	@EnableTransactionManagement
	public class ApplicationContext 
	{
		@Bean("dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/GroceryStore");
			dataSource.setUsername("sa");
			dataSource.setPassword("sa");
			return dataSource;
	}
		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.connection.pool_size", "10");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			return properties;
		}
		
		@Autowired
		@Bean("sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(Authentication.class);
			sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Product.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.addAnnotatedClass(User.class);
			sessionBuilder.addAnnotatedClass(Billing.class);
			sessionBuilder.addAnnotatedClass(Cart.class);
			sessionBuilder.addAnnotatedClass(CartItems.class);
			sessionBuilder.addAnnotatedClass(Order.class);
			sessionBuilder.addAnnotatedClass(OrderItems.class);
			sessionBuilder.addAnnotatedClass(Pay.class);
			sessionBuilder.addAnnotatedClass(Shipping.class);
			return sessionBuilder.buildSessionFactory();
		}
		
		@Autowired
		@Bean("transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

		@Autowired
		@Bean("authenticationDao")
		public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
			return new AuthenticationDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("categoryDao")
		public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
			return new CategoryDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean("productDao")
		public ProductDao getProductDao(SessionFactory sessionFactory) {
			return new ProductDaoImpl(sessionFactory);
		}		
		
		@Autowired
		@Bean("supplierDao")
		public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("userDao")
		public UserDao getUserDao(SessionFactory sessionFactory) {
			return new UserDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("billingDao")
		public BillingDao getBillingDao(SessionFactory sessionFactory) {
			return new BillingDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("cartDao")
		public CartDao getCartDao(SessionFactory sessionFactory) {
			return new CartDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("cartItemsDao")
		public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) {
			return new CartItemsDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("orderDao")
		public OrderDao getOrderDao(SessionFactory sessionFactory) {
			return new OrderDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("orderItemsDao")
		public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
			return new OrderItemsDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("payDao")
		public PayDao getPayDao(SessionFactory sessionFactory) {
			return new PayDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("shippingDao")
		public ShippingDao getShippingDao(SessionFactory sessionFactory) {
			return new ShippingDaoImpl(sessionFactory);
		}
		
}
