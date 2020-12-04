package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

}
