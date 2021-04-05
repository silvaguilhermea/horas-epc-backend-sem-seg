package com.ibepc.sishorasepc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

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
		
		/* formas diferentes de se trabalhar com datas, através de Calendar e Format */
		
		Calendar c = Calendar.getInstance();
		c.set(2021, Calendar.APRIL, 30, 10, 52);
		Date datafim = c.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm" );
		
		/*-------------------------*/
				
		Area a1 = new Area(null, "P59");
		Area a2 = new Area(null, "P41 - FOR");

		Projeto p1 = new Projeto(null, "CIP Clarificação", a1,c.getInstance().getTime(), datafim, sdf.parse("24/05/2021 08:34"));
		Projeto p2 = new Projeto(null, "Reforma Colheita", a1,c.getInstance().getTime(),datafim,null);
		Projeto p3 = new Projeto(null, "For sigle use", a2,c.getInstance().getTime(),datafim,null);

		Setor s1 = new Setor(null, "Automação");
		Setor s2 = new Setor(null, "Eng. Processos");
		
		AtividadeDocumento atvdoc1 = new AtividadeDocumento(null,s1,p1,"Arquitetura de rede");
		AtividadeDocumento atvdoc2 = new AtividadeDocumento(null,s1,p1,"Lista de IOs");
		AtividadeDocumento atvdoc3 = new AtividadeDocumento(null,s2,p1,"Fluxograma");
		AtividadeDocumento atvdoc4 = new AtividadeDocumento(null,s2,p1,"Lista Quantitativa");
		AtividadeDocumento atvdoc5 = new AtividadeDocumento(null,s2,p2,"P&D");
		AtividadeDocumento atvdoc6 = new AtividadeDocumento(null,s1,p3,"Desenvol. software");
		
		
		/* Relaciona Áreas com Projetos */
		a1.getProjeto().addAll(Arrays.asList(p1, p2));
		a2.getProjeto().addAll(Arrays.asList(p3)); 
		
		/* Relaciona Setores com documentos */
		s1.getAtividadeDocumento().addAll(Arrays.asList(atvdoc1,atvdoc2,atvdoc6));
		s2.getAtividadeDocumento().addAll(Arrays.asList(atvdoc3,atvdoc4,atvdoc5));
		
		/* Relaciona Projetos com documentos */
		p1.getAtividadeDocumento().addAll(Arrays.asList(atvdoc1,atvdoc2,atvdoc3,atvdoc4));
		p2.getAtividadeDocumento().addAll(Arrays.asList(atvdoc5));
		p3.getAtividadeDocumento().addAll(Arrays.asList(atvdoc6));

		areaRepository.saveAll(Arrays.asList(a1, a2));
		projetoRepository.saveAll(Arrays.asList(p1, p2, p3));
		SetorRepository.saveAll(Arrays.asList(s1, s2));
		atividadeDocumentoRepository.saveAll(Arrays.asList(
				atvdoc1, atvdoc2,atvdoc3, atvdoc4, atvdoc5, atvdoc6));
		
	}
}
