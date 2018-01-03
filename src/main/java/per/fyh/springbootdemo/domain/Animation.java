package per.fyh.springbootdemo.domain;

/**
 * @Description:
 * @Author：Foyerry
 * @Date：Created in  2018/1/2 15:35
 */
public class Animation {
	private int id;
	private String  name;
	private float score;

	public Animation(String name, float score) {
		this.name = name;
		this.score = score;
	}

	public Animation() {
	}

	public int getId() {
		return id;

	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Animation{" +
				"id=" + id +
				", name='" + name + '\'' +
				", score=" + score +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}
