package cda.screens.game;

/**
 * répresente une tileMap scrollable avec sa propre caméra.
 * 
 * @author robin
 *
 */

public class TiledMapScrolling
{
//	private OrthographicCamera cam;
//	private TiledMapRenderer tiledMapRenderer;
	private float speed;

	public TiledMapScrolling(float speed)
	{
		this.speed = speed;
//		SpriteBatch batch = new SpriteBatch();
//		TiledMap tiledMap = new TmxMapLoader().load("maps/map.tmx");
//		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, batch);
//
//		cam = new OrthographicCamera(Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
//		cam.position.set(Global.SCREEN_WIDTH / 2f - 112f, Global.SCREEN_HEIGHT / 2f, 0);
//		batch.setProjectionMatrix(cam.combined);
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}

	public void update(float delta)
	{
//		cam.translate(0, speed * delta);
//		cam.update();
	}

	public void render()
	{
//		tiledMapRenderer.setView(cam);
//		tiledMapRenderer.render();
	}

}
