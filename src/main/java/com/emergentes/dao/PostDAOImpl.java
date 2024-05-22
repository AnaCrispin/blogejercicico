package com.emergentes.dao;

import com.emergentes.modelo.Post;
import com.emergentes.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl extends ConexionDB implements PostDAO {

    @Override
    public void insert(Post post) throws Exception {
        try {
            Connection conn = this.conectar();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO posts (fecha, titulo, contenido) VALUES (?, ?, ?)");
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Post post) throws Exception {
        try {
            Connection conn = this.conectar();
            PreparedStatement ps = conn.prepareStatement("UPDATE posts SET fecha = ?, titulo = ?, contenido = ? WHERE id = ?");
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.setInt(4, post.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            Connection conn = this.conectar();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM posts WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Post getById(int id) throws Exception {
        Post post = new Post();
        try {
            Connection conn = this.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM posts WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                post.setContenido(rs.getString("contenido"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return post;
    }

    @Override
    public List<Post> getAll() throws Exception {
        List<Post> lista = null;
        try {
            Connection conn = this.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM posts");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                post.setContenido(rs.getString("contenido"));
                lista.add(post);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
