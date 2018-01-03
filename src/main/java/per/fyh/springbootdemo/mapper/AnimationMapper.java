package per.fyh.springbootdemo.mapper;

import per.fyh.springbootdemo.domain.Animation;

import java.util.List;

/**
 * @Description:
 * @Author：Foyerry
 * @Date：Created in  2018/1/2 15:42
 */
public interface AnimationMapper {
	 int insertAnimation(Animation animation) throws Exception;

	 int deleteAnimation(int id);

	 int updateAnimation(Animation animation,int id);

	 Animation selectAnimationById(int id);

	 List<Animation> selectAllAnimation();
}
