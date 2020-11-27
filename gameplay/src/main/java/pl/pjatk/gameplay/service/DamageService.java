package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import java.util.Optional;

@Service
public class DamageService {
    private PlayerService playerService;

    public DamageService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Player damage(Long idAttack, Long idVictim) {
        Optional<Player> victim = playerService.findById(idVictim);
        Optional<Player> attacker = playerService.findById(idAttack);

        if(attacker.isPresent() && victim.isPresent()) {
            victim.get().setHealth(victim.get().getHealth() - attacker.get().getAttack());

            return playerService.save(victim.get());
        } else {
            return null;
        }
    }
}
