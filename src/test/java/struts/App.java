package struts;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szzhouxue.struts.dao.EmployeeDao;
import com.szzhouxue.struts.entity.Department;
import com.szzhouxue.struts.entity.Employee;
import com.szzhouxue.struts.service.EmployeeService;

public class App {

	private ApplicationContext ac;

	private EmployeeService empService;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		empService = ac.getBean(EmployeeService.class);
	}

	@Test
	public void test01() {
		Employee emp1 = new Employee(null, "name1", "广东深圳", "2313@qq.com", new Department(null, "开发部"));

		Employee emp2 = new Employee(null, "name2", "广东广州", "2222@163.com", new Department(null, "市场部"));

		empService.add(emp1);
		empService.add(emp2);

	}

	@Test
	public void test2() throws Exception {
		List<Employee> list = empService.list();
		System.out.println(list.size());

	}
}
