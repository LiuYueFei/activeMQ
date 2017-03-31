package struts;

import static org.junit.Assert.fail;

import javax.annotation.Resource;
import javax.transaction.TransactionManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.szzhouxue.struts.entity.Department;
import com.szzhouxue.struts.entity.Employee;
import com.szzhouxue.struts.service.EmployeeService;

//使用junit4进行测试
@RunWith(SpringJUnit4ClassRunner.class)
// 加载配置文件
@ContextConfiguration(locations = { "classpath:applicationContext-dao.xml", "classpath:applicationContext-action.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class UserServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void test01() {
		System.out.println(employeeService);
		Employee employee = new Employee();
		employeeService.add(employee);
		System.out.println(employee.getId());
	}
}
