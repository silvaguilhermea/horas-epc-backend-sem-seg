package com.ibepc.sishorasepc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.domain.Setor;
import com.ibepc.sishorasepc.repositories.AreaRepository;
import com.ibepc.sishorasepc.repositories.AtividadeDocumentoRepository;
import com.ibepc.sishorasepc.repositories.ProjetoRepository;
import com.ibepc.sishorasepc.repositories.SetorRepository;

@SpringBootApplication
public class SishorasepcApplication implements CommandLineRunner {

	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private SetorRepository SetorRepository;
	
	@Autowired
	private AtividadeDocumentoRepository atividadeDocumentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SishorasepcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Area a1 = new Area(null, "P59");
		Area a2 = new Area(null, "P41 - FOR");

		Projeto p1 = new Projeto(null, "CIP Clarificação", a1);
		Projeto p2 = new Projeto(null, "Reforma Colheita", a1);
		Projeto p3 = new Projeto(null, "For sigle use", a2);

		Setor s1 = new Setor(null, "Automação");
		Setor s2 = new Setor(null, "Eng. Processos");
		
		AtividadeDocumento atvdoc1 = new AtividadeDocumento(null,"Arquitetura de rede",s1);
		AtividadeDocumento atvdoc2 = new AtividadeDocumento(null,"Lista de IOs",s1);
		AtividadeDocumento atvdoc3 = new AtividadeDocumento(null,"Fluxograma",s2);
		AtividadeDocumento atvdoc4 = new AtividadeDocumento(null,"Lista Quantitativa",s2);
		

		/* Relaciona Áreas com Projetos */
		a1.getProjeto().addAll(Arrays.asList(p1, p2));
		a2.getProjeto().addAll(Arrays.asList(p3));
			  
		/* Relaciona Projetos com Setores */
		p1.getSetor().addAll(Arrays.asList(s1,s2));
		p2.getSetor().addAll(Arrays.asList(s2));
		p3.getSetor().addAll(Arrays.asList(s1));
		
		/* Relaciona Setores com Projetos */
		s1.getProjeto().addAll(Arrays.asList(p1,p3));
		s2.getProjeto().addAll(Arrays.asList(p1,p2));
		
		/* Relaciona Setores com documentos */
		s1.getAtividadeDocumento().addAll(Arrays.asList(atvdoc1,atvdoc2));
		s2.getAtividadeDocumento().addAll(Arrays.asList(atvdoc3,atvdoc4));

		areaRepository.saveAll(Arrays.asList(a1, a2));
		projetoRepository.saveAll(Arrays.asList(p1, p2, p3));
		SetorRepository.saveAll(Arrays.asList(s1, s2));
		atividadeDocumentoRepository.saveAll(Arrays.asList(atvdoc1, atvdoc2, atvdoc3, atvdoc4));
		
	}
}
