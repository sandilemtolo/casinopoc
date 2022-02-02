package com.dagacube.casinopoc.dao;

import java.util.Optional;

import com.dagacube.casinopoc.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends JpaRepository<Player, Integer> {

	@Query("SELECT p FROM Player p WHERE p.pid = ?1")
	Optional<Player> getPlayerById(Integer pid);

	@Query("SELECT p FROM Player p WHERE p.username = ?1")
	Optional<Player> getPlayerByUsername(String username);
	
}
