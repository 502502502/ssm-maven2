package ningct.ssm;

import ningct.ssm.entity.Department;
import ningct.ssm.entity.DepartmentExample;
import ningct.ssm.mapper.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = {"classpath:spring-persist.xml"})
public class connectTest {
    @Autowired
    private DataSource dataSource;

    private Logger logger = LoggerFactory.getLogger(connectTest.class);

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
    }
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void testEmpMapper() {
        List<Department> depList = departmentMapper.selectByExample(new DepartmentExample());
        for (Department dep : depList) {
            System.out.println("dep = " + dep.getDeptName());
        }
    }
}
