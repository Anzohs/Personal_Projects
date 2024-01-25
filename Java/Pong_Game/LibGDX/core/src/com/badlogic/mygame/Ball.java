package com.badlogic.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    float x, y, width, height;
    float dy;
    float dx;

    public Ball(float x, float y, float with, float height){
        this.x = x;
        this.y = y;
        this.width = with;
        this.height = height;
        this.dy = 0;
        this.dx = 0;
    }

    public void update(float dt){
       this.x = this.x + this.dx * dt;
       this.y = this.y + this.dy * dt;
    }

    public boolean collides(Paddle paddle){
        if (this.x > paddle.x + paddle.width || paddle.x > this.x + this.width){return false;}
        if (this.y > paddle.y + paddle.height || paddle.y > this.y + this.height){return false;}
        return true;
    }

    public void reset(){
        this.x = 640.0f - (this.width - 5);
        this.y = 360.0f - (this.height -5);
        this.dx = 0;
        this.dy = 0;
    }

    @Override
    public void create(){
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(){

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //the RBGA will go from 0 to 1
        shapeRenderer.setColor(1,1,1,1);
        shapeRenderer.rect(x, y, width, height);
        //to render a shape we will need to end the construction
        shapeRenderer.end();
    }

    @Override
    public void dispose () {
        shapeRenderer.dispose();
    }


}
