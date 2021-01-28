package com.juno.bg10;

import java.util.List;

public interface IbbsDao {
	public List<Bbs> list();
	public Bbs view();
	public int write(Bbs bbs);
	public int update(Bbs bbs);
	public int delete(String id);
}
