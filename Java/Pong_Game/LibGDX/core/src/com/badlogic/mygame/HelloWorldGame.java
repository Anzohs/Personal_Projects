package com.badlogic.mygame;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HelloWorldGame extends ApplicationAdapter{
    Paddle paddle;
    Paddle paddle2;
    Ball ball;
    OrthographicCamera camera;
    ExtendViewport viewport;
    int PADDLE_SPEED = 400;

    @Override
    public void create(){
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        paddle2 = new Paddle(10, 30, 15,70);
        paddle2.create();
        paddle = new Paddle(camera.viewportWidth - 25 ,(camera.viewportHeight - 80) ,
                15,70);
        paddle.create();
        ball = new Ball( (camera.viewportWidth/2)-  5, (camera.viewportHeight/2) - 5,
                10,10);
        ball.create();
    }

    public void update(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){Gdx.app.exit();}
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){ball.dy = Math.random() < 0.5 ? 50 : -50;
        ball.dx = Math.random() < 0.5 ? 200 : -200;}
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){ball.reset();}

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){paddle.dy = PADDLE_SPEED;}
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){paddle.dy = -PADDLE_SPEED;}
        else {paddle.dy = 0;}

        if (Gdx.input.isKeyPressed(Input.Keys.W)){paddle2.dy = PADDLE_SPEED;}
        else if (Gdx.input.isKeyPressed(Input.Keys.S)){paddle2.dy = -PADDLE_SPEED;}
        else {paddle2.dy = 0;}

        if(ball.collides(paddle2)) {
            ball.dx = -ball.dx * 1.03f;
            ball.x = paddle2.x + 20;
        }

         if (ball.collides(paddle)) {
             ball.dx = - ball.dx * 1.03f;
             ball.x = paddle.x - 19;
        }

         if (ball.y <= 0){
             ball.y = 0;
             ball.dy = -ball.dy;
         }

         if (ball.y >= camera.viewportHeight - ball.height){
             ball.y = camera.viewportHeight - ball.height;
             ball.dy = -ball.dy;
         }

        paddle.update(dt);
        paddle2.update(dt);
        ball.update(dt);
    }

    @Override
    public void render(){
        camera.update();
        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        paddle.render();
        paddle2.render();
        ball.render();
    }

    @Override
    public void dispose () {
        paddle.dispose();
        paddle2.dispose();
        ball.dispose();
    }

}
