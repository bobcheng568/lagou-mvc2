import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application*.xml"})
public class MybatisSpringTest {

    // 希望测试ioc容器中的哪个对象你注入即可。
    @Autowired
    private ResumeService resumeService;

    @Test
    public void testMybatisSpring() throws Exception {
        List<Resume> resumes = resumeService.queryResumeList();
        for (int i = 0; i < resumes.size(); i++) {
            Resume resume =  resumes.get(i);
            System.out.println(resume);
        }
    }
}
