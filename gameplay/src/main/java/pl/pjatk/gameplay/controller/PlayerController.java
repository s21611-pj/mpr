package pl.pjatk.gameplay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.DamageService;
import pl.pjatk.gameplay.service.PlayerService;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private DamageService damageService;

    public PlayerController(PlayerService playerService, DamageService damageService) {
        this.playerService = playerService;
        this.damageService = damageService;
    }
    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Player>> findById(@PathVariable int id) {
//        return ResponseEntity.ok(playerService.findById(id));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Player>> findById(@PathVariable Long id) {
        Optional<Player> byId = playerService.findById(id);
        if(byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.save(player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@RequestBody Player player, @PathVariable Long id) {
        return ResponseEntity.ok(playerService.update(id, player));
    }

    @PutMapping("/{idAttacker}/{idVictim}")
    public ResponseEntity<Player> damage(@PathVariable Long idAttacker, @PathVariable Long idVictim) {
        return ResponseEntity.ok(damageService.damage(idAttacker, idVictim));
    }
}
