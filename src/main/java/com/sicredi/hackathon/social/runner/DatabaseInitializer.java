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
        UserEntity marcos = userRepository.save(new UserEntity("marquinhos", "123456"));
        UserEntity bianca = userRepository.save(new UserEntity("bia_gatinha_88", "biaforever"));
        UserEntity Larisa = userRepository.save(new UserEntity("lary", "lary123"));
        UserEntity evandro = userRepository.save(new UserEntity("evandro_gatinho", "vandinho123"));
        UserEntity vanesa = userRepository.save(new UserEntity("vanesa_881", "vanesagatinha"));
        UserEntity berenice = userRepository.save(new UserEntity("bere_power", "33665520"));
        UserEntity sandra = userRepository.save(new UserEntity("girlsandra", "pedroaugusto"));
        UserEntity rafaela = userRepository.save(new UserEntity("rafaquenn", "rr1234"));
        UserEntity julio = userRepository.save(new UserEntity("julio_ele", "vivavida"));
        UserEntity felizardo = userRepository.save(new UserEntity("happyzardo", "feliz4567"));
        UserEntity joao = userRepository.save(new UserEntity("joaozito", "jojo12"));
        UserEntity catia = userRepository.save(new UserEntity("Ca_Santos", "santosss"));
        UserEntity fran = userRepository.save(new UserEntity("fran", "123456"));
        UserEntity luis = userRepository.save(new UserEntity("luisinho", "ll1234"));
        UserEntity carla = userRepository.save(new UserEntity("carlaroberta", "umataldecarla"));
        UserEntity amanda = userRepository.save(new UserEntity("Amandaama", "ama5555"));
        UserEntity Rosane = userRepository.save(new UserEntity("rose", "rose123"));
        UserEntity Carol = userRepository.save(new UserEntity("Carolzinha", "123o456"));
        UserEntity Luan = userRepository.save(new UserEntity("Luan_gatinho", "luan952"));
        UserEntity eduarda = userRepository.save(new UserEntity("Duda_socão", "eduarda123"));

        ProjectEntity bike = projectRepository.save(new ProjectEntity("Minha Cross", "", roberto, ProjectType.PRIVATE));
        GoalEntity entradaBike = goalRepository.save(new GoalEntity("Entrada", valor("100.00"), bike));
        GoalEntity parcelasBike = goalRepository.save(new GoalEntity("Parcelas", valor("400.00"), bike));
        ContribuitionEntity c1 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasBike, valor("150")));
        ContribuitionEntity c2 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasBike, valor("15")));

        ProjectEntity moto = projectRepository.save(new ProjectEntity("Meu Sonho", "YBR125", marcos, ProjectType.SHARED, Arrays.asList(roberto)));
        GoalEntity entradaMoto = goalRepository.save(new GoalEntity("Entrada", valor("1000.00"), moto));
        GoalEntity parcelasMoto1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("1000.00"), moto));
        GoalEntity parcelasMoto2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("1000.00"), moto));
        ContribuitionEntity c3 = contribuitionRepository.save(new ContribuitionEntity(marcos, parcelasMoto1, valor("100")));
        ContribuitionEntity c4 = contribuitionRepository.save(new ContribuitionEntity(roberto, entradaMoto, valor("10")));

        ProjectEntity patioEscola = projectRepository.save(new ProjectEntity("Reforma pátio da Escola", "Escola Benjamin Franklin", bianca, ProjectType.PUBLIC));
        GoalEntity reformaQuadra = goalRepository.save(new GoalEntity("Reforma Quadra", valor("1000.00"), patioEscola));
        GoalEntity reformaJardim = goalRepository.save(new GoalEntity("Reforma Jardim", valor("500.00"), patioEscola));
        GoalEntity reformaPracinha = goalRepository.save(new GoalEntity("Reforma Pracinha", valor("500.00"), patioEscola));
        GoalEntity pinturaGeral = goalRepository.save(new GoalEntity("Pinturas em Geral", valor("300.00"), patioEscola));
        ContribuitionEntity c5 = contribuitionRepository.save(new ContribuitionEntity(marcos, pinturaGeral, valor("300")));
        ContribuitionEntity c6 = contribuitionRepository.save(new ContribuitionEntity(roberto, reformaQuadra, valor("600")));

        ProjectEntity mochila = projectRepository.save(new ProjectEntity("minha mochila ", "", Larisa, ProjectType.PRIVATE));
        GoalEntity entradaMochila = goalRepository.save(new GoalEntity("Entrada", valor("50.00"), mochila));
        GoalEntity parcelasmochila = goalRepository.save(new GoalEntity("Parcelas", valor("50.00"), mochila));
        ContribuitionEntity m1 = contribuitionRepository.save(new ContribuitionEntity(Larisa, parcelasmochila, valor("50.00")));
        ContribuitionEntity m2 = contribuitionRepository.save(new ContribuitionEntity(Larisa, parcelasmochila, valor("25.00")));

        ProjectEntity carro= projectRepository.save(new ProjectEntity("rumo a felicidade ", "YBR125",Larisa, ProjectType.SHARED, Arrays.asList(roberto)));
        GoalEntity entradacarro = goalRepository.save(new GoalEntity("Entrada", valor("5000.00"), carro));
        GoalEntity parcelascarro1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("1000.00"), carro));
        GoalEntity parcelascarro2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("1000.00"), carro));
        ContribuitionEntity m3 = contribuitionRepository.save(new ContribuitionEntity(evandro, parcelascarro1, valor("1000")));
        ContribuitionEntity m4 = contribuitionRepository.save(new ContribuitionEntity(evandro, entradacarro, valor("300")));

        ProjectEntity reformadoquarto = projectRepository.save(new ProjectEntity("Reforma do quarto", "quarto dos sonhos ", vanesa, ProjectType.PUBLIC));
        GoalEntity reformacasa = goalRepository.save(new GoalEntity("Reforma da casa" , valor("500.00"), reformadoquarto));
        GoalEntity reformabanheiro = goalRepository.save(new GoalEntity("banheiro", valor("100.00"), reformadoquarto));
        GoalEntity reformaquarto = goalRepository.save(new GoalEntity("reformar  do quarto", valor("100.00"), reformadoquarto));
        GoalEntity pinturaCasa = goalRepository.save(new GoalEntity("Pinturas em Geral", valor("100.00"), reformadoquarto));
        ContribuitionEntity m5 = contribuitionRepository.save(new ContribuitionEntity(evandro, pinturaCasa, valor("100")));
        ContribuitionEntity m6 = contribuitionRepository.save(new ContribuitionEntity(evandro, reformacasa, valor("500")));

        ProjectEntity tenis = projectRepository.save(new ProjectEntity("preciso de um tenis", "", berenice, ProjectType.PRIVATE));
        GoalEntity entradaTenis = goalRepository.save(new GoalEntity("Entrada", valor("150.00"), tenis));
        GoalEntity parcelasTenis = goalRepository.save(new GoalEntity("Parcelas", valor("450.00"), tenis));
        ContribuitionEntity c10 = contribuitionRepository.save(new ContribuitionEntity(berenice, parcelasTenis, valor("50")));
        ContribuitionEntity c11 = contribuitionRepository.save(new ContribuitionEntity(berenice, parcelasTenis, valor("20")));

        ProjectEntity lavadora  = projectRepository.save(new ProjectEntity("Lavadora dos sonhos", "", sandra, ProjectType.SHARED, Arrays.asList(roberto)));
        GoalEntity entradalavadora = goalRepository.save(new GoalEntity("Entrada", valor("1000.00"), moto));
        GoalEntity parcelasLavadora1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("1000.00"), lavadora));
        GoalEntity parcelasLavadora2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("300.00"), lavadora));
        ContribuitionEntity c12 = contribuitionRepository.save(new ContribuitionEntity(berenice, parcelasLavadora1, valor("100")));
        ContribuitionEntity c13 = contribuitionRepository.save(new ContribuitionEntity(sandra, parcelasLavadora2, valor("120")));

        ProjectEntity reformaLancheria = projectRepository.save(new ProjectEntity("Reforma da Lancheria da Rafa", "Lanches Rafa", rafaela, ProjectType.PUBLIC));
        GoalEntity reformaCadeiras = goalRepository.save(new GoalEntity("Reforma Cadeiras", valor("100.00"), reformaLancheria));
        GoalEntity reformaMesas = goalRepository.save(new GoalEntity("Reforma Mesas", valor("250.00"), reformaLancheria));
        GoalEntity reformaLuzes = goalRepository.save(new GoalEntity("Reforma Luzes", valor("500.00"), reformaLancheria));
        GoalEntity pinturaLancheria = goalRepository.save(new GoalEntity("Pinturas em Geral", valor("100.00"), reformaLancheria));
        ContribuitionEntity c14 = contribuitionRepository.save(new ContribuitionEntity(marcos, reformaMesas, valor("50")));
        ContribuitionEntity c15 = contribuitionRepository.save(new ContribuitionEntity(roberto, reformaLuzes, valor("150")));

        ProjectEntity relogio = projectRepository.save(new ProjectEntity("meu cassio", "", julio, ProjectType.PRIVATE));
        GoalEntity entradaRelogio = goalRepository.save(new GoalEntity("Entrada", valor("100.00"), relogio));
        GoalEntity parcelasRelogio = goalRepository.save(new GoalEntity("Parcelas", valor("320.00"), relogio));
        ContribuitionEntity c20 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasRelogio, valor("70")));
        ContribuitionEntity c21 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasRelogio, valor("30")));

        ProjectEntity cadeiraderoda = projectRepository.save(new ProjectEntity("Cadeira Eletronica", "", felizardo, ProjectType.SHARED, Arrays.asList(roberto)));
        GoalEntity entradaCadeiraderoda = goalRepository.save(new GoalEntity("Entrada", valor("1000.00"), cadeiraderoda));
        GoalEntity parcelasCadeiraderoda1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("100.00"), cadeiraderoda));
        GoalEntity parcelasCadeiraderoda2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("250.00"), cadeiraderoda));
        ContribuitionEntity c22 = contribuitionRepository.save(new ContribuitionEntity(marcos, parcelasCadeiraderoda1, valor("100")));
        ContribuitionEntity c23 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasCadeiraderoda2, valor("10")));

        ProjectEntity cahorrosdeRua = projectRepository.save(new ProjectEntity("Casinhas para cachorros de rua", "Ajude nós a acolher esses cachorros de rua com casinhas reciclaveis", joao, ProjectType.PUBLIC));
        GoalEntity casinha1 = goalRepository.save(new GoalEntity("", valor("50.00"), cahorrosdeRua));
        GoalEntity casinha2 = goalRepository.save(new GoalEntity("", valor("20.00"), cahorrosdeRua));
        ContribuitionEntity c24 = contribuitionRepository.save(new ContribuitionEntity(marcos, casinha1, valor("20")));
        ContribuitionEntity c25 = contribuitionRepository.save(new ContribuitionEntity(julio, casinha2, valor("40")));

        ProjectEntity roupeiro = projectRepository.save(new ProjectEntity("", "Preciso muito de um guarda roupa novo", catia, ProjectType.PRIVATE));
        GoalEntity entradaRoupeiro = goalRepository.save(new GoalEntity("Entrada", valor("650.00"), roupeiro));
        GoalEntity parcelasRoupeiro = goalRepository.save(new GoalEntity("Parcelas", valor("200.00"), roupeiro));
        ContribuitionEntity c26 = contribuitionRepository.save(new ContribuitionEntity(catia, parcelasRoupeiro, valor("50")));
        ContribuitionEntity c27 = contribuitionRepository.save(new ContribuitionEntity(catia, parcelasRoupeiro, valor("120")));

        ProjectEntity oculos = projectRepository.save(new ProjectEntity("", "meu grau aumentou, preciso de um óculos novo", fran, ProjectType.SHARED, Arrays.asList(marcos)));
        GoalEntity entradaoOculos = goalRepository.save(new GoalEntity("Entrada", valor("100.00"), oculos));
        GoalEntity parcelasOculos1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("100.00"), oculos));
        GoalEntity parcelasOculos2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("100.00"), oculos));
        ContribuitionEntity c28 = contribuitionRepository.save(new ContribuitionEntity(catia, parcelasOculos1, valor("50")));
        ContribuitionEntity c29 = contribuitionRepository.save(new ContribuitionEntity(eduarda, parcelasOculos2, valor("20")));

        ProjectEntity camera = projectRepository.save(new ProjectEntity("camera dos sonhos", "", luis, ProjectType.PRIVATE));
        GoalEntity entradacamera = goalRepository.save(new GoalEntity("Entrada", valor("200.00"), camera));
        GoalEntity parcelascamera = goalRepository.save(new GoalEntity("Parcelas", valor("500.00"), camera));
        ContribuitionEntity x1 = contribuitionRepository.save(new ContribuitionEntity(luis, parcelascamera, valor("100")));
        ContribuitionEntity x2 = contribuitionRepository.save(new ContribuitionEntity(luis, parcelascamera, valor("50")));

        ProjectEntity celularnovo = projectRepository.save(new ProjectEntity("meu iphone novo", "YBR125", carla, ProjectType.SHARED, Arrays.asList(luis)));
        GoalEntity entradacelular = goalRepository.save(new GoalEntity("Entrada", valor("3500.00"), celularnovo));
        GoalEntity parcelascelular1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("550.00"), celularnovo));
        GoalEntity parcelascelular2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("100.00"), celularnovo));
        ContribuitionEntity x3 = contribuitionRepository.save(new ContribuitionEntity(luis, parcelascelular1, valor("1000")));
        ContribuitionEntity x4 = contribuitionRepository.save(new ContribuitionEntity(carla, entradacelular, valor("100")));

        ProjectEntity minhacasa = projectRepository.save(new ProjectEntity("Reforma da minha casa", "", amanda, ProjectType.PUBLIC));
        GoalEntity reformaBanheiro = goalRepository.save(new GoalEntity("Reforma Banheiro", valor("600.00"), minhacasa));
        GoalEntity reformaCozinha = goalRepository.save(new GoalEntity("Reforma Cozinha", valor("900.00"), minhacasa));
        GoalEntity reformaSala = goalRepository.save(new GoalEntity("Reforma Sala", valor("1000.00"), minhacasa));
        GoalEntity pinturaBanheiro = goalRepository.save(new GoalEntity("Pinturas em Geral", valor("300.00"), minhacasa));
        ContribuitionEntity x5 = contribuitionRepository.save(new ContribuitionEntity(marcos, reformaBanheiro, valor("300")));
        ContribuitionEntity x6 = contribuitionRepository.save(new ContribuitionEntity(roberto, reformaSala, valor("200")));

        ProjectEntity casacat = projectRepository.save(new ProjectEntity("casa para os gatinhos", "", Rosane, ProjectType.PRIVATE));
        GoalEntity entradacasacat = goalRepository.save(new GoalEntity("Entrada", valor("100.00"), casacat));
        GoalEntity parcelascasacat = goalRepository.save(new GoalEntity("Parcelas", valor("400.00"), casacat));
        ContribuitionEntity c7 = contribuitionRepository.save(new ContribuitionEntity(Rosane, parcelascasacat, valor("150")));
        ContribuitionEntity c8 = contribuitionRepository.save(new ContribuitionEntity(Rosane, parcelascasacat, valor("25")));

        ProjectEntity motog5splus = projectRepository.save(new ProjectEntity("Meu Sonho", "YBR125", Carol, ProjectType.SHARED, Arrays.asList(Carol)));
        GoalEntity entradaMotog5plus = goalRepository.save(new GoalEntity("Entrada", valor("500.00"), motog5splus));
        GoalEntity parcelasMotog5plus1 = goalRepository.save(new GoalEntity("Primeira parcela", valor("500.00"), motog5splus));
        GoalEntity parcelasMotog5plus2 = goalRepository.save(new GoalEntity("Segunda parcela", valor("500.00"), motog5splus));
        ContribuitionEntity z3 = contribuitionRepository.save(new ContribuitionEntity(marcos, parcelasMotog5plus1, valor("100")));
        ContribuitionEntity z4 = contribuitionRepository.save(new ContribuitionEntity(roberto, parcelasMotog5plus2, valor("10")));

        ProjectEntity raçãopet= projectRepository.save(new ProjectEntity("Ajude ração para pet", "pet e vida ajude", Luan, ProjectType.PUBLIC));
        GoalEntity raçãocatfilhote = goalRepository.save(new GoalEntity("Ração cat filhote ", valor("50.00"), raçãopet));
        GoalEntity raçãodogfilhote= goalRepository.save(new GoalEntity("ração dog  filhote", valor("50.00"), raçãopet));
        GoalEntity raçãocatadulto = goalRepository.save(new GoalEntity("Ração cat atuta", valor("100.00"), raçãopet));
        GoalEntity raçãodogadulto = goalRepository.save(new GoalEntity("Ração dog atuta", valor("100.00"), raçãopet));
        ContribuitionEntity q10 = contribuitionRepository.save(new ContribuitionEntity(marcos, raçãocatfilhote, valor("50")));
        ContribuitionEntity q9 = contribuitionRepository.save(new ContribuitionEntity(roberto, raçãodogfilhote, valor("50")));

        ProjectEntity mochiladabarby = projectRepository.save(new ProjectEntity("minha mochila da barby ", "", eduarda, ProjectType.PRIVATE));
        GoalEntity entradaMochiladabarby = goalRepository.save(new GoalEntity("Entrada", valor("50.00"), mochiladabarby));
        GoalEntity parcelasmochiladabarby = goalRepository.save(new GoalEntity("Parcelas", valor("50.00"), mochiladabarby));
        ContribuitionEntity m9 = contribuitionRepository.save(new ContribuitionEntity(Larisa, parcelasmochiladabarby, valor("50.00")));
        ContribuitionEntity m10 = contribuitionRepository.save(new ContribuitionEntity(eduarda, parcelasmochiladabarby, valor("25.00")));

        UserEntity xuliana = userRepository.save(new UserEntity("xuliana_mulher_do_pedro", "pedromozão"));
        ProjectEntity comprarcasa = projectRepository.save(new ProjectEntity("meu carro", "", xuliana, ProjectType.PRIVATE));
        GoalEntity entradacasa = goalRepository.save(new GoalEntity("Entrada", valor("5000.00"), comprarcasa));
        GoalEntity parcelascasa = goalRepository.save(new GoalEntity("Parcelas", valor("1000.00"), comprarcasa));
        ContribuitionEntity x23 = contribuitionRepository.save(new ContribuitionEntity(xuliana, entradacasa, valor("5000")));
        ContribuitionEntity x24 = contribuitionRepository.save(new ContribuitionEntity(xuliana, parcelascasa, valor("3000")));

        UserEntity pedrinho = userRepository.save(new UserEntity("pedrodrinho", "mcpedrinho"));
        ProjectEntity comprarcarronovo = projectRepository.save(new ProjectEntity("carro dos sonhos ", "", pedrinho, ProjectType.PRIVATE));
        GoalEntity entradacarronovo = goalRepository.save(new GoalEntity("Entrada", valor("5000.00"), comprarcarronovo));
        GoalEntity parcelascarronovo = goalRepository.save(new GoalEntity("Parcelas", valor("1000.00"), comprarcarronovo));
        ContribuitionEntity p28 = contribuitionRepository.save(new ContribuitionEntity(pedrinho, entradacarronovo, valor("5000")));
        ContribuitionEntity p29 = contribuitionRepository.save(new ContribuitionEntity(pedrinho, parcelascarronovo, valor("5000")));

        amanda.getFollowers().add(luis);
        amanda.getFollowers().add(carla);
        amanda.getFollowers().add(berenice);
        amanda.getFollowers().add(sandra);
        amanda.getFollowers().add(rafaela);
        amanda.getFollowers().add(julio);
        amanda.getFollowers().add(felizardo);
        amanda.getFollowers().add(joao);
        amanda.getFollowers().add(catia);
        amanda.getFollowers().add(fran);
        userRepository.save(amanda);

        carla.getFollowers().add(luis);
        carla.getFollowers().add(amanda);
        carla.getFollowers().add(berenice);
        carla.getFollowers().add(sandra);
        carla.getFollowers().add(rafaela);
        carla.getFollowers().add(julio);
        carla.getFollowers().add(felizardo);
        carla.getFollowers().add(joao);
        carla.getFollowers().add(catia);
        carla.getFollowers().add(fran);
        userRepository.save(carla);

        felizardo.getFollowers().add(luis);
        felizardo.getFollowers().add(carla);
        felizardo.getFollowers().add(amanda);
        felizardo.getFollowers().add(berenice);
        felizardo.getFollowers().add(sandra);
        felizardo.getFollowers().add(rafaela);
        felizardo.getFollowers().add(julio);
        felizardo.getFollowers().add(joao);
        felizardo.getFollowers().add(catia);
        felizardo.getFollowers().add(fran);
        userRepository.save(felizardo);

        berenice.getFollowers().add(luis);
        berenice.getFollowers().add(carla);
        berenice.getFollowers().add(amanda);
        berenice.getFollowers().add(sandra);
        berenice.getFollowers().add(rafaela);
        berenice.getFollowers().add(julio);
        berenice.getFollowers().add(felizardo);
        berenice.getFollowers().add(joao);
        berenice.getFollowers().add(catia);
        berenice.getFollowers().add(fran);
        userRepository.save(berenice);

        fran.getFollowers().add(luis);
        fran.getFollowers().add(carla);
        fran.getFollowers().add(amanda);
        fran.getFollowers().add(berenice);
        fran.getFollowers().add(sandra);
        fran.getFollowers().add(rafaela);
        fran.getFollowers().add(julio);
        fran.getFollowers().add(felizardo);
        fran.getFollowers().add(joao);
        fran.getFollowers().add(catia);
        userRepository.save(fran);

        joao.getFollowers().add(luis);
        joao.getFollowers().add(carla);
        joao.getFollowers().add(amanda);
        joao.getFollowers().add(berenice);
        joao.getFollowers().add(sandra);
        joao.getFollowers().add(rafaela);
        joao.getFollowers().add(julio);
        joao.getFollowers().add(felizardo);
        joao.getFollowers().add(catia);
        joao.getFollowers().add(fran);
        userRepository.save(joao);

        julio.getFollowers().add(luis);
        julio.getFollowers().add(carla);
        julio.getFollowers().add(amanda);
        julio.getFollowers().add(berenice);
        julio.getFollowers().add(sandra);
        julio.getFollowers().add(rafaela);
        julio.getFollowers().add(felizardo);
        julio.getFollowers().add(joao);
        julio.getFollowers().add(catia);
        julio.getFollowers().add(fran);
        userRepository.save(julio);

        luis.getFollowers().add(sandra);
        luis.getFollowers().add(carla);
        luis.getFollowers().add(amanda);
        luis.getFollowers().add(berenice);
        luis.getFollowers().add(rafaela);
        luis.getFollowers().add(julio);
        luis.getFollowers().add(felizardo);
        luis.getFollowers().add(joao);
        luis.getFollowers().add(catia);
        luis.getFollowers().add(fran);
        userRepository.save(luis);

        rafaela.getFollowers().add(luis);
        rafaela.getFollowers().add(carla);
        rafaela.getFollowers().add(amanda);
        rafaela.getFollowers().add(berenice);
        rafaela.getFollowers().add(sandra);
        rafaela.getFollowers().add(julio);
        rafaela.getFollowers().add(felizardo);
        rafaela.getFollowers().add(joao);
        rafaela.getFollowers().add(catia);
        rafaela.getFollowers().add(fran);
        userRepository.save(rafaela);

        sandra.getFollowers().add(luis);
        sandra.getFollowers().add(carla);
        sandra.getFollowers().add(amanda);
        sandra.getFollowers().add(berenice);
        sandra.getFollowers().add(rafaela);
        sandra.getFollowers().add(julio);
        sandra.getFollowers().add(felizardo);
        sandra.getFollowers().add(joao);
        sandra.getFollowers().add(catia);
        sandra.getFollowers().add(fran);
        userRepository.save(sandra);

        catia.getFollowers().add(luis);
        catia.getFollowers().add(carla);
        catia.getFollowers().add(amanda);
        catia.getFollowers().add(berenice);
        catia.getFollowers().add(sandra);
        catia.getFollowers().add(rafaela);
        catia.getFollowers().add(julio);
        catia.getFollowers().add(felizardo);
        catia.getFollowers().add(joao);
        catia.getFollowers().add(fran);
        userRepository.save(catia);

        pedrinho.getFollowers().add(luis);
        pedrinho.getFollowers().add(carla);
        pedrinho.getFollowers().add(amanda);
        pedrinho.getFollowers().add(berenice);
        pedrinho.getFollowers().add(sandra);
        pedrinho.getFollowers().add(rafaela);
        pedrinho.getFollowers().add(julio);
        pedrinho.getFollowers().add(felizardo);
        pedrinho.getFollowers().add(joao);
        pedrinho.getFollowers().add(catia);
        pedrinho.getFollowers().add(fran);
        pedrinho.getFollowers().add(evandro);
        pedrinho.getFollowers().add(eduarda);
        pedrinho.getFollowers().add(marcos);
        pedrinho.getFollowers().add(sandra);
        userRepository.save(pedrinho);
    }


    private BigDecimal valor(String value) {
        return  new BigDecimal(value);
    }
}