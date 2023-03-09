package main;

import dao.*;
import domain.*;
import persistence.JpaPersistence;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[]args){
        var campeonatoDAO = new CampeonatoDAO();
        var tecnicoDAO = new TecnicoDAO();
        var equipeDAO = new EquipeDAO();
        var jogadorDAO = new JogadorDAO();

        var campeonato = Campeonato.builder().nomeCampeonato("Paraibano")
                .dataInicial(LocalDate.of(2023,02,26))
                .dataFinal(LocalDate.of(2023,04,02)).build();

//        System.out.println("Salvando campeonato....");
//        campeonatoDAO.saveOrUpdate(campeonato);
//        System.out.println("operaçao realizada com sucesso");

        Tecnico tecnico = new Tecnico();

        tecnico.setNome("Matias");
        tecnico.setCpf("325498155");
        tecnico.setMatriculaCBF("2315486695");
//
//        System.out.println("Salvando tecnico");
//        tecnicoDAO.saveOrUpdate(tecnico);
//        System.out.println("Processo realizado com sucesso");

        var t = tecnicoDAO.findById(Tecnico.class,2l);
        var jogador1 = new Jogador();
        jogador1.setNome("Cristiano Ronaldo");
        jogador1.setCpf("147852369");
        jogador1.setPosicao("Atacante");
        jogador1.setTitular(Boolean.TRUE);

        var jogador2 = new Jogador();
        jogador2.setNome("Messi");
        jogador2.setCpf("369852147");
        jogador2.setPosicao("Atacante");
        jogador2.setTitular(Boolean.FALSE);
//

        var equipe = Equipe.builder().nome("Atletico de Cajazeiras")
                .tecnico(t)
                .id(1l)
                .campeonatos(Arrays.asList(campeonatoDAO.findByNome("Paraibano"),
                        campeonatoDAO.findByNome("Copa do Brasil")))
                        .jogadores(Arrays.asList(jogador1,jogador2)).build();

        System.out.println("Salvando Equipe....");
        //equipeDAO.saveOrUpdate(equipe);
        var eq = equipeDAO.findById(Equipe.class,1l);
        var cr7 =jogadorDAO.findById(Jogador.class,4l);
        var messi =jogadorDAO.findById(Jogador.class,5l);
        cr7.setEquipe(eq);
        messi.setEquipe(eq);
        var jogadores=Arrays.asList(cr7,messi);
        jogadores.forEach(j ->{
            jogadorDAO.saveOrUpdate(j);
        });
        System.out.println("operaçao realizada com sucesso");
    }
}
