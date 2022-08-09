package bean;

import java.sql.Date;

public class Game {
	private int cl_id;
	private int game_id;
	private Date date;
	private int play_count;
	private int sess_count;
	private int ply_chip;
	private int win_chip;
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getPlay_count() {
		return play_count;
	}
	public void setPlay_count(int play_count) {
		this.play_count = play_count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSess_count() {
		return sess_count;
	}
	public void setSess_count(int sess_count) {
		this.sess_count = sess_count;
	}
	public int getPly_chip() {
		return ply_chip;
	}
	public void setPly_chip(int ply_chip) {
		this.ply_chip = ply_chip;
	}
	public int getWin_chip() {
		return win_chip;
	}
	public void setWin_chip(int win_chip) {
		this.win_chip = win_chip;
	}	
}
