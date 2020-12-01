package pl.pjatk.gameplay.player.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.DamageService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DamageServiceTest {
    private final DamageService damageService = new DamageService();

    @Test
    void shouldMakeMoreAttack(){
        //given
        Player player = new Player("test player", 100, 100, 10);
        //when
        damageService.morePowerOfAttack(player, 30);
        //then
        assertThat(player.getAttack()).isEqualTo(30);
    }

    @Test
    void shouldMakeZeroAttack(){
        //given
        Player player = new Player("test player", 100, 100, 10);
        //when
        damageService.morePowerOfAttack(player, 0);
        //then
        assertThat(player.getAttack()).isZero();
    }

    @Test
    void shouldChangeNickName(){
        //given
        Player player = new Player("test player", 100, 100, 10);
        //when
        damageService.changeNickname(player, "1234567890");
        //then
        assertThat(player.getNickname()).isEqualTo("1234567890");
    }

    @Test
    void shouldNotChangeNickName(){
        //given
        Player player = new Player("test player", 100, 100, 10);
        //when
        damageService.changeNickname(player, "qwertaaaaaaaaaaaaaa");
        //then
//        assertThat(player.()).isEqualTo("test player");
        assertThat(player.getNickname().length()).isGreaterThan(10);


    }








}
