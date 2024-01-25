package com.badlogic.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle  extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    float Rectx, Recty, RectWith, Rectheight;
    float dy;

    public Paddle(float x, float y, int with, int height){
        this.Rectx = x;
        this.Recty = y;
        this.RectWith = with;
        this.Rectheight = height;
        this.dy = 0;
    }

    public void update(float delta){
        if (this.dy < 0) {this.Recty = Math.max(0, this.Recty + this.dy * delta);}
        else {this.Recty = Math.min(480 - this.Rectheight,
                    this.Recty + this.dy * delta);}
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
        shapeRenderer.rect(Rectx, Recty,RectWith,Rectheight);
        //to render a shape we will need to end the construction
        shapeRenderer.end();
    }

    @Override
    public void dispose () {
        shapeRenderer.dispose();
    }


}
