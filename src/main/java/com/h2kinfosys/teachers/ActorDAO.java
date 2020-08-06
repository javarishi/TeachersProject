package com.h2kinfosys.teachers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.h2kinfosys.teachers.dto.ActorDTO;

public class ActorDAO {

	ConnectionUtil util = null;
	SessionFactory sessionFactory = null;
	public ActorDAO() throws Exception {
		util = new ConnectionUtil();
	}
	
	
	public List<ActorDTO> getActors(){
		// 1 - Get Session Factory
		sessionFactory = util.getSessionFactory();
		// 2. get session
		Session session = sessionFactory.openSession();
		// 3. transaction
		Transaction tx = session.beginTransaction();
		// 4. query
		TypedQuery<ActorDTO> query = session.createQuery("from ActorDTO");
		List<ActorDTO> actors = query.getResultList();
		tx.commit();
		session.close();
		return actors;
	}
	
	public ActorDTO getActor(int actorId){
		// 1 - Get Session Factory
		sessionFactory = util.getSessionFactory();
		// 2. get session
		Session session = sessionFactory.openSession();
		// 3. transaction
		Transaction tx = session.beginTransaction();
		// 4. query
		TypedQuery<ActorDTO> query = session.createQuery("from ActorDTO as A WHERE A.actorId = :actorId");
		query.setParameter("actorId", actorId);
		ActorDTO actor = query.getSingleResult();
		tx.commit();
		session.close();
		return actor;
	}
	
	
	public ActorDTO saveActor(ActorDTO actor){
		// 1 - Get Session Factory
		sessionFactory = util.getSessionFactory();
		// 2. get session
		Session session = sessionFactory.openSession();
		// 3. transaction
		Transaction tx = session.beginTransaction();
		Integer actorId = (Integer) session.save(actor);
		actor.setActorId(actorId);
		tx.commit();
		session.close();
		return actor;
	}
	
	public ActorDTO updateActor(ActorDTO actor){
		// 1 - Get Session Factory
		sessionFactory = util.getSessionFactory();
		// 2. get session
		Session session = sessionFactory.openSession();
		// 3. transaction
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(actor);
		Integer actorId = (Integer) session.getIdentifier(actor);
		//session.delete(object);
		tx.commit();
		session.close();
		return actor;
	}
	
	// Create Delete Method
	
	public static void main(String[] args) {
		ActorDAO dao;
		try {
			dao = new ActorDAO();
			ActorDTO actor = new ActorDTO();
			// actor.setActorId(203);
			actor.setFirstName("HINA");
			actor.setLastName("SCOTT");
			actor.setLastupdate(new Timestamp(System.currentTimeMillis()));
			
			ActorDTO savedActor = dao.updateActor(actor);
			
			System.out.println(savedActor);
			/*
			 * ActorDTO actor = dao.getActor(200);
			 * List<ActorDTO> actors = dao.getActors(); for(ActorDTO eachActor: actors) {
			 * System.out.println(eachActor); }
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
