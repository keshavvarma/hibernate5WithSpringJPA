/**
 * 
 */
package com.mystudy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.model.Team;
import com.mystudy.service.TeamService;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	TeamService teamService;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> saveTest(HttpServletRequest req, HttpServletResponse res) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Team team = teamService.saveTeam();
		map.put("data", team);
		return map;
	}
}
