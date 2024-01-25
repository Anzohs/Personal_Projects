package com.badlogic.mygame;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HelloWorldGame extends ApplicationAdapter{
    Paddle paddle;
    Paddle paddle2;
    Ball ball;
    OrthographicCamera camera;
    int PADDLE_SPEED = 200;

    @Override
    public void create(){
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);

        paddle = new Paddle(10, camera.viewportHeight / 2,20,50);
        paddle.create();
        paddle2 = new Paddle(camera.viewportWidth - 30 ,(camera.viewportHeight / 2) - 50 ,
                20,50);
        paddle2.create();
        ball = new Ball((camera.viewportWidth/2) -  4, (camera.viewportHeight/2) - 4,
                8,8);
        ball.create();

    }

    public void update(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){paddle.dy = PADDLE_SPEED;}
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){paddle.dy = -PADDLE_SPEED;}
        else {paddle.dy = 0;}

        if (Gdx.input.isKeyPressed(Input.Keys.W)){paddle2.dy = PADDLE_SPEED;}
        else if (Gdx.input.isKeyPressed(Input.Keys.S)){paddle2.dy = -PADDLE_SPEED;}
        else {paddle2.dy = 0;}

        paddle.update(dt);
        paddle2.update(dt);
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
