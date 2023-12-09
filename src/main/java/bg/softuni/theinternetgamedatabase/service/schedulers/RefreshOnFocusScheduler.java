package bg.softuni.theinternetgamedatabase.service.schedulers;

import bg.softuni.theinternetgamedatabase.service.GameService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RefreshOnFocusScheduler {

    private final GameService gameService;

    public RefreshOnFocusScheduler(GameService gameService) {
        this.gameService = gameService;
    }

    @Scheduled(cron = "* * */12 * * *")
    public void refreshOnFocus() {
        this.gameService.refreshOnFocus();
    }
    @Scheduled(cron = "* * */24 * * *")
    public void clearViews() {
        this.gameService.clearViews();
    }
}
