package com.weibo.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.weibo.entity.Comments;

public class CommentDAOimp extends BaseDAO implements CommentDAO {

	@Override
	public List<Comments> find(int from, String type) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql="from Comments c where c.from=? and c.type=?";
//		String hql="from Comments";
		Query query = session.createQuery(hql);
		query.setParameter(0, from);
		query.setParameter(1, type);
		List<Comments> list = query.list();
		session.close();
		return list;
	}

	@Override
	public void add(Comments c) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction ts = session.getTransaction();
		session.save(c);
		ts.commit();
		session.close();

	}

}
