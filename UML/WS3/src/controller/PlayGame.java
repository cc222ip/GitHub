package controller;

import model.Game;
import view.IView;

public class PlayGame {
	public boolean Play(Game a_game, IView a_view) {
		a_view.DisplayWelcomeMessage();

		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

		a_view.DisplayBuffer();
		
		if (a_game.IsGameOver()) {
			a_view.DisplayGameOver(a_game.IsDealerWinner());
		}

		int input = a_view.GetInput();

		if (input == 'p') {
			a_game.NewGame();
		} else if (input == 'h') {
			a_game.Hit();

		} else if (input == 's') {
			 a_game.Stand();

		}

		return input != 'q';
	}
}