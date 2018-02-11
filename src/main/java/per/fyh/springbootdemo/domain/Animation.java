package per.fyh.springbootdemo.domain;

import java.util.Date;

/**
 * @Description:
 * @Author：Foyerry
 * @Date：Created in  2018/1/2 15:35
 */
public class Animation {
	private int id;
	private String  name;
	private float score;
	private int status;



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getPlay_date() {
		return play_date;
	}

	public void setPlay_date(Date play_date) {
		this.play_date = play_date;
	}

	private Date play_date;

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
