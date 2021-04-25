package com.ibepc.sishorasepc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.repositories.AreaRepository;
import com.ibepc.sishorasepc.repositories.AtividadeDocumentoRepository;
import com.ibepc.sishorasepc.repositories.ProjetoRepository;
import com.ibepc.sishorasepc.repositories.SetorRepository;
import com.ibepc.sishorasepc.repositories.UsuarioRepository;

@SpringBootApplication
public class SishorasepcApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		/*-------------------------*/


		Usuario usr1 = new Usuario(null, "william.goncalves", "234", "William Felipe Gonçalves","william.goncalves@butantan.gov.br",sdf.parse("10/05/2021 08:34"));
		Usuario usr2 = new Usuario(null, "guilherme.dasilva", "234", "Guillherme Antonio da Silva","guilherme.dasilva@butantan.gov.br",sdf.parse("08/05/2021 08:34"));
		Usuario usr3 = new Usuario(null, "isabela.quental", "234", "Isabela de Campos Quental","isabela.quental@butantan.gov.br",sdf.parse("30/05/2021 08:34"));
		Usuario usr4 = new Usuario(null, "oswaldo.henrique", "234","Oswaldo Henrique Neto","oswaldo.henrique@butantan.gov.br",sdf.parse("07/05/2021 08:34"));

		Area a1 = new Area(null, "P59");
		Area a2 = new Area(null, "P41 - FOR");

		Projeto p1 = new Projeto(null, "CIP Clarificação", a1, c.getInstance().getTime(), sdf.parse("10/05/2021 08:34"),
				sdf.parse("24/05/2021 08:34"));
		Projeto p2 = new Projeto(null, "Reforma Colheita", a1, c.getInstance().getTime(), sdf.parse("5/05/2021 08:34"), null);
		Projeto p3 = new Projeto(null, "For sigle use", a2, c.getInstance().getTime(), sdf.parse("20/05/2021 08:34"), null);

		Setor s1 = new Setor(null, "Automação", p1);
		Setor s2 = new Setor(null, "Eng. Processos", p1);
		Setor s3 = new Setor(null, "Automação", p3);
		Setor s4 = new Setor(null, "Eng. Processos", p2);

		AtividadeDocumento atvdoc1 = new AtividadeDocumento(null, "Arquitetura de rede",sdf.parse("05/05/2021 08:34"), p1, s1, usr1);
		AtividadeDocumento atvdoc2 = new AtividadeDocumento(null, "Lista de IO",sdf.parse("10/05/2021 08:34"), p1, s1, usr2);
		AtividadeDocumento atvdoc3 = new AtividadeDocumento(null, "Fluxograma",sdf.parse("15/05/2021 08:34"), p1, s2, usr3);
		AtividadeDocumento atvdoc4 = new AtividadeDocumento(null, "P&ID",sdf.parse("20/05/2021 08:34"), p1, s2, usr4);
		AtividadeDocumento atvdoc5 = new AtividadeDocumento(null, "Lista quantitativa",sdf.parse("25/05/2021 08:34"), p2, s4, usr4);
		AtividadeDocumento atvdoc6 = new AtividadeDocumento(null, "Desenvolvimento de software",sdf.parse("30/05/2021 08:34"), p3, s3, usr1);


		usuarioRepository.saveAll(Arrays.asList(usr1, usr2,usr3,usr4));
		areaRepository.saveAll(Arrays.asList(a1, a2));
		projetoRepository.saveAll(Arrays.asList(p1, p2, p3));
		SetorRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		atividadeDocumentoRepository.saveAll(Arrays.asList(atvdoc1, atvdoc2, atvdoc3, atvdoc4, atvdoc5, atvdoc6));

	}

}
