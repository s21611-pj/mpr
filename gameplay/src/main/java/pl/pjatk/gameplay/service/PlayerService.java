package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll(){
        return  playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1L,"Wojtek",100, 10, 5));
        players.add(new Player(2L,"Jasiu",100, 10, 5));
        players.add(new Player(3L,"Stachu",100, 10, 5));

        players.forEach(player -> {
            player.setMana(10);
        });

        return players.stream().filter(player -> player.getId().equals(id)).findFirst();

//        for(Player player : players) {
//            if(player.getId() == id) {
//                return player;
//            }
//        }
//        return new Player();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }
}
