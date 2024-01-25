package com.badlogic.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    float Rectx, Recty, RectWith, Rectheight;

    public Ball(float x, float y, float with, float height){
        this.Rectx = x;
        this.Recty = y;
        this.RectWith = with;
        this.Rectheight = height;
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
