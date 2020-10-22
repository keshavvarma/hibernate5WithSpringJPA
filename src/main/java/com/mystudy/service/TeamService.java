/**
 * 
 */
package com.mystudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.dao.TeamDao;
import com.mystudy.model.Team;

/**
 * @author Keshav
 *
 */
@Service
public class TeamService {
	@Autowired
	TeamDao teamDao;
	
	public Team saveTeam() {
		Team team = new Team();
		team.setTeamCode("Team A");
		return teamDao.save(team);
	}
}
