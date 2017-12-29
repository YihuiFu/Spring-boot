package per.fyh.springbootdemo.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import per.fyh.springbootdemo.domain.ResultData;
import per.fyh.springbootdemo.domain.User;
import per.fyh.springbootdemo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
//@Log4j2
@Slf4j
public class UserController {

	@Resource
	UserService userService;

	@ApiOperation(value = "获取用户列表信息", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> list = userService.getUserList();
		return list;
	}

	@RequestMapping("/all")
	public ResultData<List<User>> getAll() {
		return new ResultData<List<User>>(userService.getUserList());
	}

	@RequestMapping("/{id}")
	public User getUser(@PathVariable int id) {
		if (id > 0)
			return userService.findUserById(id);
		return null;
	}

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public BaseResponseData<List<User>> all() {
//        List<User> list = userService.getUserList();
//        BaseResponseData<List<User>> data = new BaseResponseData<>();
//        data.setCode(0);
//        data.setMessage("成功");
//        data.setData(list);
//        return data;
//    }

//    @ApiOperation(value = "创建用户", notes = "根据user对象创建用户")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User getUser(@PathVariable int id) {
//        return userService.findUserById(id);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String deleteUser(@PathVariable int id) {
//        userService.delete(id);
//        return "SUCCESS";
//    }
//
//    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable int id, @ModelAttribute User user) {
        userService.save(user);
        return "success";
    }
}
