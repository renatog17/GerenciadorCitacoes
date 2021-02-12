package com.renato.citacoes;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renato.citacoes.domain.Citacao;
import com.renato.citacoes.domain.Comentario;
import com.renato.citacoes.domain.Usuario;
import com.renato.citacoes.repositories.CitacaoRepository;
import com.renato.citacoes.repositories.ComentarioRepository;
import com.renato.citacoes.repositories.UsuarioRepository;

@SpringBootApplication
public class CitacoesApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private CitacaoRepository citacaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CitacoesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "renato@email.com", "renato oliveira");
		Usuario u2 = new Usuario(null, "aaaa@email.com", "aaaa oliveira");
		Usuario u3 = new Usuario(null, "bbbb@email.com", "bbbb oliveira");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Citacao ci1 = new Citacao(null, "132", "os barcos são como as lanchas, as lanchas...",sdf.parse("30/09/2017 10:32"), u1);
		Citacao ci2 = new Citacao(null, "144", "harry dos harry da inglaterra dos potter", sdf.parse("12/07/2021 11:52"), u2);
		
		Comentario co1 = new Comentario(null, "essa citacao é bem legal", u1, ci1);
		Comentario co2 = new Comentario(null, "essa citacao é bem legal outra vez", u3, ci2);
		
		u1.getCitacoes().add(ci1);
		u1.getComentarios().add(co1);
		u2.getCitacoes().add(ci2);
		u3.getComentarios().add(co2);
		
		ci1.getComentarios().add(co1);
		ci2.getComentarios().add(co2);
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
		citacaoRepository.saveAll(Arrays.asList(ci1, ci2));
		comentarioRepository.saveAll(Arrays.asList(co1, co2));
	}

	
}
