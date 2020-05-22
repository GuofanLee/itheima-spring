import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 06:01
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {

    @Resource
    private AccountService accountService;

    @Test
    public void testAdd() {
        accountService.add();
    }

    @Test
    public void testUpdate() {
        accountService.update(10);
    }

    @Test
    public void testDelete() {
        accountService.delete();
    }

}
