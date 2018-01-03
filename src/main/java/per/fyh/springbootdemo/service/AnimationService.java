package per.fyh.springbootdemo.service;

import org.apache.ibatis.session.SqlSession;
import per.fyh.springbootdemo.common.MybatisDBHelper;
import per.fyh.springbootdemo.domain.Animation;
import per.fyh.springbootdemo.mapper.AnimationMapper;

/**
 * @Description:
 * @Author：Foyerry
 * @Date：Created in  2018/1/2 17:24
 */
public class AnimationService {
public static boolean insertAnimation(Animation animation) {
		SqlSession session = MybatisDBHelper.getSession();
		AnimationMapper animationMapper = session.getMapper(AnimationMapper.class);

		int result = 0;
		try {
			result = animationMapper.insertAnimation(animation);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return result > 0 ? true : false;
	}

	public static Animation selectAnimationById(int id) {
		SqlSession session = MybatisDBHelper.getSession();
		AnimationMapper animationMapper = session.getMapper(AnimationMapper.class);
		Animation result = new Animation();
		try {
			result = animationMapper.selectAnimationById(id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}
}
