package com.ibepc.sishorasepc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.repositories.AreaRepository;
import com.ibepc.sishorasepc.repositories.ProjetoRepository;

@SpringBootApplication
public class SishorasepcApplication implements CommandLineRunner {

	  @Autowired 
	  private AreaRepository areaRepository;
	  
	  @Autowired 
	  private ProjetoRepository projetoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SishorasepcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Area a1 = new Area(null,"P59"); 
		Area a2 = new Area(null,"P41 - FOR");
		
		Projeto p1 = new Projeto (null,"CIP Clarificação",a1); 
		Projeto p2 = new Projeto (null,"Reforma Colheita",a1); 
		Projeto p3 = new Projeto (null,"For sigle use",a2);
		  
		a1.getProjeto().addAll(Arrays.asList(p1,p2));
		a2.getProjeto().addAll(Arrays.asList(p3));
		
		areaRepository.saveAll(Arrays.asList(a1,a2));
		projetoRepository.saveAll(Arrays.asList(p1,p2,p3));
		 
	}
}
