package cda.screens;

/**
 * Factory of screens
 * 
 * @author robin
 *
 */
public class ScreenFactory
{
	public static final int SCOREBOARD_SCREEN = 0;
	public static final int MENU_SCREEN = 1;
	public static final int GAME_SCREEN = 2;
	
	private ScreenFactory()
	{
		// factory can't be instanced
	}
	
//	public static Screen createScreen(int screenType)
//	{
//		if (screenType < 0 || screenType > 2)
//		{
//			throw new IllegalArgumentException("ScreenType not supported : " + screenType);
//		}
//		else
//		{
//			switch (screenType)
//			{
//				case 0:
//					return new LoadingScreen(controler, controler.getBatch());
//				case 1 : 
//					return new MenuScreen(controler, controler.getBatch());
//				case 2 : 
//					return new GamePlayScreen(controler, controler.getBatch());
//				default:
//					return null; // should not be the case
//			}
//		}
//	}

}
