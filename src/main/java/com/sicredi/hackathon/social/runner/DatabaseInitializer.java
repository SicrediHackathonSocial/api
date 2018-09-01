package com.sicredi.hackathon.social.runner;


import com.sicredi.hackathon.social.domain.ProjectType;
import com.sicredi.hackathon.social.entity.ContribuitionEntity;
import com.sicredi.hackathon.social.entity.GoalEntity;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.repository.ContribuitionRepository;
import com.sicredi.hackathon.social.repository.GoalRepository;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import com.sicredi.hackathon.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContribuitionRepository contribuitionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserEntity roberto = userRepository.save(new UserEntity("betinho", "poc123"));
        ProjectEntity bike = projectRepository.save(new ProjectEntity("Minha Cross", "", roberto, ProjectType.PRIVATE));
        GoalEntity entradaBike = goalRepository.save(new GoalEntity("Entrada", valor("100.00"), bike));
        GoalEntity parcelasBike = goalRepository.save(new GoalEntity("Parcelas", valor("400.00"), bike));
        ContribuitionEntity c1 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasBike, valor("150")));
        ContribuitionEntity c2 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasBike, valor("15")));

        UserEntity marcos = userRepository.save(new UserEntity("marquinhos", "123456"));
        ProjectEntity moto = projectRepository.save(new ProjectEntity("Meu Sonho", "YBR125", marcos, ProjectType.SHARED, Arrays.asList(roberto)));
        GoalEntity entradaMoto = goalRepository.save(new GoalEntity("Entrada", valor("1000.00"), moto));
        GoalEntity parcelasMoto1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("1000.00"), moto));
        GoalEntity parcelasMoto2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("1000.00"), moto));
        ContribuitionEntity c3 = contribuitionRepository.save(new ContribuitionEntity(marcos, parcelasMoto1, valor("100")));
        ContribuitionEntity c4 = contribuitionRepository.save(new ContribuitionEntity(roberto, entradaMoto, valor("10")));

        UserEntity bianca = userRepository.save(new UserEntity("bia_gatinha_88", "biaforever"));
        ProjectEntity patioEscola = projectRepository.save(new ProjectEntity("Reforma pátio da Escola", "Escola Benjamin Franklin", bianca, ProjectType.PUBLIC));
        GoalEntity reformaQuadra = goalRepository.save(new GoalEntity("Reforma Quadra", valor("1000.00"), patioEscola));
        GoalEntity reformaJardim = goalRepository.save(new GoalEntity("Reforma Jardim", valor("500.00"), patioEscola));
        GoalEntity reformaPracinha = goalRepository.save(new GoalEntity("Reforma Pracinha", valor("500.00"), patioEscola));
        GoalEntity pinturaGeral = goalRepository.save(new GoalEntity("Pinturas em Geral", valor("300.00"), patioEscola));
        ContribuitionEntity c5 = contribuitionRepository.save(new ContribuitionEntity(marcos, pinturaGeral, valor("300")));
        ContribuitionEntity c6 = contribuitionRepository.save(new ContribuitionEntity(roberto, reformaQuadra, valor("600")));

        // suelen
        UserEntity Larisa = userRepository.save(new UserEntity("lary", "lary123"));
        ProjectEntity mochila = projectRepository.save(new ProjectEntity("minha mochila ", "", Larisa, ProjectType.PRIVATE));
        GoalEntity entradaMochila = goalRepository.save(new GoalEntity("Entrada", valor("50.00"), mochila));
        GoalEntity parcelasmochila = goalRepository.save(new GoalEntity("Parcelas", valor("50.00"), mochila));
        ContribuitionEntity m1 = contribuitionRepository.save(new ContribuitionEntity(Larisa, parcelasmochila, valor("50.00")));
        ContribuitionEntity m2 = contribuitionRepository.save(new ContribuitionEntity(Larisa, parcelasmochila, valor("25.00")));

        UserEntity evandro = userRepository.save(new UserEntity("evandro_gatinho", "vandinho123"));
        ProjectEntity carro= projectRepository.save(new ProjectEntity("rumo a felicidade ", "YBR125",Larisa, ProjectType.SHARED, Arrays.asList(roberto)));
        GoalEntity entradacarro = goalRepository.save(new GoalEntity("Entrada", valor("5000.00"), carro));
        GoalEntity parcelascarro1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("1000.00"), carro));
        GoalEntity parcelascarro2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("1000.00"), carro));
        ContribuitionEntity m3 = contribuitionRepository.save(new ContribuitionEntity(evandro, parcelascarro1, valor("1000")));
        ContribuitionEntity m4 = contribuitionRepository.save(new ContribuitionEntity(evandro, entradacarro, valor("300")));

        UserEntity vanesa = userRepository.save(new UserEntity("vanesa_881", "vanesagatinha"));
        ProjectEntity reformadoquarto = projectRepository.save(new ProjectEntity("Reforma do quarto", "quarto dos sonhos ", vanesa, ProjectType.PUBLIC));
        GoalEntity reformacasa = goalRepository.save(new GoalEntity("Reforma da casa" , valor("500.00"), reformadoquarto));
        GoalEntity reformabanheiro = goalRepository.save(new GoalEntity("banheiro", valor("100.00"), reformadoquarto));
        GoalEntity reformaquarto = goalRepository.save(new GoalEntity("reformar  do quarto", valor("100.00"), reformadoquarto));
        GoalEntity pinturaCasa = goalRepository.save(new GoalEntity("Pinturas em Geral", valor("100.00"), reformadoquarto));
        ContribuitionEntity m5 = contribuitionRepository.save(new ContribuitionEntity(evandro, pinturaCasa, valor("100")));
        ContribuitionEntity m6 = contribuitionRepository.save(new ContribuitionEntity(evandro, reformacasa, valor("500")));
    }


    private BigDecimal valor(String value) {
        return  new BigDecimal(value);
    }
}