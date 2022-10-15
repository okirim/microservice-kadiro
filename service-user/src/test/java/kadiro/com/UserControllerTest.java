package kadiro.com;

import kadiro.com.dto.UserCreateDto;
import kadiro.com.exceptions.ErrorDetails;
import kadiro.com.routes.Routes;
import kadiro.com.user.UserReq;
import kadiro.com.user.UserVM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        testRestTemplate.getRestTemplate().getInterceptors().clear();
        userRepository.deleteAll();
    }

    @Test
    public void test_register_user_should_return_user() {
               UserCreateDto userCreateDto = makeUser();
               var response=testRestTemplate.exchange(Routes.REGISTER, HttpMethod.POST, new HttpEntity<>(userCreateDto), new ParameterizedTypeReference<HttpResponse<UserVM>>() {
               });
               assertThat(response.getStatusCodeValue()).isEqualTo(200);
                assertThat(Objects.requireNonNull(response.getBody()).getData().getId()).isEqualTo(1L);
    }

    private UserCreateDto makeUser() {
        UserCreateDto userReq = new UserCreateDto();
        userReq.setEmail("k@k.com");
        userReq.setPassword("Abc123456!op09Z;");
        userReq.setPasswordConfirm("Abc123456!op09Z;");
        userReq.setFirstName("kadiro");
        userReq.setLastName("okirim");
        return userReq;
    }
}
