package com.badlogic.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle  extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    float x, y, width, height;
    float dy;

    public Paddle(float x, float y, int with, int height){
        this.x = x;
        this.y = y;
        this.width = with;
        this.height = height;
        this.dy = 0;
    }

    public void update(float delta){
        if (this.dy < 0) {this.y = Math.max(0, this.y + this.dy * delta);}
        else {this.y = Math.min(720 - this.height,
                    this.y + this.dy * delta);}
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
