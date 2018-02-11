package per.fyh.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import per.fyh.springbootdemo.domain.Animation;
import per.fyh.springbootdemo.domain.User;
import per.fyh.springbootdemo.service.AnimationService;

import java.util.List;

/**
 * @Description:
 * @Author：Foyerry
 * @Date：Created in  2018/1/2 17:38
 */
@RestController
@RequestMapping("/anime")
@Slf4j
public class AnimationController {
	Logger logger = LoggerFactory.getLogger(AnimationController.class);

	@RequestMapping("/{id}")
	public Animation selectAnimationById(@PathVariable int id) {
		try {
			Animation animation = AnimationService.selectAnimationById(id);
			return animation;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}


	}

	@RequestMapping("/add")
	public String addAnimation() {
		Animation animation = new Animation("灌篮高手", (float) 8.50);
		boolean result = AnimationService.insertAnimation(animation);
		return result ? "添加成功" : "添加失败";
	}
}
