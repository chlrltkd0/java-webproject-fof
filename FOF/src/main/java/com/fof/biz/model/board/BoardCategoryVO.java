package com.fof.biz.model.board;

public class BoardCategoryVO {
	private int idx;
	private int parentIdx;
	private String name;
	private int seq;
	private int readAuthority;
	private int writeAuthority;
	private int commentAuthority;
	
	public BoardCategoryVO(int idx, int parentIdx, String name, int seq, int readAuthority, int writeAuthority,
			int commentAuthority) {
		super();
		this.idx = idx;
		this.parentIdx = parentIdx;
		this.name = name;
		this.seq = seq;
		this.readAuthority = readAuthority;
		this.writeAuthority = writeAuthority;
		this.commentAuthority = commentAuthority;
	}
	public BoardCategoryVO() {
		super();
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getParentIdx() {
		return parentIdx;
	}
	public void setParentIdx(int parentIdx) {
		this.parentIdx = parentIdx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getReadAuthority() {
		return readAuthority;
	}
	public void setReadAuthority(int readAuthority) {
		this.readAuthority = readAuthority;
	}
	public int getWriteAuthority() {
		return writeAuthority;
	}
	public void setWriteAuthority(int writeAuthority) {
		this.writeAuthority = writeAuthority;
	}
	public int getCommentAuthority() {
		return commentAuthority;
	}
	public void setCommentAuthority(int commentAuthority) {
		this.commentAuthority = commentAuthority;
	}
	@Override
	public String toString() {
		return "BoardCategoryVO [idx=" + idx + ", parentIdx=" + parentIdx + ", name=" + name + ", seq=" + seq
				+ ", readAuthority=" + readAuthority + ", writeAuthority=" + writeAuthority + ", commentAuthority="
				+ commentAuthority + "]";
	}
}
