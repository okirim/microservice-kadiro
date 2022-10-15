package kadiro.com;


import kadiro.com.dto.UserCreateDto;
import kadiro.com.routes.Routes;
import kadiro.com.user.UserVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(Routes.REGISTER)
    public ResponseEntity<HttpResponse<UserVM>> register(@Valid @RequestBody UserCreateDto userCreateDto) {
        User user = userService.register(userCreateDto);
        UserVM userVM = modelMapper.map(user, UserVM.class);
        return ResponseEntity.ok(new HttpResponse<>(userVM));
    }
}
